/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Quan_ly_tai_khoan;

import Model.Da.Da.FacultyDA;
import Model.Da.Da.MajorDA;
import Model.Da.Da.SchoolDA;
import Model.Da.Da.UserDA;
import View.Quan_ly_tai_khoan.FormLogin;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class UserController {

    private UserDA user_model = new UserDA();
    private SchoolDA school_model = new SchoolDA();
    private MajorDA major_model = new MajorDA();
    private FacultyDA faculty_model = new FacultyDA();
    private JFrame view;

    public UserController(JFrame view) {
        this.view = view;
    }

    public boolean login(String name, String password) throws SQLException {
        if (view != null) {
            return user_model.checkLogin(name, password);
        }
        return false;
    }

    public ArrayList getListSchool() throws SQLException {
        return school_model.getAllListSchool();
    }

    public ArrayList getListFaculty() throws SQLException {
        return faculty_model.getAllListFaculty();
    }

    public ArrayList getListMajor() throws SQLException {
        return major_model.getAllListMajor();
    }
    
    public ArrayList getListFacultyBySchId(int schID) throws SQLException {
        return faculty_model.getListFacultyBySchId(schID);
    }

    public ArrayList getListMajorByFacId(int facID) throws SQLException {
        return major_model.getListMajorByFacId(facID);
    }

}
