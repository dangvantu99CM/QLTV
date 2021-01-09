/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_kho;

import BaseClass.BaseClass;
import Core.MyStoreCore.MyStoreCore;
import Model.Da.Book;
import Model.Da.BookExtension;
import Model.Da.Da.BookDA;
import Model.Da.Da.UserBookDA;
import Model.Da.User;
import View.Thong_bao.Message;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author tudv
 */
public class BookPay extends javax.swing.JDialog {

    private javax.swing.JButton btnPay;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDateBorrow;
    private javax.swing.JLabel lblNameAuthor;
    private javax.swing.JLabel lblNameBook;
    private javax.swing.JLabel lblQuaHan;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStore;
    private javax.swing.JLabel lblTienPhat;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtDateBorrow;
    private javax.swing.JTextField txtNameAuthor;
    private javax.swing.JTextField txtNameBook;
    private javax.swing.JTextField txtQuaHan;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtStore;
    private javax.swing.JTextField txtTienPhat;

    private JDialog frameAfter = null;
    private int us_bo_id = -1;

    private UserBookDA userBookDA = new UserBookDA();
    private MyStoreCore myStoreCore = new MyStoreCore();
    private Message mes = BaseClass.getMessage();

    public BookPay(int us_bo_id, JDialog frameAfter) throws SQLException {
        this.us_bo_id = us_bo_id;
        this.frameAfter = frameAfter;
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws SQLException {

        setModal(true);
        setResizable(false);
        setAlwaysOnTop(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        lblTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblNameAuthor = new javax.swing.JLabel();
        txtNameBook = new javax.swing.JTextField();
        lblNameBook = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblDateBorrow = new javax.swing.JLabel();
        txtNameAuthor = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtDateBorrow = new javax.swing.JTextField();
        lblStore = new javax.swing.JLabel();
        txtStore = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();
        lblQuaHan = new javax.swing.JLabel();
        txtQuaHan = new javax.swing.JTextField();
        lblTienPhat = new javax.swing.JLabel();
        txtTienPhat = new javax.swing.JTextField();

        lblTitle.setText("Thông tin chi tiết");

        lblNameAuthor.setText("Tác giá");

        lblNameBook.setText("Tên sách");

        lblStatus.setText("Trạng thái");

        lblDateBorrow.setText("Ngày mượn");

        lblStore.setText("Kho");

        btnPay.setText("Trả sách");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnPayActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(BookPay.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BookPay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        lblQuaHan.setText("Quá hạn");

        lblTienPhat.setText("Tiền phạt");

        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Tra sach ssssssssssss");
                try {
                    btnPayActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(BookPay.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BookPay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblDateBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblStore, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtStore, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtDateBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDateBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDateBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblStore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
        );

        if (us_bo_id != -1) {
            BookExtension book = userBookDA.getBookExtension(us_bo_id);
            if (book != null) {
                txtNameBook.setText(book.getName());
                txtNameAuthor.setText(book.getAuthor());
                txtDateBorrow.setText(book.getDateBorrow());
                txtStore.setText(book.getStoreName());
                txtStatus.setText(book.getStatus() == 1 ? "Đang mượn" : "Quá hạn");
                txtQuaHan.setText(String.valueOf(book.getSo_ngay_qua_han()));
                txtTienPhat.setText(String.valueOf(book.getTienPhat()));
            }
        }
        pack();
        this.setLocation(500,250);
    }// </editor-fold>                        

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException {
        this.dispose();
        mes.showMessage("success", "Cập nhật thành công");
        boolean status = myStoreCore.payBook(us_bo_id);
       // if (status) {
            MyStore myStore = (MyStore) frameAfter;
            myStore.refreshListBookBase();
       // }
    }

    public static void main(String args[]) throws SQLException {
        BookPay b = new BookPay(-1, null);
    }

}
