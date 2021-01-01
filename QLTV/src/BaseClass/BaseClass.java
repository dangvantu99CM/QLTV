/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseClass;

import Database.ConnectDb;
import View.Thong_bao.Message;
import java.sql.Connection;

/**
 *
 * @author tudv
 */
public class BaseClass {

    public static Connection getConnectDb() {
        Connection con = ConnectDb.connectDB();
        return con != null ? con : null;
    }

    public static Message getMessage() {
        Message mess = new Message();
        return mess;
    }
}
