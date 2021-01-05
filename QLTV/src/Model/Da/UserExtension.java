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
public class UserExtension extends User {

    private String date_borrow = null;
    private String us_bo_status = null;

    public UserExtension() {};
        
    public String getDateBorrow() {
        return this.date_borrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.date_borrow = dateBorrow;
    }

    public String getUserBookStatus() {
        return this.us_bo_status;
    }

    public void setUserBookStatus(String us_bo_status) {
        this.us_bo_status = us_bo_status;
    }

    public String toString() {
        String s = super.toString();
        return s += " , us_bo_status => " + this.getUserBookStatus();
    }
}
