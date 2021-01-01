/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import BaseClass.BaseClass;
import Model.Da.UserBook;
import View.Thong_bao.Message;
import java.sql.Connection;

/**
 *
 * @author tudv
 */
public class StoreDA {
    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();
    
    public boolean borrowBook(UserBook userBook){
        if(con==null){
            mess.showMessage("error", "Connect to DB failed!");
            return false;
        }
        UserBookDA userBookDA = new UserBookDA();
        return userBookDA.create(userBook) != null ? true : false;
    }
}
