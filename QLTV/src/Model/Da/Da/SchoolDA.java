/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import Database.ConnectDb;
import Model.Da.School;
import Model.Da.User;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tudv
 */
public class SchoolDA {
    public SchoolDA(){}
    public static ArrayList<School> listSchool;
    private Connection con = ConnectDb.connectDB();

    public ArrayList getAllListSchool() throws SQLException {
        listSchool = new ArrayList<School>();
        String sql = "SELECT * FROM school";
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            School school = new School(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            listSchool.add(school);
        }
        return listSchool;
    }

}
