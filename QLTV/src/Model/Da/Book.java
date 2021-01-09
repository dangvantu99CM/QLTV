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
public class Book {

    private int id;
    private String name;
    private int storeID;
    private String author;
    private int status;
    private int type;
    private int number;
    private int bookDateLimit;
    private double bookPrice;
    private String deletedAt;
    private int borrowNumber;
    private int emptyNumber;
    private double tienPhat;
    
    private int so_ngay_qua_han;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the storeID
     */
    public int getStoreID() {
        return storeID;
    }

    /**
     * @param storeID the storeID to set
     */
    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
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
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * @return the type
     */
    public double getTienPhat() {
        return tienPhat;
    }

    /**
     * @param type the type to set
     */
    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the bookDateLimit
     */
    public int getBookDateLimit() {
        return bookDateLimit;
    }

    /**
     * @param bookDateLimit the bookDateLimit to set
     */
    public void setBookDateLimit(int bookDateLimit) {
        this.bookDateLimit = bookDateLimit;
    }

    /**
     * @return the bookPrice
     */
    public double getBookPrice() {
        return bookPrice;
    }

    /**
     * @param bookPrice the bookPrice to set
     */
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     * @return the deletedAt
     */
    public String getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt the deletedAt to set
     */
    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * @return the borrowNumber
     */
    public int getBorrowNumber() {
        return borrowNumber;
    }

    /**
     * @param borrowNumber the borrowNumber to set
     */
    public void setBorrowNumber(int borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    /**
     * @return the emptyNumber
     */
    public int getEmptyNumber() {
        return emptyNumber;
    }

    /**
     * @param emptyNumber the emptyNumber to set
     */
    public void setEmptyNumber(int emptyNumber) {
        this.emptyNumber = emptyNumber;
    }
    
     public String toString() {
        String book = "[" + " getId " + "=> " + this.getId()
                + " ,getName " + "=> " + this.getName()
                + " ,getAuthor " + "=> " + this.getAuthor()
                + " ,getNumber " + "=> " + this.getNumber()
                + " ,getEmptyNumber " + "=> " + this.getEmptyNumber()
                + " ]";
        return book;
    }

    /**
     * @return the so_ngay_qua_han
     */
    public int getSo_ngay_qua_han() {
        return so_ngay_qua_han;
    }

    /**
     * @param so_ngay_qua_han the so_ngay_qua_han to set
     */
    public void setSo_ngay_qua_han(int so_ngay_qua_han) {
        this.so_ngay_qua_han = so_ngay_qua_han;
    }
}
