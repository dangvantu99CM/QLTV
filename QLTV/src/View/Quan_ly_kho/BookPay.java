/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_kho;

import BaseClass.BaseClass;
import Model.Da.Book;
import Model.Da.BookExtension;
import Model.Da.Da.BookDA;
import Model.Da.Da.UserBookDA;
import Model.Da.User;
import View.Thong_bao.Message;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author tudv
 */
public class BookPay extends javax.swing.JDialog {

    private javax.swing.JButton btnPay;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtNameBook;
    private javax.swing.JLabel lblDateBorrow;
    private javax.swing.JLabel lblNameAuthor;
    private javax.swing.JLabel lblNameBook;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStore;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtDateBorrow;
    private javax.swing.JTextField txtNameAuthor;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtStore;

    private JFrame frameAfter = null;
    private int us_bo_id = -1;

    private UserBookDA userBookDA = new UserBookDA();

    public BookPay(int us_bo_id, JFrame frameAfter) throws SQLException {
        this.us_bo_id = us_bo_id;
        this.frameAfter = frameAfter;
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws SQLException {

        lblTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblNameBook = new javax.swing.JLabel();
        lblNameAuthor = new javax.swing.JLabel();
        lblStore = new javax.swing.JLabel();
        lblDateBorrow = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        txtNameAuthor = new javax.swing.JTextField();
        txtStore = new javax.swing.JTextField();
        txtDateBorrow = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtNameBook = new javax.swing.JTextField();

        lblTitle.setText("Thông tin chi tiết");

        lblNameBook.setText("Tên sách");

        lblNameAuthor.setText("Tên tác giả");

        lblStore.setText("Kho");

        lblDateBorrow.setText("Ngày mượn");

        lblStatus.setText("Trạng thái");

        btnPay.setText("Trả sách");

        txtStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNameBook)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNameBook))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNameAuthor)
                                        .addGap(8, 8, 8)
                                        .addComponent(txtNameAuthor))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblDateBorrow)
                                                        .addGap(6, 6, 6))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(8, 8, 8)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtDateBorrow)
                                                .addComponent(txtStore)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblTitle)
                                                .addComponent(btnPay))
                                        .addGap(0, 238, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblStatus)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtStatus)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNameBook)
                                .addComponent(txtNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNameAuthor)
                                .addComponent(txtNameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblStore)
                                .addComponent(txtStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDateBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDateBorrow))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblStatus)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnPay)
                        .addGap(25, 25, 25))
        );
        if (us_bo_id != -1) {
            BookExtension book = userBookDA.getBookExtension(us_bo_id);
            if(book != null){
                txtNameBook.setText(book.getName());
                txtNameAuthor.setText(book.getAuthor());
                txtDateBorrow.setText(book.getDateBorrow());
                txtStore.setText(book.getStoreName());
                txtStatus.setText(book.getStatus()==1?"Đang mượn":"Quá hạn");
            }
        }
        pack();
    }// </editor-fold>                        

    private void txtStoreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        BookPay b = new BookPay(-1, null);
    }

}
