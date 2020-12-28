package View.Quan_ly_tai_khoan;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class FormForgotPassWord extends JFrame{
    private JTextField txtEmail;
    private JButton btnSendEmail;
    private JButton btnExit;
    private JLabel lb;
    public FormForgotPassWord(){
        initForm();
    }
    public void initForm(){
        this.setTitle("Quên mật khẩu");
        this.setSize(400,320);
        this.setLocationRelativeTo(null);
        this.setLayout(new MigLayout("", "[][grow]", "[][]"));
        lb = new JLabel("Hãy điền địa chỉ Email của bạn để nhận lại các thông tin tài khoản");
        txtEmail = new JTextField(1000);
        btnSendEmail = new JButton("Gửi email");
        btnExit = new JButton("Thoát");
        this.add(txtEmail, "cell 0 1,alignx trailing");
        this.add(btnSendEmail, "cell 1 1,alignx trailing");
        this.add(btnExit, "cell 1 2,alignx trailing");  
        actionListener();
        this.setVisible(true);
    }
    
    public void actionListener(){
        JFrame self = this;
        btnExit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               self.dispose();
               FormLogin formLogin = new FormLogin();
           }
        });
        btnSendEmail.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("submit====");
           }
        });
    }
    
    public static void main(String[] args) {
        FormForgotPassWord f = new FormForgotPassWord();
    }
}
