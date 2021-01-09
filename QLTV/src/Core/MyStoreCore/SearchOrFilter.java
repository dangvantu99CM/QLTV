/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.MyStoreCore;

import BaseClass.BaseClass;
import Model.Da.Book;
import Model.Da.BookExtension;
import Model.Da.Da.BookDA;
import Model.Da.UserExtension;
import View.Thong_bao.Message;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tudv
 */
public class SearchOrFilter {

    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();

    private BookDA bookDA = new BookDA();

    private ArrayList<Book> baseListBook = bookDA.getAll();

    public ArrayList filterBook(int us_id, String from_date, String to_date, String status, String store_id) throws SQLException {
        ArrayList<BookExtension> listResult = new ArrayList<>();
        String sql = "SELECT * FROM user_book "
                + " JOIN book on user_book.bo_id = book.id "
                + " JOIN store on book.bo_id_store = store.id ";
        int flag = 0;
        if ((from_date.equals("") && !to_date.equals("")) || (!from_date.equals("") && to_date.equals(""))) {
            mess.showMessage("error", "Hay chon khoang thoi gian can loc");
            return baseListBook;
        }
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return baseListBook;
        } else {
            if (!from_date.equals("") && !to_date.equals("")) {
                if (!status.equals("")) {
                    if (!store_id.equals("")) {
                        sql += " WHERE user_book.date_borrow >= ? "
                                + " AND user_book.date_borrow <= ? "
                                + " AND user_book.status = ? "
                                + " AND store.id = ? ";
                        System.out.println("11111111111111");
                        flag = 1;
                    } else {
                        sql += " WHERE user_book.date_borrow >= ? "
                                + " AND user_book.date_borrow <= ? "
                                + " AND user_book.status = ? ";
                        flag = 2;
                        System.out.println("2222222222222");
                    }

                } else {
                    if (!store_id.equals("")) {
                        sql += " WHERE user_book.date_borrow >= ? "
                                + " AND user_book.date_borrow <= ? "
                                + " AND store.id = ? ";
                        System.out.println("3333333333333");
                        flag = 3;
                    } else {
                        sql += " WHERE user_book.date_borrow >= ? "
                                + " AND user_book.date_borrow <= ? ";
                        flag = 4;
                        System.out.println("4444444444");
                    }
                }
            } else if (!status.equals("")) {
                if (!store_id.equals("")) {
                    sql += " WHERE user_book.status = ? "
                            + " AND store.id = ? ";
                    System.out.println("5555555555");
                    flag = 5;
                } else {
                    sql += " WHERE user_book.status = ? ";
                    System.out.println("66666666666666666");
                    flag = 6;
                }
            } else if (!store_id.equals("")) {
                sql += " WHERE store.id = ? ";
                System.out.println("77777777777777");
                flag = 7;
            }
            if (flag != 0) {
                sql += " AND user_book.us_id = ? AND user_book.delete_at is null ";
            } else {
                sql += " WHERE user_book.us_id = ? AND user_book.delete_at is null ";
            }

            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            switch (flag) {
                case 1:
                    stmt.setInt(3, Integer.valueOf(status));
                    stmt.setString(1, from_date);
                    stmt.setString(2, to_date);
                    stmt.setInt(4, Integer.valueOf(store_id));
                    stmt.setInt(5, us_id);
                    break;
                case 2:
                    stmt.setInt(3, Integer.valueOf(status));
                    stmt.setString(1, from_date);
                    stmt.setString(2, to_date);
                    stmt.setInt(4, us_id);
                    break;
                case 3:
                    stmt.setString(1, from_date);
                    stmt.setString(2, to_date);
                    stmt.setInt(3, Integer.valueOf(store_id));
                    stmt.setInt(4, us_id);
                    break;
                case 4:
                    stmt.setString(1, from_date);
                    stmt.setString(2, to_date);
                    stmt.setInt(3, us_id);
                    break;
                case 5:
                    stmt.setInt(1, Integer.valueOf(status));
                    stmt.setInt(2, Integer.valueOf(store_id));
                    stmt.setInt(3, us_id);
                    break;
                case 6:
                    stmt.setInt(1, Integer.valueOf(status));
                    stmt.setInt(2, us_id);
                    break;
                case 7:
                    stmt.setInt(1, Integer.valueOf(store_id));
                    stmt.setInt(2, us_id);
                    break;
                default:
                    stmt.setInt(1, us_id);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BookExtension book = new BookExtension();
                book.setId(rs.getInt(3));
                book.setName(rs.getString(12));
                book.setAuthor(rs.getString(14));
                book.setStoreName(rs.getString(27));
                book.setDateBorrow(rs.getString(4));
                book.setStatus(rs.getInt(6));
                book.setBookDateLimit(rs.getInt(18));
                book.setId_user_book(rs.getInt(1));
                listResult.add(book);
            }
        }
        return listResult;
    }

    public ArrayList searchBook(int us_id, String nameBook) throws SQLException {
        ArrayList<BookExtension> listResult = new ArrayList<>();
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            String sql = "SELECT * FROM user_book "
                    + " JOIN book on user_book.bo_id = book.id "
                    + " JOIN store on book.bo_id_store = store.id "
                    + "WHERE us_id = ? AND book.bo_name = ? AND delete_at is null";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, us_id);
            stmt.setString(2, nameBook);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BookExtension book = new BookExtension();
                book.setId(rs.getInt(3));
                book.setName(rs.getString(12));
                book.setAuthor(rs.getString(14));
                book.setStoreName(rs.getString(27));
                book.setDateBorrow(rs.getString(4));
                book.setStatus(rs.getInt(6));
                book.setBookDateLimit(rs.getInt(18));
                book.setId_user_book(rs.getInt(1));
                listResult.add(book);
            }
        }
        return listResult;
    }

    public static void main(String[] args) {
        SearchOrFilter se = new SearchOrFilter();

    }

}
