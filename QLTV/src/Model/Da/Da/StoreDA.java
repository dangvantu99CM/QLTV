/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import BaseClass.BaseClass;
import Interface.MyInterface;
import Model.Da.Store;
import Model.Da.User;
import Model.Da.UserBook;
import View.Thong_bao.Message;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 *
 * @author tudv
 */
public class StoreDA implements MyInterface {

    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();

    public boolean borrowBook(UserBook userBook) {
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return false;
        }
        UserBookDA userBookDA = new UserBookDA();
        return userBookDA.create(userBook);
    }

    public Store getStoreByID(int id) throws SQLException {
        Store store = null;
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            String sql = "SELECT * FROM store WHERE id = ? AND deleted_at is null";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                store = new Store();
                store.setId(rs.getInt(1));
                store.setName(rs.getString(2));
                store.setPosition(rs.getString(3));
                store.setStatus(rs.getInt(4));
                store.setSt_max_slot(rs.getInt(7));
                store.setSt_slot_current(rs.getInt(8));
                store.setSt_slot_empty(rs.getInt(9));
                store.setDeleted_at(rs.getString(10));
            }
        }
        return store;
    }

    @Override
    public ArrayList getAll() {
        ArrayList<Store> listStores = new ArrayList<Store>();
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
            return null;
        } else {
            try {
                String sql = "SELECT * FROM store where store.deleted_at is null";
                Statement stmt;
                stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Store store = new Store();
                    store.setId(rs.getInt(1));
                    store.setName(rs.getString(2));
                    store.setPosition(rs.getString(3));
                    store.setStatus(rs.getInt(4));
                    store.setSt_max_slot(rs.getInt(7));
                    store.setSt_slot_current(rs.getInt(8));
                    store.setSt_slot_empty(rs.getInt(9));
                    store.setDeleted_at(rs.getString(10));
                    listStores.add(store);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listStores;
    }

    @Override
    public boolean create(Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(int id, Object item) {
        Store newStore = (Store) item;
        if (newStore.getDeleted_at() != null) {
            return false;
        }
        if (con == null) {
            mess.showMessage("error", "Connect to DB failed!");
        } else {
            String sql = "update store set "
                    + "st_name =?"
                    + ",st_position =?"
                    + ",st_max_slot =?"
                    + " where id = ?";
            PreparedStatement stmt;
            try {
                stmt = (PreparedStatement) con.prepareStatement(sql);
                stmt.setString(1, newStore.getName());
                stmt.setString(2, newStore.getPosition());
                stmt.setInt(3, newStore.getSt_max_slot());
                stmt.setInt(4, id);
                int count = stmt.executeUpdate();
                if (count > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean updateStoreWhenPayBook(int storeID) throws SQLException{
        Store updateStore=  getStoreByID(storeID);
        if(updateStore == null)return false;
        String sql = "update store set st_slot_current =?,st_slot_empty =? where id = ? AND store.deleted_at is null";
        java.sql.PreparedStatement stmt = con.prepareStatement(sql);
        int st_slot_current = updateStore.getSt_slot_current()-1;
        int st_slot_empty = updateStore.getSt_slot_current()+1;
        stmt.setInt(1, st_slot_current);
        stmt.setInt(2, st_slot_empty);
        stmt.setInt(3, storeID);
        int count = stmt.executeUpdate();
        if (count > 0) {
            return true;
        }
        return false;
    }
}
