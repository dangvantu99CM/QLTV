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
import Model.Da.UserExtension;
import View.Thong_bao.Message;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tudv
 */
public class BookDA implements MyInterface {

    public BookDA() {
    }

    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();

    public static ArrayList<Book> listBook = new ArrayList<Book>();

    @Override
    public ArrayList getAll() {
        ArrayList<UserExtension> listUser = new ArrayList<UserExtension>();
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            try {
                String sql = "SELECT * FROM book where deleted_at is null ";
                Statement stmt;
                stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt(1));
                    book.setStoreID(rs.getInt(3));
                    book.setName(rs.getString(2));
                    book.setType(rs.getInt(6));
                    book.setBookPrice(rs.getDouble(11));
                    book.setDeletedAt(rs.getString(12));
                    book.setAuthor(rs.getString(4));
                    listBook.add(book);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listUser;
    }

    public Book getBookByID(int id) throws SQLException {
        Book book = null;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            String sql = "SELECT * FROM book WHERE id = ? AND deleted_at is null";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt(1));
                book.setStoreID(rs.getInt(3));
                book.setName(rs.getString(2));
                book.setType(rs.getInt(6));
                book.setBookPrice(rs.getDouble(11));
                book.setDeletedAt(rs.getString(12));
                book.setAuthor(rs.getString(4));
            }
        }
        return book;
    }

    @Override
    public Book create(Object item) {

        return null;
    }

    @Override
    public Book delete(int id) {

        return null;
    }

    @Override
    public Book update(Object item) {

        return null;
    }

    public static void main(String[] args) throws SQLException {
        UserDA qe = new UserDA();
        ArrayList<UserExtension> listUser = qe.getAll();
        for (UserExtension u : listUser) {
            System.out.println(u.getMasv());
        }
        //qe.delete(23);
    }

}
