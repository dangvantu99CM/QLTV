package View.Quan_ly_tai_khoan;

import Controller.Quan_ly_tai_khoan.UserController;
import Model.Da.Da.UserDA;
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

public class FormLogin extends JFrame{

    public FormLogin() {
        initFormLogin();
    }

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox checkBoxMemoryAccount;
    private JButton btnLogin;
    private boolean isLoading = false;
    public static JLabel lblForgetPassword, lblUsername, lblCreateAccount, lblPassword, lblMemory;
    
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

        lblUsername = new JLabel("Tài khoản");
        lblPassword = new JLabel("Mật khẩu");
        btnLogin = new JButton("Đăng nhập");
        //lblMemory = new JLabel("Ghi nhớ mật khẩu");
        //checkBoxMemoryAccount = new JCheckBox();

        contend.add(lblUsername, "cell 0 0,alignx trailing");
        txtUsername = new JTextField();
        contend.add(getTxtUsername(), "cell 1 0,growx");

        contend.add(lblPassword, "cell 0 1,alignx trailing");
        txtPassword = new JPasswordField();
        contend.add(getTxtPassword(), "cell 1 1,growx");

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

       // p.add(checkBoxMemoryAccount);
        //p.add(lblMemory);

        //checkBoxMemoryAccount.setPreferredSize(new Dimension(50, 50));
      //  checkBoxMemoryAccount.setBackground(new Color(25, 26, 28, 0));

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
                JDialog f = new JDialog();
                try {
                    if (userController.login(getTxtUsername().getText(), getTxtPassword().getText())) {
                        System.out.println("Login correct !");
                        self.dispose();
                    } else {
                        JOptionPane.showMessageDialog(f, "Đăng nhập không thành công");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(f, "Đăng nhập không thành công");
                }
            }
        });
        lblForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FormForgotPassWord formForgotPass = new FormForgotPassWord();
            }
        });
        lblCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    FormRegister formRegister = new FormRegister();
                } catch (SQLException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                self.dispose();
            }
        });
    }
    /**
     * @return the txtUsername
     */
    public JTextField getTxtUsername() {
        return txtUsername;
    }

    /**
     * @return the txtPassword
     */
    public JPasswordField getTxtPassword() {
        return txtPassword;
    }
    
    public void setTxtUsername(String name){
        this.getTxtUsername().setText(name);
    }
    


}
