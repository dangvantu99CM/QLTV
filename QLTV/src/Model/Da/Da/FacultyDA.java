/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import Database.ConnectDb;
import Model.Da.Faculty;
import Model.Da.School;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tudv
 */
public class FacultyDA {

    public FacultyDA() {}
    private Connection con = ConnectDb.connectDB();
    public static ArrayList<Faculty> listFaculty;

    public ArrayList getAllListFaculty() throws SQLException {
        listFaculty = new ArrayList<Faculty>();
        String sql = "SELECT * FROM faculty where deleted_at is null";
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Faculty faculty = new Faculty(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            listFaculty.add(faculty);
        }
        return listFaculty;
    }

    public ArrayList getListFacultyBySchId(int schID) throws SQLException {
        ArrayList<Faculty> listFaculty = new ArrayList<Faculty>();
        String sql = "SELECT * FROM faculty WHERE sch_id = ?";
        java.sql.PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, schID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Faculty faculty = new Faculty(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            listFaculty.add(faculty);
        }
        return listFaculty;
    }
    
    public static void main(String[] args) throws SQLException {
        FacultyDA fac = new FacultyDA();
        System.out.println("size === " + fac.getListFacultyBySchId(1).size());
    }
}
