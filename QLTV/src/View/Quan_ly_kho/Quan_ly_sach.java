/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_kho;

import BaseClass.BaseClass;
import Core.BookCore.SearchOrFilter;
import Model.Da.Book;
import Model.Da.BookExtension;
import Model.Da.Da.BookDA;
import Model.Da.Da.StoreDA;
import Model.Da.Store;
import View.Thong_bao.Message;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tudv
 */
public class Quan_ly_sach extends JPanel {

    private javax.swing.JLabel lblFromDate, lbl_between, lblTodate, lblStore, lblStatus, lblNameBook;
    private javax.swing.JComboBox cbxStore, cbxStatus;
    private javax.swing.JButton btnBoSearch, btnAddBook, btnFilter;
    private javax.swing.JTable tbtData;
    private javax.swing.JScrollPane jScrollPane1;

    private JTextField txtBoSearch;

    private com.toedter.calendar.JDateChooser DateChooserFromDate, DateChooserTodate;
    private javax.swing.JSeparator jSeparator2, jSeparator1;

    private javax.swing.JPanel jPanel1;

    private DefaultTableModel model;
    private JScrollPane scrollPane;

    private StoreDA storeDa = new StoreDA();
    private BookDA bookDa = new BookDA();
    private ArrayList<Store> listStores = storeDa.getAll();
    private ArrayList<BookExtension> listBooks = bookDa.getAll();
    private SearchOrFilter searchOrFilter = new SearchOrFilter();

    private Message mes = BaseClass.getMessage();

    public Quan_ly_sach() {
        init();
        updateModel(listBooks);
        this.add(jPanel1);
    }

    private void init() {

        JPanel self = this;
        jPanel1 = new javax.swing.JPanel();

        lblFromDate = new JLabel();
        lblTodate = new JLabel();
        lbl_between = new JLabel();
        lblStatus = new JLabel();
        lblStore = new JLabel();
        lblNameBook = new JLabel();

        cbxStore = new javax.swing.JComboBox();
        cbxStatus = new javax.swing.JComboBox();

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        btnFilter = new JButton();
        btnBoSearch = new JButton();
        btnAddBook = new JButton();

        DateChooserFromDate = new com.toedter.calendar.JDateChooser();
        DateChooserTodate = new com.toedter.calendar.JDateChooser();

        jScrollPane1 = new javax.swing.JScrollPane();
        tbtData = new javax.swing.JTable();

        txtBoSearch = new JTextField();

        lblFromDate.setText("From-date");
        lbl_between.setText("~");
        lblTodate.setText("To-date");
        lblStore.setText("Kho");
        lblStatus.setText("Trạng thái");
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Dỗi", "Đã mượn hết"}));
        btnFilter.setText("Lọc");

        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnFilterActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Quan_ly_sach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Tên sách");
        model.addColumn("Tác giả");
        model.addColumn("Số lượng");
        model.addColumn("Kho");
        model.addColumn("Trạng thái");

        jScrollPane1.setViewportView(tbtData);

        lblNameBook.setText("Tên sách");

        btnBoSearch.setText("Tìm");
        btnBoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnBoSearchActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Quan_ly_sach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnAddBook.setText("Thêm sách");
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jSeparator1)
                                                .addComponent(jScrollPane1)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lblFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(DateChooserFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(lbl_between, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(lblTodate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(DateChooserTodate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(lblStore, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(cbxStore, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                        .addComponent(lblNameBook)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(txtBoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(7, 7, 7)))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(btnAddBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnFilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnBoSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(15, 15, 15))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator2)
                                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_between, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTodate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxStore, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(DateChooserFromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblFromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(DateChooserTodate, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
        );
        tbtData.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String data = (String) tbtData.getValueAt(tbtData.getSelectedRow(), 0);
                try {
                    BookDetail bookDetail = new BookDetail(Integer.valueOf(data), self);
                } catch (SQLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        loadCombobox();
    }

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateFrom = "";
        String dateTo = "";
        String store = ""; // Trong tat ca cac kho
        String status = "";
        if (DateChooserFromDate.getDate() != null) {
            dateFrom = sdf.format(DateChooserFromDate.getDate());
        }

        if (DateChooserFromDate.getDate() != null) {
            dateTo = sdf.format(DateChooserTodate.getDate());
        }

        if (cbxStore.getSelectedItem() != null) {
            if (!cbxStore.getSelectedItem().toString().equals("Tất cả")) {
                store = (cbxStore.getSelectedItem().toString()).split("-")[0];
            }
        }
        if (cbxStatus.getSelectedItem() != null) {
            if (!cbxStore.getSelectedItem().toString().equals("")) {
                String selectedVal = cbxStatus.getSelectedItem().toString();
                if (selectedVal.equals("")) {
                    status = "";
                }
                if (selectedVal.equals("Dỗi")) {
                    status = "1";
                }
                if (selectedVal.equals("Đã mượn hết")) {
                    status = "2";
                }
            }

        }
        System.out.println("==============================");
        System.out.println("date from === " + dateFrom);
        System.out.println("date to === " + dateTo);
        System.out.println("store == " + store);
        System.out.println("status == " + status);
        System.out.println("==============================");
        ArrayList<BookExtension> listFilter = searchOrFilter.filterBook(dateFrom, dateTo, status, store);
        updateModel(listFilter);
    }

    private void btnBoSearchActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        String nameBookVal = txtBoSearch.getText();
        ArrayList<BookExtension> resultList = searchOrFilter.searchBook(nameBookVal);
        System.out.println("size === " + resultList.size());
        if (resultList.size() > 0) {
            updateModel(resultList);
        } else {
            mes.showMessage("error", "Không có dữ liệu.");
            updateModel(listBooks);
        }
    }

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {
        JPanel self = this;
        them_sach them = new them_sach(self);
    }

    public void updateModel(ArrayList<BookExtension> listBok) {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (BookExtension book : listBok) {
            Object[] values = new Object[7];
            values[0] = String.valueOf(book.getId());
            values[1] = book.getName();
            values[2] = book.getAuthor();
            values[3] = book.getNumber();
            values[4] = book.getStoreName();
            values[5] = book.getStatus() == 1 ? "Dỗi" : "Đã mượn hết";
            model.addRow(values);
        }
        tbtData.setModel(model);
    }

    public void loadCombobox() {
        for (Store store : listStores) {
            cbxStore.addItem(store.getId() + "-" + store.getName());
        }
        cbxStore.addItem("Tất cả");
        cbxStore.setSelectedIndex(listStores.size());
    }
    
    public void refreshModel(){
        updateModel(bookDa.getAll());
    }
}
