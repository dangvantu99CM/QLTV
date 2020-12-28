/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.UserCore;

import Database.ConnectDb;
import Model.Da.Da.UserDA;
import Model.Da.User;
import Model.Da.UserBook;
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

    private Connection con = ConnectDb.connectDB();
    private Message mess = new Message();

    private UserDA userDA = new UserDA();

    private ArrayList<User> result = null;

    private ArrayList<User> baseListUser = userDA.getAll();

    /**
     *
     * @param msv
     * @param name
     * @return User tuong ung voi ma sinh vien , Hoac danh sach sinh vien trung
     * ten neu msv la rong
     */
    public ArrayList<User> serchUser(String msv, String name) throws SQLException {
        result = new ArrayList<User>();
        int flag = 0;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            String sql = "";
            if (msv.equals("")) {
                if (!name.equals("")) {
                    sql = "SELECT * FROM user WHERE us_name = ?";
                    flag = 1;
                } else {
                    return baseListUser;
                }
            } else if (name.equals("")) {
                sql = "SELECT * FROM user WHERE us_code_student = ?";
                flag = 2;
            } else {
                sql = "SELECT * FROM user WHERE us_code_student = ? AND us_name = ?";
                flag = 3;
            }
            if(flag==0){
                return baseListUser;
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
                User user = new User(rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getString(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
                result.add(user);
            }
        }
        return result.size()>0 ? result : baseListUser;
    }

    /**
     *
     * @param from_date
     * @param to_date
     * @param status : loc theo trang thai : dang muon , da tra, qua han
     * @return Danh sach User phu hop
     */
    public ArrayList<User> filterUser(String from_date, String to_date, String status) throws SQLException {
        result = new ArrayList<User>();
        String sql = "";
        int flag = 0;
        if (from_date.equals("") || to_date.equals("")) {
            mess.showMessage("error", "Hãy chọn khoảng thời gian cần lọc!");
            return baseListUser;
        }
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return baseListUser;
        } else {
            if (!status.equals("")) {
                sql = "SELECT * FROM user_book join user on user.id = user_book.us_id WHERE status = ? AND date_borrow >= ? AND date_borrow <= ?";
                flag = 1;
            } else {
                sql = "SELECT * FROM user_book join user on user.id = user_book.us_id WHERE date_borrow >= ? AND date_borrow <= ?";
                flag = 2;
            }
            if (flag == 0) {
                return baseListUser;
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
                default:
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(12),
                        rs.getString(13), -1, rs.getInt(15),
                        rs.getString(16), -1, rs.getString(23), rs.getInt(18),
                        rs.getInt(25), rs.getInt(24), rs.getInt(21));
                user.setID(rs.getInt(1));
                result.add(user);
            }
        }
        return result.size() > 0 ? result : baseListUser;
    }
    
    public boolean deleteUser(User u){
        return userDA.delete(u);
    }

    public void print(ArrayList<User> list) {
        for (User u : list) {
            System.out.println(u.toString());
        }
    }
    
    

    public static void main(String[] args) throws SQLException {
        SearchOrFilter sf = new SearchOrFilter();
        //sf.print(sf.filterUser("", "sdas", "1"));
        sf.print(sf.serchUser("17000746", "Alexender_dai_de"));
    }
}
