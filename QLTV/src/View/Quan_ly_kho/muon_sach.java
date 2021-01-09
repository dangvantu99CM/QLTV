package View.Quan_ly_kho;

import BaseClass.BaseClass;
import BaseClass.Validate;
import Config.Regex;
import Core.StoreCore.StoreCore;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.ConnectDb;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import Database.ConnectDb;
import Model.Da.Book;
import Model.Da.Da.BookDA;
import Model.Da.Da.UserDA;
import Model.Da.User;
import View.Quan_ly_tai_khoan.FormRegister;
import View.Thong_bao.Message;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class muon_sach extends JFrame {

    private JPanel contentPane;
    private Connection con = ConnectDb.connectDB();
    public JTextField textField, textField_1;

    public JLabel lblTnSch, lblLoiSch, lblTnUser, lblUsername, lblMsv;
    public JComboBox comboBox, comboBox_1, comboBox_2;

    private Message mes = BaseClass.getMessage();

    public BookDA bookDa = new BookDA();    
    public UserDA userDa = new UserDA();

    public ArrayList<Book> listBook = bookDa.getAll();
    public ArrayList<User> listUser = userDa.getAll();
    
    private Validate validator = new Validate();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    muon_sach frame = new muon_sach(8);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public muon_sach(int id_book) throws SQLException {

        JFrame self = this;
        Book bo = bookDa.getBookByID(id_book);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblTnSch = new JLabel("T\u00EAn s\u00E1ch");
        lblTnSch.setBounds(24, 14, 89, 14);
        contentPane.add(lblTnSch);

        lblLoiSch = new JLabel("Lo\u1EA1i s\u00E1ch");
        lblLoiSch.setBounds(24, 60, 78, 14);
        contentPane.add(lblLoiSch);

        lblTnUser = new JLabel("Sinh viên");
        lblTnUser.setBounds(24, 91, 78, 14);
        contentPane.add(lblTnUser);
        lblUsername = new JLabel("Tên sinh viên");
        lblUsername.setBounds(24, 122, 78, 14);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setBounds(140, 119, 213, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(140, 150, 213, 20);
        contentPane.add(textField_1);
        if (con != null) {
            String sql = "SELECT * FROM book where deleted_at is null";
            try {
                java.sql.PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt(1));
                    book.setStoreID(rs.getInt(3));
                    book.setName(rs.getString(2));
                    book.setType(rs.getInt(6));
                    book.setBookPrice(rs.getDouble(11));
                    book.setDeletedAt(rs.getString(12));
                    book.setAuthor(rs.getString(4));
                    listBook.add(book);
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        String[] tenBook = new String[listBook.size()];
        for (int i = 0; i < listBook.size(); i++) {
            tenBook[i] = listBook.get(i).getId() + "-" + listBook.get(i).getName();
        }
        String[] user = new String[listUser.size()];
        for (int i = 0; i < listUser.size(); i++) {
            user[i] = listUser.get(i).getID() + "-" + listUser.get(i).getName();
        }

        lblMsv = new JLabel("Mã sinh viên");
        lblMsv.setBounds(24, 153, 78, 14);
        contentPane.add(lblMsv);

        JButton btnMnSch = new JButton("M\u01B0\u1EE3n s\u00E1ch");

        btnMnSch.setBounds(295, 201, 89, 23);
        contentPane.add(btnMnSch);

        JButton btnT = new JButton("Tạo tài khoản");
        btnT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FormRegister formRegister = new FormRegister(self,-1);
                    self.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(muon_sach.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnT.setBounds(60, 201, 97, 23);
        contentPane.add(btnT);

        comboBox = new JComboBox(new DefaultComboBoxModel(tenBook));
        comboBox.setBounds(140, 11, 213, 20);
        contentPane.add(comboBox);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"Giáo Trình", "Tham Khảo"}));
        comboBox_1.setBounds(140, 57, 213, 20);
        contentPane.add(comboBox_1);

        comboBox_2 = new JComboBox(new DefaultComboBoxModel(user));
        comboBox_2.setSelectedItem(null);

        if (bo == null) {
            mes.showMessage("error", "Sách không có trong kho.");
        } else {
            for (int i = 0; i < listBook.size(); i++) {
                if (bo.getId() == listBook.get(i).getId()) {
                    comboBox.setSelectedIndex(i);
                    if (bo.getType() == 1) {
                        comboBox_1.setSelectedIndex(0);
                    } else {
                        comboBox_1.setSelectedIndex(1);
                    }
                    break;
                }
            }
        }

        comboBox_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Object itemSelected = comboBox_2.getSelectedItem();
                if (itemSelected != null) {
                    String s = (String) comboBox_2.getSelectedItem();
                    textField.setText(s.split("-")[1]);
                    try {
                        User user = userDa.getUserByID(Integer.valueOf(s.split("-")[0]));
                        if (user != null) {
                            textField_1.setText(String.valueOf(user.getMasv()));
                        } else {
                            System.out.println("User not found.");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(muon_sach.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        comboBox_2.setBounds(140, 88, 213, 20);
        contentPane.add(comboBox_2);

        btnMnSch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "";
                message += !(validator.validateSelected(comboBox,lblTnSch.getText())).equals("")
                        ? validator.validateSelected(comboBox,lblTnSch.getText())
                        + "\n" : "";
                message += !(validator.validateSelected(comboBox_1,lblLoiSch.getText())).equals("")
                        ? validator.validateSelected(comboBox_1,lblLoiSch.getText())
                        + "\n" : "";
                message += !(validator.validateSelected(comboBox_2,lblTnUser.getText())).equals("")
                        ? validator.validateSelected(comboBox_2,lblTnUser.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(textField.getText(), lblUsername.getText()).equals(""))
                        ? validator.validateFieldRequired(textField.getText(), lblUsername.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(textField_1.getText(), lblMsv.getText()).equals(""))
                        ? validator.validateFieldRequired(textField_1.getText(), lblMsv.getText())
                        : "";
                if (!message.equals("")) {
                    mes.showMessage("error", message);
                } else {
                    StoreCore storeCore = new StoreCore();
                    int bo_id = Integer.valueOf(comboBox.getSelectedItem().toString().split("-")[0]);
                    int us_id = Integer.valueOf(comboBox_2.getSelectedItem().toString().split("-")[0]);
                    if (storeCore.borrowBook(bo_id, us_id)) {
                        self.dispose();
                        mes.showMessage("success", "Muợn thành công.");
                    } else {
                        mes.showMessage("error", "Xử lý thất bại.");
                    }
                }

            }
        });
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void loadCombobox() {
        comboBox_2.removeAllItems();
        listUser = userDa.getAll();
        for (User u : listUser) {
            comboBox_2.addItem(u.getID() + "-" + u.getName());
        }
    }

}
