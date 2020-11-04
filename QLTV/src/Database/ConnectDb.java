/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tudv
 */
public class ConnectDb {
    public static Connection connectDB() {
        Connection conn1 = null;
        try {
            String url1 = "jdbc:mysql://localhost/quan_ly_thu_vien";
            String user = "root";
            String password = "";	
            conn1 = DriverManager.getConnection(url1, user, password);
        }catch(Exception ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return conn1;
    }
    public static void main(String []args) {
        if(ConnectDb.connectDB() != null){
            System.out.println("aaaaaaaaaaaaaa");
        };
    }
}
