/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.MyStoreCore;

import BaseClass.BaseClass;
import Config.Constant;
import Model.Da.BookExtension;
import Model.Da.Da.StoreDA;
import Model.Da.Da.UserBookDA;
import View.Thong_bao.Message;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author tudv
 */
public class MyStoreCore {

    private Message mess = BaseClass.getMessage();
    private Connection con = BaseClass.getConnectDb();
    private UserBookDA userBookDA = new UserBookDA();
    private StoreDA storeDA = new StoreDA();

    public boolean payBook(int us_bo_id) throws SQLException {
        BookExtension book = userBookDA.getBookExtension(us_bo_id);
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return false;
        } else {
            String sql = "update user_book set delete_at  =? where id = ? AND user_book.delete_at is null";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Constant.getStringDateNow());
            stmt.setInt(2, us_bo_id);
            int count = stmt.executeUpdate();
            if (count > 0) {
                storeDA.updateStoreWhenPayBook(book.getStoreID());
                return true;
            }
            return false;
        }
    }
}
