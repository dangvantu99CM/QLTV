/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import BaseClass.BaseClass;
import Model.Da.User;
import Database.ConnectDb;
import Interface.MyInterface;
import Model.Da.UserBook;
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
public class UserBookDA implements MyInterface {

    public UserBookDA() {
    }

    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();

    public static ArrayList<UserBook> listUserBook = null;

    @Override
    public ArrayList getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object create(Object item) {
        UserBook userBook = (UserBook) item;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            String sql = "INSERT INTO user_book ("
                    + "us_id, "
                    + "bo_id,"
                    + "date_borrow ,"
                    + "status"
                    + ") "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement stmt;
            try {
                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setInt(1, userBook.getUs_id());
                stmt.setInt(2, userBook.getBo_id());
                stmt.setString(3, userBook.getDate_borrow());
                stmt.setInt(4, userBook.getStatus());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
            return userBook;
        }
        return null;
    }

    @Override
    public Object delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object update(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
