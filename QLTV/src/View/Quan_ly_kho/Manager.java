/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_kho;

import Core.StoreCore.SearchOrFilter;
import Model.Da.Book;
import Model.Da.Da.BookDA;
import Model.Da.Da.StoreDA;
import Model.Da.Store;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author tudv
 */
public class Manager extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private com.toedter.calendar.JDateChooser DateChooserFromDate;
    private com.toedter.calendar.JDateChooser DateChooserTodate;
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnFilter;
    private javax.swing.JComboBox cbxStatus1;
    private javax.swing.JComboBox cbxStore;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStore;
    private javax.swing.JLabel lblTodate;
    private javax.swing.JLabel lbl_between;
    private javax.swing.JMenu menuBarAccout;
    private javax.swing.JMenu menuBarStore;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tbtData;

    private javax.swing.JMenuItem jMenuItemAccout;
   // private javax.swing.JMenuItem jMenuItem3;

    // End of variables declaration   
    private DefaultTableModel model;
    private JScrollPane scrollPane;

    private StoreDA storeDa = new StoreDA();
    private BookDA bookDa = new BookDA();
    private ArrayList<Store> listStores = storeDa.getAll();
    private ArrayList<Book> listBooks = bookDa.getAll();

    private JPanel accout = new JPanel();

    private String status = "";

    public Manager() {
        initComponents();
        updateModel(listBooks);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        lblFromDate = new javax.swing.JLabel();
        DateChooserFromDate = new com.toedter.calendar.JDateChooser();
        lblTodate = new javax.swing.JLabel();
        lbl_between = new javax.swing.JLabel();
        DateChooserTodate = new com.toedter.calendar.JDateChooser();
        lblStatus = new javax.swing.JLabel();
        cbxStatus1 = new javax.swing.JComboBox();
        lblStore = new javax.swing.JLabel();
        cbxStore = new javax.swing.JComboBox();
        btnFilter = new javax.swing.JButton();
        btnAddBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtData = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBarStore = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuBarAccout = new javax.swing.JMenu();

        jMenuItemAccout = new JMenuItem("Quản lý tài khoản");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFromDate.setText("From-date");

        lblTodate.setText("To-date");

        lbl_between.setText("~");

        lblStatus.setText("Trạng thái");

        cbxStatus1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Dỗi", "Đã mượn hết"}));

        lblStore.setText("Kho");

       // cbxStore.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        btnFilter.setText("Lọc");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnFilterActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnAddBook.setText("Thêm sách");
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(tbtData);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1)
                                .addGroup(panelMainLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelMainLayout.createSequentialGroup()
                                        .addComponent(lblFromDate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DateChooserFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_between)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                        .addComponent(lblTodate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DateChooserTodate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblStatus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblStore)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxStore, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
        );
        panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMainLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblTodate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_between))
                                        .addComponent(lblFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateChooserTodate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DateChooserFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblStatus)
                                        .addComponent(cbxStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblStore)
                                        .addComponent(btnFilter)
                                        .addComponent(cbxStore, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(btnAddBook)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        menuBarStore.setText("Kho");

        if (listStores != null && listStores.size() > 0) {
            for (Store store : listStores) {
                //  System.out.println("store === " + store.getName());
                JMenuItem menuItem = new JMenuItem(store.getId() + "-" + store.getName());
                menuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            for (int i = 0; i < listStores.size(); i++) {
                                if (store.getId() == listStores.get(i).getId()) {
                                    cbxStore.setSelectedIndex(i);
                                    break;
                                }
                            }
                            listBooks = bookDa.getAllBookByStoreID(store.getId());
                            updateModel(listBooks);
                        } catch (SQLException ex) {
                            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });
                menuBarStore.add(menuItem);
            }
        }
        JMenuItem itemAll = new JMenuItem("Tất cả");
        itemAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbxStore.setSelectedIndex(listStores.size());
                listBooks = bookDa.getAll();
                updateModel(listBooks);
            }
        });
        menuBarStore.add(itemAll);

        jMenuBar1.add(menuBarStore);

        menuBarAccout.setText("Tài khoản");

        menuBarAccout.add(jMenuItemAccout);
        jMenuBar1.add(menuBarAccout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 194, Short.MAX_VALUE))
        );
        jMenuItemAccout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMain.removeAll();
                panelMain.add(new JLabel("Quan ly tai khoan"));
            }
        });
        cbxStatus1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemSelected = cbxStatus1.getSelectedItem().toString();
                System.out.println("it== " + itemSelected);
                if (itemSelected.equals("")) {
                    status = "";
                }
                if (itemSelected.equals("Dỗi")) {
                    status = "1";
                }
                if (itemSelected.equals("Đã mượn hết")) {
                    status = "0";
                }
            }
        });
        loadCombobox();
        pack();
    }// </editor-fold>                        

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateFrom = "";
        String dateTo = "";
        String store = ""; // Trong tat ca cac kho
        if (DateChooserFromDate.getDate() != null) {
            dateFrom = sdf.format(DateChooserFromDate.getDate());
        }
        System.out.println("date from === " + dateFrom);
        if (DateChooserFromDate.getDate() != null) {
            dateTo = sdf.format(DateChooserTodate.getDate());
        }
        System.out.println("date to === " + dateTo);
        if (cbxStore.getSelectedItem() != null) {
            if (!cbxStore.getSelectedItem().toString().equals("Tất cả")) {
                store = (cbxStore.getSelectedItem().toString()).split("-")[0];
            }
            System.out.println("store == " + store);
        }
        System.out.println("status == " + status);
        SearchOrFilter searchOrFilter = new SearchOrFilter();
        ArrayList<Book> listFilter = searchOrFilter.filterBook(dateFrom, dateTo, status, store);
        updateModel(listFilter);
    }

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {
        them_sach them = new them_sach(null);
    }

    public void updateModel(ArrayList<Book> listBok) {
        javax.swing.JFrame self = this;
        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Tên sách");
        model.addColumn("Tác giả");
        model.addColumn("Số lượng");
        model.addColumn("Trạng thái");
        int index = 0;
        for (Book book : listBok) {
            Object[] values = new Object[6];
            values[0] = String.valueOf(book.getId());
            values[1] = book.getName();
            values[2] = book.getAuthor();
            values[3] = book.getNumber();
            values[4] = book.getEmptyNumber() > 0 ? "Dỗi" : "Đã mượn hết";
            model.addRow(values);
        }
        tbtData.setModel(model);
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
    }

    public void loadCombobox() {
        for (Store store : listStores) {
            cbxStore.addItem(store.getId() + "-" + store.getName());
        }
        cbxStore.addItem("Tất cả");
        cbxStore.setSelectedIndex(listStores.size());
    }

    public static void main(String args[]) {
        Manager m = new Manager();
        // m.updateModel();
        //m.setVisible(true);
    }

}
