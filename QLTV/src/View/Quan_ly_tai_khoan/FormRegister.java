package View.Quan_ly_tai_khoan;

import Controller.Quan_ly_tai_khoan.UserController;
import Model.Da.Da.UserDA;
import Model.Da.Faculty;
import Model.Da.Major;
import Model.Da.School;
import Model.Da.User;
import View.Thong_bao.Message;
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

    private JTextField txtUsername, txtPasswordAgain, txtEmail, txtMsv;
    private JPasswordField txtPassword;
    private JButton btnResgister, btnCancel;
    
    private int sch_id=-1;
    private int fac_id=-1;
    private int maj_id=-1;
    
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

        JLabel lblEmail = new JLabel("Email*");
        contend.add(lblEmail, "cell 0 4,alignx trailing");
        txtEmail = new JTextField();
        contend.add(txtEmail, "cell 1 4,growx");

        JLabel lblSchool = new JLabel("Trường*");
        contend.add(lblSchool, "cell 0 5,alignx trailing");
        contend.add(cbxListSchool, "cell 1 5,growx");

        JLabel lblFaculty = new JLabel("Khoa*");
        contend.add(lblFaculty, "cell 0 6,alignx trailing");
        contend.add(cbxListFaculty, "cell 1 6,growx");

        JLabel lblMarjor = new JLabel("Ngành*");
        contend.add(lblMarjor, "cell 0 7,alignx trailing");
        contend.add(cbxListMajor, "cell 1 7,growx");

        btnResgister = new JButton("Đăng Ký");
        btnCancel = new JButton("Thoát");
        contend.add(btnResgister, "cell 1 8,growx");
        contend.add(btnCancel, "cell 1 8,growx");
        contend.setBackground(new Color(0f, 0f, 0f, 0f));
        contend.setBorder(BorderFactory.createEmptyBorder(30, 400, 0, 0));

        this.add(contend, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        actionListener();

    }

    // type = 1 : truong
    // type = 2: khoa
    // type = 3 : nganh
    public void loadCombobox(ArrayList<T> list, JComboBox cbx, int type) {
        cbx.removeAllItems();
        if (list.size() == 0) {
            return;
        }
        for (T x : list) {
            if (type == 1) {
                School school = new School();
                school = (School) x;
                cbx.addItem(school.getId() + " - " + school.getName());
            }
            if (type == 2) {
                Faculty fac = new Faculty();
                fac = (Faculty) x;
                cbx.addItem(fac.getId() + " - " + fac.getName());
            }
            if (type == 3) {
                Major major = new Major();
                major = (Major) x;
                cbx.addItem(major.getId() + " - " + major.getName());
            }
        }
        cbx.setSelectedItem(null);
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
                Message mes = new Message();
                
                User us = new User();
                
                us.setEmail(txtEmail.getText());
                us.setName(txtUsername.getText());
                us.setId_faculty(fac_id);
                us.setId_major(maj_id);
                us.setId_school(sch_id);
                us.setPassword(txtPassword.getText());
                us.setRole(2);
                us.setMasv(Integer.valueOf(txtMsv.getText()));
                
                User addUser = userDa.create(us);
                if(addUser != null){
                    mes.showMessage("error","Đăng ký không thành công");
                }else{
                    FormLogin formLogin = new FormLogin();
                    self.dispose();
                }
            }
        });
        cbxListSchool.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String itemSelected = cbxListSchool.getSelectedItem().toString();
                sch_id = Regex.findNumber(itemSelected);
                try {
                    listFaculty = userController.getListFacultyBySchId(sch_id);
                    loadCombobox((ArrayList<T>) listFaculty, cbxListFaculty, 2);
                    cbxListFaculty.setSelectedItem(null);
                } catch (SQLException ex) {
                    Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        cbxListFaculty.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object itemSelected = cbxListFaculty.getSelectedItem();
                if (itemSelected != null) {
                    try {
                        fac_id = Regex.findNumber(itemSelected.toString());
                        listMajor = userController.getListMajorByFacId(fac_id);
                        loadCombobox((ArrayList<T>) listMajor, cbxListMajor, 3);
                        cbxListMajor.setSelectedItem(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        cbxListMajor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object itemSelected = cbxListMajor.getSelectedItem();
                if (itemSelected != null) {
                    maj_id = Regex.findNumber(itemSelected.toString());
                }
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        FormRegister f = new FormRegister();
        f.actionListener();
    }
}
