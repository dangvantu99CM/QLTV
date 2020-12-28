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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tudv
 */
public class UserDA implements MyInterface {

    public UserDA() {
    }

    private Connection con = ConnectDb.connectDB();
    public static ArrayList<User> listUser = null;
    private Message mess = new Message();
    
    @Override
    public ArrayList getAll() {
        listUser = new ArrayList<User>();
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            try {
                String sql = "SELECT * FROM user where deleted_at is null";
                Statement stmt;
                stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    User user = new User();
                    user.setEmail(rs.getString(6));
                    user.setId_faculty(rs.getInt(11));
                    user.setId_major(rs.getInt(14));
                    user.setId_school(15);
                    user.setMasv(rs.getInt(5));
                    user.setName(rs.getString(2));
                    user.setDeletedAt(rs.getString(16));
                    user.setRole(rs.getInt(8));
                    listUser.add(user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listUser;
    }

    @Override
    public User create(Object item) {
        User user = (User) item;
        boolean result = false;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            String sql = "INSERT INTO "
                            + "user ("
                                    + "us_name, "
                                    + "us_code_student,"
                                    + "us_mail ,"
                                    + "us_role,"
                                    + "fac_id,"
                                    + "us_pass_word,"
                                    + "maj_id,"
                                    + "sch_id "
                                + ") "
                            + "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt;
            try {
                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, user.getName());
                stmt.setInt(2, user.getMasv());
                stmt.setString(3, user.getEmail());
                stmt.setInt(4, user.getRole());
                stmt.setInt(5, user.getId_faculty());
                stmt.setString(6, user.getPassword());
                stmt.setInt(7, user.getId_major());
                stmt.setInt(8, user.getId_school());
                result = (stmt.executeUpdate() > 0);
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
            return user;
        }
        return null;
    }

    @Override
    public User delete(int id) {
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            try {
                User user = getUserByID(id);
                if(user.getDeletedAt() != null){
                    return null;
                }
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                String sql = "update user set deleted_at = ? where id = ?";
                PreparedStatement stmt;
                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1,dtf.format(now));
                stmt.setInt(2, id);
                return user;
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public User update(int id) {
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            String sql = "update user set us_name = ?,us_address=?"
                    + ",us_code_student=?,us_mail=?,us_phone_number=?,us_role=?"
                    + ",fac_id=?,us_pass_word=?,maj_id=?,sch_id=?"
                    + "where id = ?";
            PreparedStatement stmt;
            try {
                User user = getUserByID(id);
                if(user.getDeletedAt() != null){
                    return null;
                }
                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, user.getName());
                stmt.setInt(4, user.getMasv());
                stmt.setString(5, user.getEmail());
                stmt.setInt(7, user.getRole());
                stmt.setInt(8, user.getId_faculty());
                stmt.setString(10, user.getPassword());
                stmt.setInt(11, user.getId_major());
                stmt.setInt(12, user.getId_school());
                stmt.setInt(13, user.getID());
                return user;
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    
    public boolean checkLogin(String email, String password) throws SQLException {
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            String sql = "SELECT * FROM user WHERE us_mail = ? AND us_pass_word = ?";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }
    
    public User getUserByID(int id) throws SQLException{
        User user = new User();
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            String sql = "SELECT * FROM user WHERE id = ?";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user.setEmail(rs.getString(6));
                user.setId_faculty(rs.getInt(11));
                user.setId_major(rs.getInt(14));
                user.setId_school(15);
                user.setMasv(rs.getInt(5));
                user.setName(rs.getString(2));
                user.setDeletedAt(rs.getString(16));
                user.setRole(rs.getInt(8));
            }
        }
        return user;
    }

    public static void main(String[] args) throws SQLException {
        UserDA qe = new UserDA();
        ArrayList<User> listUser = qe.getAll();
        for (User u : listUser) {
            System.out.println("user==============" + u.getName());
        }
    }


}
