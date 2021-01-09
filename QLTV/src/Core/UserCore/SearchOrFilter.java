/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.UserCore;

import BaseClass.BaseClass;
import Database.ConnectDb;
import Model.Da.Da.UserDA;
import Model.Da.User;
import Model.Da.UserBook;
import Model.Da.UserExtension;
import View.Thong_bao.Message;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.omg.CORBA.UserException;

/**
 *
 * @author tudv
 */
public class SearchOrFilter {

    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();

    private UserDA userDA = new UserDA();

    private String baseSql = "SELECT user.*,user_book.*,book.* FROM user "
            + " left join user_book "
            + " on user.id = user_book.us_id "
            + " join book on book.id = user_book.bo_id "
            + " where user.deleted_at is null  AND user_book.delete_at is null  AND book.deleted_at is null ";

    private ArrayList<UserExtension> baseListUser = null;

    /**
     *
     * @param msv
     * @param name
     * @return User tuong ung voi ma sinh vien , Hoac danh sach sinh vien trung
     * ten neu msv la rong
     */
    public ArrayList searchUser(String msv, String name) throws SQLException {
        ArrayList<UserExtension> result = new ArrayList<UserExtension>();
        int flag = 0;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            String sql = "";
            if (msv.equals("")) {
                if (!name.equals("")) {
                    sql = baseSql + " and user.us_name = ? ";
                    flag = 1;
                } else {
                    return baseListUser;
                }
            } else if (name.equals("")) {
                sql = baseSql + " and user.us_code_student = ? ";
                flag = 2;
            } else {
                sql = baseSql + " and us_code_student = ? AND us_name = ? ";
                flag = 3;
            }
            if (flag != 0) {
                sql += " group by user.id,user_book.bo_id ";
            }
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            switch (flag) {
                case 1:
                    stmt.setString(1, name);
                    break;
                case 2:
                    stmt.setString(1, msv);
                    break;
                case 3:
                    stmt.setString(1, msv);
                    stmt.setString(2, name);
                    break;
                default:
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UserExtension user = new UserExtension();
                user.setID(rs.getInt(1));
                user.setEmail(rs.getString(6));
                user.setId_faculty(rs.getInt(11));
                user.setId_major(rs.getInt(14));
                user.setId_school(rs.getInt(15));
                user.setMasv(rs.getInt(5));
                user.setName(rs.getString(2));
                user.setDeletedAt(rs.getString(16));
                user.setRole(rs.getInt(8));
                user.setDateBorrow(rs.getString(20));
                user.setUserBookStatus(rs.getString(22));
                user.setUserBookDateLimt(rs.getInt(35));
                user.setIdUsBo(rs.getInt(17));
                result.add(user);
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
    public ArrayList filterUser(String from_date, String to_date, String status) throws SQLException {
        baseListUser = userDA.getAll();
        ArrayList<UserExtension> result = new ArrayList<UserExtension>();
        String sql = "";
        int flag = 0;
        if ((from_date.equals("") && !to_date.equals("")) || (!from_date.equals("") && to_date.equals(""))) {
            mess.showMessage("error", "Hay chon khoang thoi gian can loc");
            return baseListUser;
        }
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return baseListUser;
        } else {
            if (!from_date.equals("") && !to_date.equals("")) {
                if (!status.equals("")) {
                    sql = baseSql + " AND user_book.status = ? "
                            + " AND user_book.date_borrow >= ? "
                            + " AND user_book.date_borrow <= ? ";
                    flag = 1;
                } else {
                    sql = baseSql + " AND date_borrow >= ? "
                            + " AND date_borrow <= ? ";
                    flag = 2;
                }
            } else if (!status.equals("")) {
                System.out.println("sssssssssssssssssssssss");
                sql = baseSql + " AND user_book.status = ? ";
                flag = 3;
            } else {
                return baseListUser;
            }
            if (flag != 0) {
                sql += " group by user.id,user_book.bo_id ";
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
                UserExtension user = new UserExtension();
                user.setID(rs.getInt(1));
                user.setEmail(rs.getString(6));
                user.setId_faculty(rs.getInt(11));
                user.setId_major(rs.getInt(14));
                user.setId_school(rs.getInt(15));
                user.setMasv(rs.getInt(5));
                user.setName(rs.getString(2));
                user.setDeletedAt(rs.getString(16));
                user.setRole(rs.getInt(8));
                user.setDateBorrow(rs.getString(20));
                user.setUserBookStatus(rs.getString(22));
                user.setUserBookDateLimt(rs.getInt(35));
                user.setIdUsBo(rs.getInt(17));
                result.add(user);
            }
        }
        return result;
    }

    /**
     *
     * @param id
     * @return User deleted
     */
    public boolean deleteUser(int id) {
        return userDA.delete(id);
    }

    /**
     *
     * @param User user
     * @return User updated
     */
    public boolean updateUser(int us_id, User newUser) {
        return userDA.update(us_id, newUser);
    }

    public void print(ArrayList<UserExtension> list) {
        for (UserExtension u : list) {
            System.out.println(u.toString());
        }
    }

    public static void main(String[] args) throws SQLException {
        SearchOrFilter sf = new SearchOrFilter();
        // sf.print(sf.filterUser("2020-01-01 18:15:35", "2021-12-30 18:15:35", "1"));
        ArrayList<UserExtension> listUser = sf.filterUser("", "", "1");
        System.out.println("ssssssss == " + listUser.size());
        for (UserExtension u : listUser) {
            System.out.println(u.toString());
        }
        // sf.print(sf.searchUser("17000 746", "tudv"));
        // System.out.println(sf.deleteUser(27));

        //user.set
        //UserExtension user = listUser.get(0);
        //  System.out.println("user === " + user.toString());
//        user.setName("test");
//        user.setEmail("test@gmail.com");
//        user.setMasv(7777);
//        user.setPassword("7777");
//        user.setRole(2);
//        user.setId_major(2);
//        user.setId_school(1);
        //  System.out.println("user after = "  + user.toString());
        //sf.updateUser(user);
    }
}
