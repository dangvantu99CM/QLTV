/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_kho;

import BaseClass.BaseClass;
import Core.MyStoreCore.SearchOrFilter;
import Model.Da.Book;
import Model.Da.BookExtension;
import Model.Da.Da.BookDA;
import Model.Da.Da.StoreDA;
import Model.Da.Da.UserBookDA;
import Model.Da.Store;
import View.Thong_bao.Message;
import com.mysql.fabric.xmlrpc.base.Data;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tudv
 */
public class MyStore extends JFrame {

    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cbxStatus;
    private javax.swing.JComboBox cbxStore;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStore;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblToDate;
    private javax.swing.JTextField txtBookName;

    private DefaultTableModel model;
    private JScrollPane scrollPane;

    private StoreDA storeDa = new StoreDA();
    private BookDA bookDa = new BookDA();
    private ArrayList<Store> listStores = storeDa.getAll();
    private ArrayList<BookExtension> listBookBase = new ArrayList<>();

    private UserBookDA userBookDA = new UserBookDA();
    
    private SearchOrFilter searchOrFilter = new SearchOrFilter();
    
    private Message mes = BaseClass.getMessage();

    private int user_id = -1;

    public MyStore(int user_id) throws SQLException, ParseException {
        this.user_id = user_id;
        initComponents();
        if (user_id != -1) {
            listBookBase = userBookDA.getAllByUserID(user_id);
            updateModel(listBookBase);
        }
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblFromDate = new javax.swing.JLabel();
        lblToDate = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        lblStatus = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox();
        lblStore = new javax.swing.JLabel();
        cbxStore = new javax.swing.JComboBox();
        btnFilter = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblBookName = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setText("MY-STORE");

        lblFromDate.setText("From-date");

        lblToDate.setText("To-date");

        lblStatus.setText("Trạng thái");
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Đang mượn", "Quá hạn"}));
        cbxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStatusActionPerformed(evt);
            }
        });

        lblStore.setText("Kho");

        //  cbxStore.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        cbxStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStoreActionPerformed(evt);
            }
        });

        btnFilter.setText("Lọc");

        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnFilterActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(MyStore.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(MyStore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSearchActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(MyStore.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(MyStore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel6.setText("~");

        jScrollPane1.setViewportView(jTable1);

        lblBookName.setText("Tên sách");

        txtBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookNameActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 8, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(lblBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnSearch))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(lblFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblToDate)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblStore)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(cbxStore, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTitle)
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblFromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbxStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblStatus)
                                                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnFilter)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch)
                                .addComponent(lblBookName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        loadCombobox();
        pack();
    }// </editor-fold>                        

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateFrom = "";
        String dateTo = "";
        String store = ""; // Trong tat ca cac kho
        String status = "";
        if (jDateChooser2.getDate() != null) {
            dateFrom = sdf.format(jDateChooser2.getDate());
        }
        System.out.println("date from === " + dateFrom);
        if (jDateChooser3.getDate() != null) {
            dateTo = sdf.format(jDateChooser3.getDate());
        }
        System.out.println("date to === " + dateTo);
        if (cbxStore.getSelectedItem() != null) {
            if (!cbxStore.getSelectedItem().toString().equals("Tất cả")) {
                store = (cbxStore.getSelectedItem().toString()).split("-")[0];
            }
            System.out.println("store == " + store);
        }
        if (cbxStatus.getSelectedItem() != null) {
            if (!cbxStore.getSelectedItem().toString().equals("")) {
                String selectedVal = cbxStatus.getSelectedItem().toString();
                if (selectedVal.equals("Đang mượn")) {
                    status = "1";
                }
                if (selectedVal.equals("Quá hạn")) {
                    status = "2";
                }
            }
            System.out.println("status == " + status);
        }
        ArrayList<BookExtension> listFilter = searchOrFilter.filterBook(this.user_id,dateFrom, dateTo, status, store);
        updateModel(listFilter);
    }
    
    public void btnSearchActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException{
        String nameBookVal = txtBookName.getText();
        ArrayList<BookExtension>resultList = searchOrFilter.searchBook(this.user_id, nameBookVal);
        if(resultList.size() > 0){
            updateModel(resultList);
        }else{
            mes.showMessage("error","Không có dữ liệu.");
            updateModel(listBookBase);
        }
    }

    private void cbxStoreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtBookNameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cbxStatusActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void updateModel(ArrayList<BookExtension> listBok) throws ParseException, SQLException {
        javax.swing.JFrame self = this;
        long so_ngay_qua_han = 0;
        double tien_phat = 0.0;
        Calendar calendar = Calendar.getInstance();
        Date dateNow = calendar.getTime();
        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Tên sách");
        model.addColumn("Tác giả");
        model.addColumn("Kho");
        model.addColumn("Ngày mượn");
        model.addColumn("Trạng thái");
        model.addColumn("Số ngày quá hạn");
        model.addColumn("Tiền phạt");
        for (BookExtension book : listBok) {
            Object[] values = new Object[9];
            values[0] = String.valueOf(book.getId_user_book());
            values[1] = book.getName();
            values[2] = book.getAuthor();
            values[3] = book.getStoreName();
            values[4] = book.getDateBorrow();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.setTime(dateFormatter.parse(book.getDateBorrow()));
            calendar.add(Calendar.DATE, book.getBookDateLimit());
            if (calendar.getTime().compareTo(dateNow) >= 0) {
                userBookDA.updateStatus(book.getId_user_book(), 1,0,0);
                values[5] = "Đang mượn";
            }
            if (calendar.getTime().compareTo(dateNow) < 0) {
                values[5] = "Quá hạn";
                long ngay_tra = dateNow.getTime();
                long han_tra = calendar.getTime().getTime();
                so_ngay_qua_han = Math.abs((han_tra - ngay_tra) / (24 * 3600 * 1000));
                tien_phat = so_ngay_qua_han*2000;
                values[6] = so_ngay_qua_han;
                values[7] = Math.abs(tien_phat);
                userBookDA.updateStatus(book.getId_user_book(), 2,(int)so_ngay_qua_han,tien_phat);
            }
            model.addRow(values);
        }
        jTable1.setModel(model);
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String data = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                try {
                    BookPay boPay = new BookPay(Integer.valueOf(data), self);
                } catch (SQLException ex) {
                    Logger.getLogger(MyStore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void loadCombobox() {
        for (Store store : listStores) {
            cbxStore.addItem(store.getId() + "-" + store.getName());
        }
        cbxStore.addItem("Tất cả");
        cbxStore.setSelectedIndex(listStores.size());
    }

    public static void main(String[] args) throws SQLException, ParseException {
        MyStore myStore = new MyStore(38);
    }

}
