package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private static Connection connection;
    private ConnectionJDBC(){
    };
    public static final String URlJBDC = "jdbc:mysql://localhost:3306/products";
    public static final String UserJDBC = "root";
    public static final String PASSWORDJDBC = "123456";

    public static Connection getConnect() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection  = DriverManager.getConnection(URlJBDC, UserJDBC, PASSWORDJDBC);
                System.out.println("Ok Mennnnnnnnnnnnnnnnnnnnnnn");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Wrongggggggggggggggggggggggggggggg");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  connection;
    }
}