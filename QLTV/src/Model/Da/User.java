/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da;

/**
 *
 * @author tudv
 */
public class User {

    private int id;
    private String name;
    private int masv;
    private String email;
    private String password;
    private int role;
    private int id_school;
    private int id_major;
    private int id_faculty;
    
    private String deleted_at=null;
    
    public User(){};

    public User(String name, int masv, String email, String password, int role, int id_school,int id_major, int id_faculty) {
        this.name = name;
        this.masv = masv;
        this.email = email;
        this.password = password;
        this.role = role;
        this.id_school = id_school;
        this.id_major = id_major;
        this.id_faculty = id_faculty;
    }

    /**
     * @return the name
     */
    public String getDeletedAt() {
        return deleted_at;
    }

    /**
     * @return the id
     */
    public void setDeletedAt(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public int getID() {
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the masv
     */
    public int getMasv() {
        return masv;
    }

    /**
     * @param masv the masv to set
     */
    public void setMasv(int masv) {
        this.masv = masv;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * @return the id_school
     */
    public int getId_school() {
        return id_school;
    }

    /**
     * @param id_school the id_school to set
     */
    public void setId_school(int id_school) {
        this.id_school = id_school;
    }

    /**
     * @return the id_major
     */
    public int getId_major() {
        return id_major;
    }

    /**
     * @param id_major the id_major to set
     */
    public void setId_major(int id_major) {
        this.id_major = id_major;
    }

    /**
     * @return the id_faculty
     */
    public int getId_faculty() {
        return id_faculty;
    }

    /**
     * @param id_faculty the id_faculty to set
     */
    public void setId_faculty(int id_faculty) {
        this.id_faculty = id_faculty;
    }

    public String toString() {
        String user = "[" + " id " + "=> " + this.getID()
                + " ,name " + "=> " + this.getName()
                + " ,msv " + "=> " + this.getMasv()
                + " ,email " + "=> " + this.getEmail()
                + " ,name " + "=> " + this.getName() 
                + " ]";
        return user;
    }

}
