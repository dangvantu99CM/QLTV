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
public class UserBook {

    private int id;
    private int us_id;
    private int bo_id;
    private String date_borrow;
    private String date_pay = null;
    private int status = 1;
    private double VND_recoup = 0.0;

    public UserBook() {};
    
    public UserBook(int us_id, int bo_id,
            String date_borrow,String date_pay, 
            int status, double VND_recoup){
        this.us_id = us_id;
        this.bo_id = bo_id;
        this.status = status;
        this.VND_recoup = VND_recoup;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the us_id
     */
    public int getUs_id() {
        return us_id;
    }

    /**
     * @param us_id the us_id to set
     */
    public void setUs_id(int us_id) {
        this.us_id = us_id;
    }

    /**
     * @return the bo_id
     */
    public int getBo_id() {
        return bo_id;
    }

    /**
     * @param bo_id the bo_id to set
     */
    public void setBo_id(int bo_id) {
        this.bo_id = bo_id;
    }

    /**
     * @return the date_borrow
     */
    public String getDate_borrow() {
        return date_borrow;
    }

    /**
     * @param date_borrow the date_borrow to set
     */
    public void setDate_borrow(String date_borrow) {
        this.date_borrow = date_borrow;
    }

    /**
     * @return the date_pay
     */
    public String getDate_pay() {
        return date_pay==null?"Chưa trả":this.getDate_pay();
    }

    /**
     * @param date_pay the date_pay to set
     */
    public void setDate_pay(String date_pay) {
        this.date_pay = date_pay;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the VND_recoup
     */
    public double getVND_recoup() {
        return VND_recoup;
    }

    /**
     * @param VND_recoup the VND_recoup to set
     */
    public void setVND_recoup(double VND_recoup) {
        this.VND_recoup = VND_recoup;
    }

    
     public String toString() {
        String userBook = "[" + " id " + "=> " + this.getId()
                + " ,us_id " + "=> " + this.getUs_id()
                + " ,bo_id " + "=> " + this.getBo_id()
                + " ,date_boorow " + "=> " + this.getDate_borrow()
                + " ,date_pay " + "=> " + this.getDate_pay()==null?" Chưa trả ":this.getDate_pay()
                + " ]";
        return userBook;
    }

}
