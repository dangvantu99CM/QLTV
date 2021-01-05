/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.StoreCore;

import BaseClass.BaseClass;
import Model.Da.Book;
import Model.Da.Da.BookDA;
import Model.Da.Da.UserDA;
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

    /**
     *
     * @param from_date: Lọc theo thời gian từ ngày bao nhiêu theo định dạng
     * (YYYYMMDD HHMMSS)
     * @param to_date: Lọc theo thời gian den ngày bao nhiêu theo định dạng
     * (YYYYMMDD HHMMSS)
     * @param status : loc theo trang thai : dang muon , da tra, qua han
     * @return Danh sach User phu hop
     */
    public ArrayList filterBook(String from_date, String to_date, String status, String store_id) throws SQLException {
        ArrayList<Book> result = new ArrayList<Book>();
        String sql = "";
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
                        sql = "SELECT * "
                                + "FROM book "
                                + "WHERE book.bo_status = ? "
                                + "AND create_at  >= ? "
                                + "AND create_at  <= ? "
                                + " AND deleted_at is null "
                                + " AND bo_id_store = ? ";
                        flag = 1;
                        System.out.println("ssssssssssssssssss");
                    } else {
                        sql = "SELECT * "
                                + "FROM book "
                                + "WHERE book.bo_status = ? "
                                + "AND create_at >= ? "
                                + "AND create_at <= ? "
                                + " AND deleted_at is null ";
                        flag = 2;
                    }

                } else {
                    if (!store_id.equals("")) {
                        sql = "SELECT * "
                                + "FROM book "
                                + "WHERE create_at >= ? "
                                + "AND create_at <= ? "
                                + " AND deleted_at is null "
                                + " AND bo_id_store = ? ";
                        flag = 3;
                    } else {
                        sql = "SELECT * "
                                + "FROM book "
                                + "WHERE create_at >= ? "
                                + "AND create_at <= ? "
                                + " AND deleted_at is null ";
                        flag = 4;
                    }
                }
            } else if (!status.equals("")) {
                if (!store_id.equals("")) {
                    sql = "SELECT * "
                            + "FROM book "
                            + "WHERE book.bo_status = ? "
                            + " AND deleted_at is null "
                            + " AND bo_id_store = ? ";
                    flag = 5;
                } else {
                    sql = "SELECT * "
                            + "FROM book "
                            + "WHERE book.bo_status = ? "
                            + " AND deleted_at is null ";
                    flag = 6;
                }
            } else if (!store_id.equals("")) {
                sql = "SELECT * "
                        + "FROM book "
                        + "WHERE deleted_at is null "
                        + " AND bo_id_store = ? ";
                flag = 7;
            } else {
                return baseListBook;
            }

            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            switch (flag) {
                case 1:
                    stmt.setInt(1, Integer.valueOf(status));
                    stmt.setString(2, from_date);
                    stmt.setString(3, to_date);
                    stmt.setInt(4, Integer.valueOf(store_id));
                    break;
                case 2:
                    stmt.setInt(1, Integer.valueOf(status));
                    stmt.setString(2, from_date);
                    stmt.setString(3, to_date);
                    break;
                case 3:
                    stmt.setString(1, from_date);
                    stmt.setString(2, to_date);
                    stmt.setInt(3, Integer.valueOf(store_id));
                    break;
                case 4:
                    stmt.setString(1, from_date);
                    stmt.setString(2, to_date);
                    break;
                case 5:
                    stmt.setInt(1, Integer.valueOf(status));
                    stmt.setInt(2, Integer.valueOf(store_id));
                    break;
                case 6:
                    stmt.setInt(1, Integer.valueOf(status));
                    break;
                case 7:
                    stmt.setInt(1, Integer.valueOf(store_id));
                    break;
                default:
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(4));
                book.setNumber(rs.getInt(7));
                book.setEmptyNumber(rs.getInt(14));
                result.add(book);
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) throws SQLException {
        SearchOrFilter se = new SearchOrFilter();
        ArrayList<Book>liBo = new ArrayList<Book>();
        liBo = se.filterBook("2020-12-01 17:01:05","2020-12-30 17:01:05","1","1");
        System.out.println("sssss == " + liBo.size());
        for(Book bo:liBo){
            System.out.println(bo.toString());
        }
    }

}
