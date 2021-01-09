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
import Model.Da.BookExtension;
import View.Thong_bao.Message;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tudv
 */
public class BookDetail extends javax.swing.JDialog {

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDelete, btnMuonSach, btnUpdate;
    private javax.swing.JSeparator jSeparator2, jSeparator1;
    private javax.swing.JLabel lblAuthor, lblStatus, lblDaMuon, lblConlai, lblNumber, lblName, lblKho, lblInfo;
    private javax.swing.JTextField txtAuthor, txtStatus, txtStore, txtConLai, txtDaMuon, txtName, txtNumber;

    // End of variables declaration   
    private Message mes = BaseClass.getMessage();

    private int id = -1;

    private BookDA bookDa = new BookDA();
    private BookExtension book = null;

    private Object frameAfter = null;

    public BookDetail(int id, Object frameAfter) throws SQLException {
        this.id = id;
        this.frameAfter = frameAfter;
        User user = new User();
        if (id != -1) {
            book = bookDa.getBookByID(id);
        }
        initComponents();
        this.setLocationRelativeTo(null);
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
        lblStatus = new javax.swing.JLabel();

        txtName = new javax.swing.JTextField();
        txtConLai = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtDaMuon = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtStore = new javax.swing.JTextField();

        btnUpdate = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        btnMuonSach = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblKho = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        lblName.setText("Tên sách");
        lblAuthor.setText("Tác giả");
        lblNumber.setText("Số lượng");
        lblDaMuon.setText("Đã mượn");
        lblConlai.setText("Còn lại");
        lblStatus.setText("Trạng thái");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2)
                                .addComponent(btnUpdate)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(84, 84, 84)
                                        .addComponent(btnMuonSach)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnDelete))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(29, 29, 29)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(lblDaMuon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                                                .addComponent(lblNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lblKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtStatus)
                                                .addComponent(txtStore)
                                                .addComponent(txtDaMuon)
                                                .addComponent(txtNumber)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtAuthor)
                                                .addComponent(txtName))))
                        .addContainerGap())
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
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAuthor)
                                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNumber)
                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDaMuon)
                                .addComponent(txtDaMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblKho)
                                .addComponent(txtStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addContainerGap())
        );
        if (book != null) {
            txtName.setText(book.getName());
            txtAuthor.setText(book.getAuthor());
            txtNumber.setText(String.valueOf(book.getNumber()));
            txtDaMuon.setText(String.valueOf(book.getBorrowNumber()));
            txtConLai.setText(String.valueOf(book.getBorrowNumber()));
            txtStatus.setText(book.getStatus()==2?"Đã mượn hết":"Dỗi");
            txtStore.setText(book.getStoreName());
        }
        pack();
    }// </editor-fold>                        

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        Book bo = new Book();
        JDialog self = this;
        bo.setName(txtName.getText());
        bo.setAuthor(txtAuthor.getText());
        bo.setNumber(Integer.valueOf(txtNumber.getText()));
        boolean status = bookDa.update(book.getId(), bo);
        if (status) {
            mes.showMessage("success", "Cập nhật thành công.");
            self.dispose();
            if (frameAfter != null) {
                if (frameAfter instanceof Quan_ly_sach) {
                    Quan_ly_sach m = (Quan_ly_sach) frameAfter;
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
