/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.StoreCore;

import BaseClass.BaseClass;
import Database.ConnectDb;
import Model.Da.Da.StoreDA;
import Model.Da.UserBook;
import View.Thong_bao.Message;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tudv
 */
public class StoreCore extends BaseClass {

    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();
    
    private StoreDA storeDA = new StoreDA();

    /**
     * 
     * @param bo_id
     * @param us_id
     * @return true : muon thanh cong , fase: muon that bai
     */
    public boolean borrowBook(int bo_id, int us_id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        UserBook userBook = new UserBook();
        userBook.setBo_id(bo_id);
        userBook.setUs_id(us_id);
        userBook.setStatus(1);
        userBook.setDate_borrow(dtf.format(now));
        return storeDA.borrowBook(userBook);
    }
    
    public static void main(String[] args) {
        StoreCore core = new StoreCore();
        System.out.println(core.borrowBook(8, 24));
    }
}
