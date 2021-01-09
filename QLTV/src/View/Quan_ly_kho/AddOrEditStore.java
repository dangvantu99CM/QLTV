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
import Model.Da.Da.StoreDA;
import Model.Da.Store;
import View.Thong_bao.Message;
import javax.swing.JDialog;

public class AddOrEditStore extends JDialog {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2, txtStatus;
    private Connection con = ConnectDb.connectDB();

    private Message mes = BaseClass.getMessage();

    private Validate validator = new Validate();

    private int store_id_edit = -1;

    private StoreDA storeDa = new StoreDA();

    JLabel lblTnKho, lblVTr, lblSlotMax, lblStatus;

    private Object frameAfter = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddOrEditStore frame = new AddOrEditStore(7, null);
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
    public AddOrEditStore(int store_id_edit, Object frameAfter) throws SQLException {
        setModal(true);
        setResizable(false);
        setAlwaysOnTop(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        this.frameAfter = frameAfter;
        this.store_id_edit = store_id_edit;
        JDialog self = this;
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        if (store_id_edit != -1) {
            System.out.println("store === " + store_id_edit);
            btnThm.setText("Cập nhật");
            Store store = storeDa.getStoreByID(store_id_edit);
            if (store != null) {
                textField.setText(store.getName());
                textField_1.setText(store.getPosition());
                textField_2.setText(String.valueOf(store.getSt_max_slot()));
            }
        }

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
                    if (store_id_edit != -1) {
                        Store store = new Store();
                        store.setPosition(textField_1.getText());
                        store.setSt_max_slot(Integer.valueOf(textField_2.getText()));
                        store.setName(textField.getText());
                        boolean isEdit = storeDa.update(store_id_edit, store);
                        if (isEdit) {
                            self.dispose();
                            mes.showMessage("success", "Cập nhật thành công");
                            if (frameAfter != null) {
                                if (frameAfter instanceof Quan_ly_kho) {
                                    Quan_ly_kho quanLyKho = (Quan_ly_kho) frameAfter;
                                    quanLyKho.refreshModel();
                                }
                            }
                        } else {
                            mes.showMessage("error", "Cập nhật không thành công");
                        }
                    } else {
                        if (!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("")) {
                            if (con != null) {
                                String sql = "INSERT INTO store(st_name, st_position, st_status, st_max_slot,st_slot_empty) VALUES (?,?, ?, ?, ?)";
                                try {
                                    java.sql.PreparedStatement stmt = con.prepareStatement(sql);
                                    stmt.setString(1, textField.getText());
                                    stmt.setString(2, textField_1.getText());
                                    stmt.setInt(3, 1);
                                    stmt.setInt(4, Integer.valueOf(textField_2.getText()));
                                    stmt.setInt(5, Integer.valueOf(textField_2.getText()));
                                    stmt.execute();
                                    self.dispose();
                                    mes.showMessage("success", "Tạo kho thành công");
                                    if (frameAfter != null) {
                                        if (frameAfter instanceof Quan_ly_kho) {
                                            Quan_ly_kho quanLyKho = (Quan_ly_kho) frameAfter;
                                            quanLyKho.refreshModel();
                                        }
                                    }
                                } catch (SQLException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
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
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
