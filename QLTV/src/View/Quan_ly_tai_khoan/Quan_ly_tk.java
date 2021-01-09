/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Quan_ly_tai_khoan;

import BaseClass.BaseClass;
import Core.UserCore.SearchOrFilter;
import Model.Da.BookExtension;
import Model.Da.Da.BookDA;
import Model.Da.Da.StoreDA;
import Model.Da.Da.UserBookDA;
import Model.Da.Da.UserDA;
import Model.Da.Store;
import Model.Da.UserExtension;
import View.Quan_ly_kho.BookDetail;
import View.Quan_ly_kho.Manager;
import View.Quan_ly_kho.MyStore;
import View.Thong_bao.Message;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class Quan_ly_tk extends JPanel {

    private javax.swing.JLabel lblFromDateTk, lbl_between1, lblTodateTk, lblStatusTk, lblNameStudentTk, lblMsvTk;
    private javax.swing.JComboBox cbxStatusTk;
    private javax.swing.JButton btnFilterTk, btnSearchTk, btnAddTk;
    private javax.swing.JTable tbtDataTK;
    private javax.swing.JScrollPane jScrollPane2;

    private JTextField txtNameTk, txtMsvTk;

    private com.toedter.calendar.JDateChooser dateFromTk, dateToTk;
    private javax.swing.JSeparator jSeparator3, jSeparator4;

    private javax.swing.JPanel jPanel4, jPanel3;

    private DefaultTableModel model;
    private JScrollPane scrollPane;

    private UserDA userDA = new UserDA();
    private ArrayList<UserExtension> listUserBase = userDA.getAll();
    private SearchOrFilter searchOrFilter = new SearchOrFilter();

    private UserBookDA userBookDA = new UserBookDA();
    private Message mes = BaseClass.getMessage();

    public Quan_ly_tk() throws ParseException, SQLException {
        init();
        updateModel(listUserBase);
        this.add(jPanel3);
    }

    private void init() {
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        lblFromDateTk = new JLabel();
        lbl_between1 = new JLabel();
        lblTodateTk = new JLabel();
        lblStatusTk = new JLabel();
        lblNameStudentTk = new JLabel();
        lblMsvTk = new JLabel();

        cbxStatusTk = new javax.swing.JComboBox();

        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        btnFilterTk = new JButton();
        btnSearchTk = new JButton();
        btnAddTk = new JButton();

        dateFromTk = new com.toedter.calendar.JDateChooser();
        dateToTk = new com.toedter.calendar.JDateChooser();

        jScrollPane2 = new javax.swing.JScrollPane();
        tbtDataTK = new javax.swing.JTable();

        txtNameTk = new JTextField();
        txtMsvTk = new JTextField();

        lblFromDateTk.setText("From-date");

        lbl_between1.setText("~");

        lblTodateTk.setText("To-date");

        lblStatusTk.setText("Trạng thái");

        cbxStatusTk.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Đang mượn", "Quá hạn"}));

        btnFilterTk.setText("Lọc");
        btnFilterTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnFilterTkActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Quan_ly_tk.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Quan_ly_tk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Mã sinh viên");
        model.addColumn("Tên tài khoản");
        model.addColumn("Email");
        model.addColumn("Ngày mượn");
        model.addColumn("Trạng thái");

        jScrollPane2.setViewportView(tbtDataTK);

        lblMsvTk.setText("Mã sinh viên");

        btnSearchTk.setText("Tìm kiếm");

        btnSearchTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSearchTkActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Quan_ly_tk.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Quan_ly_tk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnAddTk.setText("Thêm mới");

        btnAddTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTkActionPerformed(evt);
            }
        });

        lblNameStudentTk.setText("Tên sinh viên");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jSeparator3)
                                                .addComponent(jScrollPane2)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(lblFromDateTk, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblMsvTk))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                        .addComponent(dateFromTk, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(lbl_between1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(lblTodateTk, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(dateToTk, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                        .addComponent(txtMsvTk, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(12, 12, 12)
                                                                        .addComponent(lblNameStudentTk)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(txtNameTk, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(44, 44, 44)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                        .addComponent(lblStatusTk, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(cbxStatusTk, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                                                                        .addComponent(btnFilterTk, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                        .addComponent(btnSearchTk, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE).addComponent(btnAddTk, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(15, 15, 15))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jSeparator4)
                                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_between1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTodateTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblStatusTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbxStatusTk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnFilterTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(dateFromTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblFromDateTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(dateToTk, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMsvTk, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNameStudentTk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNameTk, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearchTk, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblMsvTk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddTk, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1020, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 532, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
        );
        tbtDataTK.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String data = (String) tbtDataTK.getValueAt(tbtDataTK.getSelectedRow(), 0);
                try {
                    MyStore myStore = new MyStore(Integer.valueOf(data));
                } catch (SQLException ex) {
                    Logger.getLogger(Quan_ly_tk.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Quan_ly_tk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void updateModel(ArrayList<UserExtension> listUser) throws ParseException, SQLException {
        int rowCount = model.getRowCount();
        Calendar calendar = Calendar.getInstance();
        Date dateNow = calendar.getTime();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (UserExtension user : listUser) {
            Object[] values = new Object[6];
            values[0] = String.valueOf(user.getID());
            values[1] = user.getMasv();
            values[2] = user.getName();
            values[3] = user.getEmail();
            values[4] = user.getDateBorrow();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.setTime(dateFormatter.parse(user.getDateBorrow()));
            calendar.add(Calendar.DATE, user.getUserBookDateLimt());

            if (calendar.getTime().compareTo(dateNow) >= 0) {
                userBookDA.updateStatus(user.getIdUsBo(), 1, 0, 0);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("calendar.getTime() >= " + calendar.getTime());
                System.out.println("So ngay qua han == " + 0);
                System.out.println("tien phat == " + 0);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                values[5] = "Đang mượn";
            }
            if (calendar.getTime().compareTo(dateNow) < 0) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("calendar.getTime() < " + calendar.getTime());
                values[5] = "Quá hạn";
                long ngay_tra = dateNow.getTime();
                long han_tra = calendar.getTime().getTime();
                double so_ngay_qua_han = (double) Math.abs((han_tra - ngay_tra)) / (double) (24 * 3600 * 1000);
                
                DecimalFormat df = new DecimalFormat("#");
                so_ngay_qua_han = Double.valueOf(df.format(so_ngay_qua_han));
                if(so_ngay_qua_han == 0){
                    so_ngay_qua_han = 1;
                }
                double tien_phat = so_ngay_qua_han * 2000;
               // System.out.println("date borrow == " + user.getDateBorrow());
                // values[6] = so_ngay_qua_han;
                //values[7] = Math.abs(tien_phat);
                // System.out.println("us_id == "  + user.getIdUsBo() + ",  so_ngay_qua_han == " + so_ngay_qua_han + ", tien_phat == " + tien_phat);
                userBookDA.updateStatus(user.getIdUsBo(), 2, (int) so_ngay_qua_han, tien_phat);
            }

            model.addRow(values);
        }
        tbtDataTK.setModel(model);
    }

    private void btnFilterTkActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException {
        System.out.println("aaaaaaaaaaaaaaaaaa");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateFrom = "";
        String dateTo = "";
        String status = "";
        if (dateFromTk.getDate() != null) {
            dateFrom = sdf.format(dateFromTk.getDate());
        }
        System.out.println("date from === " + dateFrom);
        if (dateToTk.getDate() != null) {
            dateTo = sdf.format(dateToTk.getDate());
        }
        System.out.println("date to === " + dateTo);
        if (cbxStatusTk.getSelectedItem() != null) {
            if (!cbxStatusTk.getSelectedItem().toString().equals("")) {
                String selectedVal = cbxStatusTk.getSelectedItem().toString();
                if (selectedVal.equals("")) {
                    status = "";
                }
                if (selectedVal.equals("Đang mượn")) {
                    status = "1";
                }
                if (selectedVal.equals("Quá hạn")) {
                    status = "2";
                }
            }
        }
        System.out.println("status == " + status);

        ArrayList<UserExtension> listFilter = searchOrFilter.filterUser(dateFrom, dateTo, status);
        updateModel(listFilter);
    }

    private void btnSearchTkActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException {
        String nameSvVal = txtNameTk.getText();
        String msvVal = txtMsvTk.getText();
        ArrayList<UserExtension> resultList = searchOrFilter.searchUser(msvVal, nameSvVal);
        if (resultList.size() > 0) {
            updateModel(resultList);
        } else {
            mes.showMessage("error", "Không có dữ liệu.");
            updateModel(listUserBase);
        }
    }

    private void btnAddTkActionPerformed(java.awt.event.ActionEvent evt) {

    }

}
