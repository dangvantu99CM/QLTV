package View.Quan_ly_tai_khoan;

import Controller.Quan_ly_tai_khoan.UserController;
import Model.Da.Da.UserDA;
import Model.Da.Faculty;
import Model.Da.Major;
import Model.Da.School;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class FormRegister<T> extends JFrame {

    private JTextField txtUsername, txtPasswordAgain, txtEmail, txtMsv, txtPhoneNumber, txtNienKhoa;
    private JPasswordField txtPassword;
    private JButton btnResgister, btnCancel;
    private boolean isLoading = false;
    private JComboBox cbxListSchool = new JComboBox();
    private JComboBox cbxListFaculty = new JComboBox();
    private JComboBox cbxListMajor = new JComboBox();
    public UserController userController;

    public ArrayList<School> listSchool;
    public ArrayList<Faculty> listFaculty;
    public ArrayList<Major> listMajor;

    public FormRegister() throws SQLException {
        userController = new UserController(this);
        this.setTitle("Đăng ký");
        this.setSize(780, 442);
        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("asset/img/bg_1.jpg")));
        background.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setContentPane(background);
        this.setLayout(new BorderLayout());

        String[] petStrings = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};

        listSchool = userController.getListSchool();
        listFaculty = userController.getListFaculty();
        listMajor = userController.getListMajor();

        loadCombobox((ArrayList<T>) listSchool, cbxListSchool, 1);
        //loadCombobox((ArrayList<T>)listFaculty, cbxListFaculty);
        //loadCombobox((ArrayList<T>)listMajor, cbxListMajor);

        JPanel contend = new JPanel();
        contend.setLayout(new MigLayout("", "[][grow]", "[][]"));

        JLabel lblUsername = new JLabel("Tên truy nhập*");
        contend.add(lblUsername, "cell 0 0,alignx trailing");
        txtUsername = new JTextField();
        contend.add(txtUsername, "cell 1 0,growx");

        JLabel lblPassword = new JLabel("Mật khẩu*");
        contend.add(lblPassword, "cell 0 1,alignx trailing");
        txtPassword = new JPasswordField();
        contend.add(txtPassword, "cell 1 1,growx");

        JLabel lblPasswordAgain = new JLabel("Gõ lại MK*");
        contend.add(lblPasswordAgain, "cell 0 2,alignx trailing");
        txtPasswordAgain = new JPasswordField();
        contend.add(txtPasswordAgain, "cell 1 2,growx");

        JLabel lblMsv = new JLabel("Mã sinh viên*");
        contend.add(lblMsv, "cell 0 3,alignx trailing");
        txtMsv = new JTextField();
        contend.add(txtMsv, "cell 1 3,growx");

        JLabel lblPhoneNumber = new JLabel("Số điện thoại*");
        contend.add(lblPhoneNumber, "cell 0 4,alignx trailing");
        txtPhoneNumber = new JTextField();
        contend.add(txtPhoneNumber, "cell 1 4,growx");

        JLabel lblEmail = new JLabel("Email*");
        contend.add(lblEmail, "cell 0 5,alignx trailing");
        txtEmail = new JTextField();
        contend.add(txtEmail, "cell 1 5,growx");

        JLabel lblNien_khoa = new JLabel("Niên khóa*");
        contend.add(lblNien_khoa, "cell 0 6,alignx trailing");
        txtNienKhoa = new JTextField();
        contend.add(txtNienKhoa, "cell 1 6,growx");

        JLabel lblSchool = new JLabel("Trường*");
        contend.add(lblSchool, "cell 0 7,alignx trailing");
        contend.add(cbxListSchool, "cell 1 7,growx");

        JLabel lblFaculty = new JLabel("Khoa*");
        contend.add(lblFaculty, "cell 0 8,alignx trailing");
        contend.add(cbxListFaculty, "cell 1 8,growx");

        JLabel lblMarjor = new JLabel("Ngành*");
        contend.add(lblMarjor, "cell 0 9,alignx trailing");
        contend.add(cbxListMajor, "cell 1 9,growx");

        btnResgister = new JButton("Đăng Ký");
        btnCancel = new JButton("Thoát");
        contend.add(btnResgister, "cell 1 10,growx");
        contend.add(btnCancel, "cell 1 10,growx");
        contend.setBackground(new Color(0f, 0f, 0f, 0f));
        contend.setBorder(BorderFactory.createEmptyBorder(30, 400, 0, 0));

        this.add(contend, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        actionListener();
    }

    public void loadCombobox(ArrayList<T> list, JComboBox cbx, int type) {
        if (list.size() <= 0) {
            return;
        }
        for (T x : list) {
            if (type == 1) {
                School school = new School();
                school = (School) x;
                cbx.addItem(school.getName());
                cbx.setSelectedItem(school);
            }
            if (type == 2) {
                Faculty fac = new Faculty();
                fac = (Faculty) x;
                cbx.addItem(fac.getName());
                cbx.setSelectedItem(fac);
            }
            if (type == 3) {
                Major major = new Major();
                major = (Major) x;
                cbx.addItem(major.getName());
                cbx.setSelectedItem(major);
            }
        }
    }

    public void actionListener() {
        JFrame self = this;
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormLogin formLogin = new FormLogin();
                self.dispose();
            }
        });
        btnResgister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDA userDa = new UserDA();
                JDialog f = new JDialog();
                //  try {
                // boolean isAddSucess = itemDa.addUser(
                //        new User(txtUsername.getText(), txtPassword.getText(), txtEmail.getText(), 0));
                // if (isAddSucess) {
                //     MenuComponent menuComponent = new MenuComponent(); 
                //      self.dispose();
                //  } else {
                //      JOptionPane.showMessageDialog(f, "Đăng kí thất bại!");
            }
            //   } catch (SQLException ex) {
            //      ex.printStackTrace();
            //      JOptionPane.showMessageDialog(f, "Error");
            // }
            // }
        });
        cbxListSchool.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cbxListSchool == " + cbxListSchool.getSelectedIndex());
              //  try {
                 //   listFaculty = userController.getListFacultyBySchId(cbxListSchool.getSelectedIndex());

//                } catch (SQLException ex) {
//                    Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                if (listFaculty == null || listFaculty.size() == 0) {
//                    return;
//                }
               // loadCombobox((ArrayList<T>) listFaculty, cbxListFaculty, 2);
            }
        });
        cbxListFaculty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cbxListFaculty == " + cbxListSchool.getSelectedIndex());
               // try {
                   // listMajor = userController.getListMajorByFacId(cbxListFaculty.getSelectedIndex());
//                } catch (SQLException ex) {
//                    Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                if (listMajor == null || listMajor.size() == 0) {
//                    return;
//                }
                //loadCombobox((ArrayList<T>) listMajor, cbxListMajor, 3);
            }
        });
        cbxListMajor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        FormRegister f = new FormRegister();
        f.actionListener();
    }
}
