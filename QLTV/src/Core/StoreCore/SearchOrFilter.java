/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.StoreCore;

import BaseClass.BaseClass;
import Model.Da.Book;
import Model.Da.BookExtension;
import Model.Da.Da.BookDA;
import Model.Da.Da.StoreDA;
import Model.Da.Da.UserDA;
import Model.Da.Store;
import Model.Da.UserExtension;
import View.Thong_bao.Message;
import com.mysql.jdbc.Statement;
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

    private StoreDA storeDA = new StoreDA();

    private String baseSql = "SELECT * FROM store where store.deleted_at is null ";

    private ArrayList<Store> baseListStore = null;

    /**
     *
     * @param msv
     * @param name
     * @return User tuong ung voi ma sinh vien , Hoac danh sach sinh vien trung
     * ten neu msv la rong
     */
    public ArrayList searchSrore(String name) throws SQLException {
        ArrayList<Store> result = new ArrayList<Store>();
        int flag = 0;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            String sql = "SELECT * FROM store where store.deleted_at is null and store.st_name  = ?";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Store store = new Store();
                store.setId(rs.getInt(1));
                store.setName(rs.getString(2));
                store.setPosition(rs.getString(3));
                store.setStatus(rs.getInt(4));
                store.setSt_max_slot(rs.getInt(7));
                store.setSt_slot_current(rs.getInt(8));
                store.setSt_slot_empty(rs.getInt(9));
                store.setDeleted_at(rs.getString(10));
                result.add(store);
            }
        }
        return result;
    }

    /**
     *
     * @param from_date: Lọc theo thời gian từ ngày bao nhiêu theo định dạng
     * (YYYYMMDD HHMMSS)
     * @param to_date: Lọc theo thời gian den ngày bao nhiêu theo định dạng
     * (YYYYMMDD HHMMSS)
     * @param status : loc theo trang thai : dang muon , da tra, qua han
     * @return Danh sach User phu hop
     */
    public ArrayList filterStore(String from_date, String to_date, String status) throws SQLException {
        ArrayList<Store> result = new ArrayList<Store>();
        baseListStore = storeDA.getAll();
        String sql = "";
        int flag = 0;
        if ((from_date.equals("") && !to_date.equals("")) || (!from_date.equals("") && to_date.equals(""))) {
            mess.showMessage("error", "Hay chon khoang thoi gian can loc");
            return baseListStore;
        }
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return baseListStore;
        } else {
            if (!from_date.equals("") && !to_date.equals("")) {
                if (!status.equals("")) {
                    sql = baseSql + " AND store.st_status = ? "
                            + " AND store.created_at  >= ? "
                            + " AND store.created_at  <= ? ";
                    flag = 1;
                } else {
                    sql = baseSql + " AND store.created_at  >= ? "
                            + " AND store.created_at <= ? ";
                    flag = 2;
                }
            } else if (!status.equals("")) {
                sql = baseSql + " AND store.st_status = ? ";
                flag = 3;
            } else {
                return baseListStore;
            }
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            switch (flag) {
                case 1:
                    stmt.setInt(1, Integer.valueOf(status));
                    stmt.setString(2, from_date);
                    stmt.setString(3, to_date);
                    break;
                case 2:
                    stmt.setString(1, from_date);
                    stmt.setString(2, to_date);
                    break;
                case 3:
                    stmt.setInt(1, Integer.valueOf(status));
                    break;
                default:
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Store store = new Store();
                store.setId(rs.getInt(1));
                store.setName(rs.getString(2));
                store.setPosition(rs.getString(3));
                store.setStatus(rs.getInt(4));
                store.setSt_max_slot(rs.getInt(7));
                store.setSt_slot_current(rs.getInt(8));
                store.setSt_slot_empty(rs.getInt(9));
                store.setDeleted_at(rs.getString(10));
                result.add(store);
            }
        }
        return result;
    }

    public static void main(String[] args) throws SQLException {
        SearchOrFilter se = new SearchOrFilter();
        ArrayList<Book> liBo = new ArrayList<Book>();
     //   liBo = se.filterBook("2020-12-01 17:01:05", "2020-12-30 17:01:05", "1", "1");
//        System.out.println("sssss == " + liBo.size());
//        for (Book bo : liBo) {
//            System.out.println(bo.toString());
//        }
    }

}
