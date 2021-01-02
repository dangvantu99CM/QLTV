/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;

/**
 *
 * @author tudv
 */
public interface MyInterface<T> {

    public ArrayList<T> getAll();
    
    public boolean create(T item);

    public boolean delete(int id);

    public boolean update(int id,T item);
}
