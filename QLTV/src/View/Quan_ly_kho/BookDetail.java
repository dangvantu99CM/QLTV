/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_kho;

import BaseClass.BaseClass;
import Model.Da.Da.BookDA;
import Model.Da.Da.StoreDA;
import Model.Da.User;
import Model.Da.Book;
import View.Thong_bao.Message;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tudv
 */
public class BookDetail extends javax.swing.JDialog {

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMuonSach;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbxKho;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblConlai;
    private javax.swing.JLabel lblDaMuon;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblKho;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtConLai;
    private javax.swing.JTextField txtDaMuon;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;

    // End of variables declaration   
    private Message mes = BaseClass.getMessage();

    private int id = -1;

    private BookDA bookDa = new BookDA();
    private Book book = null;

    private JFrame frameAfter = null;

    public BookDetail(int id, JFrame frameAfter) throws SQLException {
        this.id = id;
        this.frameAfter = frameAfter;
        User user = new User();
        if (id != -1) {
            book = bookDa.getBookByID(id);
        }
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblNumber = new javax.swing.JLabel();
        lblDaMuon = new javax.swing.JLabel();
        lblConlai = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtConLai = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtDaMuon = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        btnMuonSach = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblKho = new javax.swing.JLabel();
        cbxKho = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        lblName.setText("Tên sách");

        lblAuthor.setText("Tác giả");

        lblNumber.setText("Số lượng");

        lblDaMuon.setText("Đã mượn");

        lblConlai.setText("Còn lại");

        txtName.setText("jTextField1");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtConLai.setText("jTextField1");

        txtNumber.setText("jTextField1");

        txtAuthor.setText("jTextField1");

        txtDaMuon.setText("jTextField1");
        txtDaMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaMuonActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblInfo.setText("Thông tin chi tiết");

        btnMuonSach.setText("Mượn sách");
        btnMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnMuonSachActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(BookDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnDelete.setText("Xóa sách");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblKho.setText("Kho");

        cbxKho.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnUpdate)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(84, 84, 84)
                                        .addComponent(btnMuonSach)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnDelete))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblConlai, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblDaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblKho, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbxKho, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                        .addComponent(txtAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                        .addComponent(txtDaMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                        .addComponent(txtConLai, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
                                .addComponent(jSeparator2))
                        .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblInfo)
                                .addComponent(btnDelete)
                                .addComponent(btnMuonSach))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblName)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAuthor))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNumber))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDaMuon)
                                .addComponent(txtDaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtConLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblConlai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblKho)
                                .addComponent(cbxKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnUpdate)
                        .addGap(20, 20, 20))
        );
        if (book != null) {
            txtName.setText(book.getName());
            txtAuthor.setText(book.getAuthor());
            txtNumber.setText(String.valueOf(book.getNumber()));
            txtDaMuon.setText(String.valueOf(book.getBorrowNumber()));
            txtConLai.setText(String.valueOf(book.getBorrowNumber()));
        }
        pack();
    }// </editor-fold>                        

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        Book bo = new Book();
        bo.setName(txtName.getText());
        bo.setAuthor(txtAuthor.getText());
        bo.setNumber(Integer.valueOf(txtNumber.getText()));
        boolean status = bookDa.update(book.getId(), bo);
        if (status) {
            mes.showMessage("success", "Cập nhật thành công.");
            if (frameAfter != null) {
                if (frameAfter instanceof Manager) {
                    Manager m = (Manager) frameAfter;
                    BookDA bookDa = new BookDA();
                    m.updateModel(bookDa.getAll());
                }
            }
        } else {
            mes.showMessage("error", "Xử lý thất bại.");
        }
    }

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnMuonSachActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        muon_sach m = new muon_sach(book.getId());
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (book != null) {
            boolean status = bookDa.delete(book.getId());
            if (status) {
                this.dispose();
                if (frameAfter instanceof Manager) {
                    Manager m = (Manager) frameAfter;
                    BookDA bookDa = new BookDA();
                    m.updateModel(bookDa.getAll());
                }
            }
        }

    }

    private void txtDaMuonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) throws SQLException {
        BookDetail bookDetail = new BookDetail(-1, null);
        bookDetail.setVisible(true);
    }

}
