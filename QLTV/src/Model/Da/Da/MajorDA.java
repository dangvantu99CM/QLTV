/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import Database.ConnectDb;
import Model.Da.Faculty;
import Model.Da.Major;
import Model.Da.School;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tudv
 */
public class MajorDA {

    public MajorDA() {
    }
    private Connection con = ConnectDb.connectDB();
    public static ArrayList<Major> listMajor;

    public ArrayList getAllListMajor() throws SQLException {
        listMajor = new ArrayList<Major>();
        String sql = "SELECT * FROM majors";
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Major major = new Major(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            listMajor.add(major);
        }
        return listMajor;
    }
    
     public ArrayList getListMajorByFacId(int facID) throws SQLException {
        ArrayList<Major> listMajor = new ArrayList<Major>();
        String sql = "SELECT * FROM majors where fac_id=?";
        PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setInt(1, facID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Major major = new Major(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            listMajor.add(major);
        }
        return listMajor;
    }
}
