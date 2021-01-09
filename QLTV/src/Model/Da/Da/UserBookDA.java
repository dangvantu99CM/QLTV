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
import Model.Da.Book;
import Model.Da.BookExtension;
import Model.Da.Store;
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

    private StoreDA storeDa = new StoreDA();
    
    private String baseSql = "SELECT * FROM user_book "
                    + " JOIN book on user_book.bo_id = book.id "
                    + " JOIN store on book.bo_id_store = store.id ";

    @Override
    public ArrayList getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Object item) {
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
                int count = stmt.executeUpdate();
                if (count > 0) {
                    updateStoreIfBrrow(userBook.getBo_id());
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(int id, Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean updateStoreIfBrrow(int bo_id) throws SQLException {
        String sql = "SELECT store.* FROM book join store on book.bo_id_store = store.id where book.id = ? AND store.deleted_at is null AND book.deleted_at is null";
        java.sql.PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, bo_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int st_slot_current = rs.getInt(8) + 1;
            int st_slot_empty = rs.getInt(7) - st_slot_current;
            String sql1 = "update store set st_slot_current =?,st_slot_empty =? where id = ? AND store.deleted_at is null";
            java.sql.PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1 = (PreparedStatement) con.prepareStatement(sql1);
            stmt1.setInt(1, st_slot_current);
            stmt1.setInt(2, st_slot_empty);
            stmt1.setInt(3, rs.getInt(1));
            int count = stmt1.executeUpdate();
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean updateStatus(int id, int status, int soNgayQuaHan, double phat) throws SQLException {
        String sql = "update user_book set status =?,so_ngay_qua_han =?,VND_recoup =? where id = ? AND user_book.delete_at is null";
        java.sql.PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, status);
        stmt.setInt(2, soNgayQuaHan);
        stmt.setDouble(3, phat);
        stmt.setInt(4, id);
        int count = stmt.executeUpdate();
        if (count > 0) {
            return true;
        }
        return false;
    }

    public ArrayList getAllByUserID(int us_id) throws SQLException {
        ArrayList<BookExtension> listBook = new ArrayList<>();
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            String sql = baseSql+" WHERE us_id = ? AND delete_at is null";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, us_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BookExtension book = new BookExtension();
                book.setId(rs.getInt(3));
                book.setName(rs.getString(13));
                book.setAuthor(rs.getString(15));
                book.setStoreName(rs.getString(28));
                book.setDateBorrow(rs.getString(4));
                book.setStatus(rs.getInt(6));
                book.setBookDateLimit(rs.getInt(19));
                book.setId_user_book(rs.getInt(1));
                book.setTienPhat(rs.getDouble(7));
                listBook.add(book);
            }
        }
        return listBook;
    }

    public BookExtension getBookExtension(int bo_us_id) throws SQLException {
        BookExtension book = null;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            String sql = baseSql+" WHERE user_book.id = ? AND user_book.delete_at  is null";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, bo_us_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                book = new BookExtension();
                book.setId(rs.getInt(3));
                book.setName(rs.getString(13));
                book.setAuthor(rs.getString(15));
                book.setStoreName(rs.getString(28));
                book.setDateBorrow(rs.getString(4));
                book.setStatus(rs.getInt(6));
                book.setBookDateLimit(rs.getInt(19));
                book.setId_user_book(rs.getInt(1));
                book.setTienPhat(rs.getDouble(7));
                book.setStoreID(rs.getInt(14));
            }
        }
        return book;
    }

    public static void main(String[] args) throws SQLException {
        UserBookDA u = new UserBookDA();
        ArrayList<BookExtension> listBook = u.getAllByUserID(38);
        System.out.println("sssssss == " + listBook.size());
        for (BookExtension b : listBook) {
            System.out.println(b.toString());
        }
    }
}
