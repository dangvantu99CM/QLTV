/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.UserInterface;

import java.util.ArrayList;

/**
 *
 * @author tudv
 */
public interface MyInterface<T> {

    public ArrayList<T> getAll();
    
    public T create(T item);

    public T delete(int id);

    public T update(int id);
}
