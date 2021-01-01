package View.Quan_ly_kho;

import BaseClass.BaseClass;
import BaseClass.Validate;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Database.ConnectDb;
import View.Thong_bao.Message;

public class tao_kho extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private Connection con = ConnectDb.connectDB();

    private Message mes = BaseClass.getMessage();

    private Validate validator = new Validate();
    
    JLabel lblTnKho,lblVTr,lblSlotMax;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    tao_kho frame = new tao_kho();
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
    public tao_kho() {
        JFrame self = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 460, 265);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        textField = new JTextField();
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);

        lblTnKho = new JLabel("T\u00EAn kho");

        lblVTr = new JLabel("V\u1ECB tr\u00ED");

        lblSlotMax = new JLabel("Slot max");

        JButton btnThm = new JButton("Th\u00EAm");
        btnThm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String message = "";
                message += !(validator.validateFieldRequired(textField.getText(), lblTnKho.getText()).equals(""))
                        ? validator.validateFieldRequired(textField.getText(), lblTnKho.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(textField_1.getText(), lblTnKho.getText()).equals(""))
                        ? validator.validateFieldRequired(textField_1.getText(), lblTnKho.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(textField_2.getText(), lblSlotMax.getText()).equals(""))
                        ? validator.validateFieldRequired(textField_2.getText(), lblSlotMax.getText())
                        : "";
                if (!message.equals("")) {
                    mes.showMessage("error", message);
                } else {
                    if (!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("")) {
                        if (con != null) {
                            String sql = "INSERT INTO store(st_name, st_position, st_status, st_max_slot) VALUES (?, ?, ?, ?)";
                            try {
                                java.sql.PreparedStatement stmt = con.prepareStatement(sql);
                                stmt.setString(1, textField.getText());
                                stmt.setString(2, textField_1.getText());
                                stmt.setInt(3, 1);
                                stmt.setInt(4, Integer.valueOf(textField_2.getText()));
                                stmt.execute();
                                self.dispose();
                                mes.showMessage("success", "Tạo kho thành công");
                            } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(btnThm))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGap(21)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(lblTnKho)
                                                .addComponent(lblVTr)
                                                .addComponent(lblSlotMax))
                                        .addGap(63)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(textField_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                .addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                .addComponent(textField, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
                        .addGap(49))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addGap(22)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTnKho))
                        .addGap(18)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblVTr))
                        .addGap(18)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSlotMax))
                        .addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnThm)
                        .addGap(34))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
