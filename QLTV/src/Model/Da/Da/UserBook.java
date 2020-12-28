/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import Model.Da.User;
import Database.ConnectDb;
import Interface.UserInterface.MyInterface;
import View.Thong_bao.Message;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tudv
 */
public class UserBook implements MyInterface {

    public UserBook() {}

    private Connection con = ConnectDb.connectDB();
    public static ArrayList<UserBook> listUserBook = null;
    private Message mess = new Message();

    @Override
    public ArrayList getAll() {
        return listUserBook;
    }

    public boolean create(int id) {
        return false;
    }

    @Override
    public Object create(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
