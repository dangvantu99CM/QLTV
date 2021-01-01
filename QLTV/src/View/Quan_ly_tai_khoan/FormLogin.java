package View.Quan_ly_tai_khoan;

import BaseClass.BaseClass;
import BaseClass.Validate;
import Controller.Quan_ly_tai_khoan.UserController;
import Model.Da.Da.UserDA;
import View.Thong_bao.Message;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;

public class FormLogin extends JFrame {

    public FormLogin() {
        initFormLogin();
    }

    private Connection con = BaseClass.getConnectDb();
    private Message mes = BaseClass.getMessage();
    private Validate validator = new Validate();

    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JCheckBox checkBoxMemoryAccount;
    private JButton btnLogin;
    private boolean isLoading = false;
    public static JLabel lblForgetPassword, lblEmail, lblCreateAccount, lblPassword, lblMemory;

    public UserController userController;

    public void initFormLogin() {
        userController = new UserController(this);
        this.setTitle("Đăng nhập");
        this.setSize(780, 442);
        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("asset/img/bg_1.jpg")));
        background.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setContentPane(background);
        this.setLayout(new BorderLayout());

        JPanel contend = new JPanel();
        contend.setLayout(new MigLayout("", "[][grow]", "[][]"));

        lblEmail = new JLabel("Email");
        lblPassword = new JLabel("Mật khẩu");
        btnLogin = new JButton("Đăng nhập");

        contend.add(lblEmail, "cell 0 0,alignx trailing");
        txtEmail = new JTextField();
        contend.add(getTxtUsername(), "cell 1 0,growx");

        contend.add(lblPassword, "cell 0 1,alignx trailing");
        txtPassword = new JPasswordField();
        contend.add(getTxtPassword(), "cell 1 1,growx");

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p.setBackground(new Color(0f, 0f, 0f, 0f));
        contend.add(p, "cell 1 2,growx");

        lblForgetPassword = new JLabel("Quên mật khẩu");
        lblCreateAccount = new JLabel("Tạo tài khoản");
        lblForgetPassword.setForeground(Color.BLUE);
        lblCreateAccount.setForeground(Color.BLUE);

        contend.add(lblForgetPassword, "cell 1 2,growx");
        contend.add(lblCreateAccount, "cell 1 2,growx");
        contend.add(btnLogin, "cell 1 3,growx");

        contend.setBackground(new Color(0f, 0f, 0f, 0f));
        contend.setBorder(BorderFactory.createEmptyBorder(70, 400, 0, 0));
        this.add(contend, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        actionListener();
    }

    public void actionListener() {
        JFrame self = this;
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String message = "";
                    message += !(validator.validateFieldRequired(txtEmail.getText(), lblEmail.getText()).equals("")) ? 
                                    validator.validateFieldRequired(txtEmail.getText(), lblEmail.getText())
                                    + "\n" : "";
                    message += !(validator.validateFieldRequired(txtPassword.getText(), lblPassword.getText()).equals("")) ? 
                                    validator.validateFieldRequired(txtPassword.getText(), lblPassword.getText())
                                    + "\n" : "";
                    
                    message += !(validator.validateEmail(txtEmail.getText()).equals("")) ?
                                    validator.validateEmail(txtEmail.getText())
                                    + "\n" : "";
                    
                    if (!message.equals("")) {
                        mes.showMessage("error", message);
                    } else {
                        if (userController.login(txtEmail.getText(), txtPassword.getText())) {
                            self.dispose();
                        } else {
                            mes.showMessage("error", "Mật khẩu hoặc Email không đúng");
                        }
                    }
                } catch (SQLException ex) {
                    mes.showMessage("error", "Mật khẩu hoặc Email không đúng");
                }
            }
        });
        lblForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FormForgotPassWord formForgotPass = new FormForgotPassWord();
                self.dispose();
            }
        });
        lblCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    FormRegister formRegister = new FormRegister(self);
                } catch (SQLException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                self.dispose();
            }
        });
    }

    /**
     * @return the txtEmail
     */
    public JTextField getTxtUsername() {
        return txtEmail;
    }

    /**
     * @return the txtPassword
     */
    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtUsername(String name) {
        this.getTxtUsername().setText(name);
    }

    public static void main(String[] args) {
        FormLogin fl = new FormLogin();
    }
}
