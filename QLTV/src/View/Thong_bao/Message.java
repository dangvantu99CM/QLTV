/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Thong_bao;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author tudv
 */
public class Message {
    public Message(){}
    public void showMessage(String status,String mes){
        JDialog f = new JDialog();
        if(status=="success"){
            JOptionPane.showMessageDialog(f,mes);
        }
        if(status=="error"){
            JOptionPane.showMessageDialog(f,mes);
        }
    }
}
