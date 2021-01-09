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
public class BookExtension extends Book {

    private String storeName;
    private String dateBorrow;
    
    private int id_user_book;

    public BookExtension() {}

    /**
     * @return the storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * @param storeName the storeName to set
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    /**
     * @return the id_user_book
     */
    public int getId_user_book() {
        return id_user_book;
    }

    /**
     * @param id_user_book the id_user_book to set
     */
    public void setId_user_book(int id_user_book) {
        this.id_user_book = id_user_book;
    }
    
}
