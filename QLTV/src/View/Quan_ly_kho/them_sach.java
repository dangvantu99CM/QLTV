package View.Quan_ly_kho;

import BaseClass.BaseClass;
import BaseClass.Validate;
import java.awt.BorderLayout;
import Database.ConnectDb;
import Model.Da.Da.BookDA;
import Model.Da.Da.StoreDA;
import Model.Da.Store;
import Model.Da.User;
import View.Thong_bao.Message;
import java.awt.Dialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

public class them_sach extends JDialog {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_3;
    private JTextField textField_4;
    private Connection con = ConnectDb.connectDB();
    private JTextField textField_5;
    private JTextField textField_2;

    private Message mes = BaseClass.getMessage();

    private Validate validator = new Validate();

    private Object frameAfter = null;

    private StoreDA storeDa = new StoreDA();

    private ArrayList<Store> listStore = storeDa.getAll();
    
    
    private int store_id = -1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    them_sach frame = new them_sach(null);
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
     *
     * @param frameAfter
     */
    public them_sach(Object frameAfter) {
        setModal(true);
        setResizable(false);
        setAlwaysOnTop(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.frameAfter = frameAfter;
        JDialog self = this;
        Map<String, Integer> kho = new HashMap();
        ArrayList<String> tenkho = new ArrayList();

        if (con != null) {
            String sql = "SELECT * FROM store where deleted_at is null AND st_slot_empty != 0";
            try {
                java.sql.PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    kho.put(rs.getString(2), rs.getInt(1));
                    tenkho.add(rs.getString(2));

                }

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        String[] convert = new String[tenkho.size()];
        for (int i = 0; i < listStore.size(); i++) {
            convert[i] = listStore.get(i).getId() + "-" + listStore.get(i).getName();
        }
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 359);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(131, 11, 236, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(131, 144, 236, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(131, 175, 236, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(131, 211, 236, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(convert));
        comboBox.setBounds(131, 108, 236, 25);
        contentPane.add(comboBox);

        JLabel lblTnSch = new JLabel("T\u00EAn s\u00E1ch");
        lblTnSch.setBounds(10, 14, 71, 14);
        contentPane.add(lblTnSch);

        JLabel lblLoiSch = new JLabel("Lo\u1EA1i s\u00E1ch");
        lblLoiSch.setBounds(10, 80, 79, 14);
        contentPane.add(lblLoiSch);

        JLabel lblThmVoKho = new JLabel("Th\u00EAm v\u00E0o kho");
        lblThmVoKho.setBounds(10, 113, 98, 14);
        contentPane.add(lblThmVoKho);

        JLabel lblGiSch = new JLabel("Gi\u00E1 s\u00E1ch");
        lblGiSch.setBounds(10, 147, 79, 14);
        contentPane.add(lblGiSch);

        JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
        lblSLng.setBounds(10, 178, 79, 14);
        contentPane.add(lblSLng);

        JLabel lblSNgyMn = new JLabel("S\u1ED1 ng\u00E0y m\u01B0\u1EE3n");
        lblSNgyMn.setBounds(10, 214, 111, 14);
        contentPane.add(lblSNgyMn);

        JButton btnThm = new JButton("Th\u00EAm");

        btnThm.setBounds(278, 254, 89, 23);
        contentPane.add(btnThm);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(131, 42, 236, 20);
        contentPane.add(textField_2);

        JLabel label = new JLabel("Tác giả");
        label.setBounds(10, 45, 71, 14);
        contentPane.add(label);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"Giáo Trình", "Tham Khảo"}));
        comboBox_1.setBounds(131, 73, 236, 25);
        contentPane.add(comboBox_1);
        btnThm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "";
                message += !(validator.validateFieldRequired(textField.getText(), lblTnSch.getText()).equals(""))
                        ? validator.validateFieldRequired(textField.getText(), lblTnSch.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(textField_3.getText(), lblGiSch.getText()).equals(""))
                        ? validator.validateFieldRequired(textField_3.getText(), lblGiSch.getText())
                        + "\n" : "";
                message += !(validator.validateSelected(comboBox_1, lblLoiSch.getText())).equals("")
                        ? validator.validateSelected(comboBox_1, lblLoiSch.getText())
                        + "\n" : "";
                message += !(validator.validateSelected(comboBox, lblThmVoKho.getText())).equals("")
                        ? validator.validateSelected(comboBox, lblThmVoKho.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(textField_4.getText(), lblSLng.getText()).equals(""))
                        ? validator.validateFieldRequired(textField_4.getText(), lblSLng.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(textField_5.getText(), lblSNgyMn.getText()).equals(""))
                        ? validator.validateFieldRequired(textField_5.getText(), lblSNgyMn.getText())
                        + "\n" : "";
                message += !(validator.validateFieldRequired(textField_2.getText(), label.getText()).equals(""))
                        ? validator.validateFieldRequired(textField_2.getText(), label.getText())
                        : "";
                if (!message.equals("")) {
                    mes.showMessage("error", message);
                } else {
                    if (!textField.getText().equals("") && !textField_3.getText().equals("") && !textField_4.getText().equals("") && !textField_2.getText().equals("") && !textField_5.getText().equals("")) {
                        if (con != null) {
                            String sql = "INSERT INTO book(bo_name, bo_id_store, bo_author, bo_status, bo_type, bo_number, bo_date_limit, bo_price,bo_empty_number) VALUE(?,?,?,?,?,?,?,?,?)";
                            try {
                                java.sql.PreparedStatement stmt = con.prepareStatement(sql);
                                stmt.setString(1, textField.getText());
                                stmt.setString(3, textField_2.getText());
                                stmt.setInt(2, Integer.valueOf((comboBox.getSelectedItem().toString()).split("-")[0]));
                                if (comboBox_1.getSelectedItem().equals("Giáo Trình")) {
                                    stmt.setInt(5, 1);
                                } else {
                                    stmt.setInt(5, 2);
                                }

                                stmt.setInt(4, 1);
                                stmt.setInt(6, Integer.parseInt(textField_4.getText()));
                                stmt.setInt(7, Integer.parseInt(textField_5.getText()));
                                stmt.setFloat(8, Float.parseFloat(textField_3.getText()));
                                stmt.setFloat(9, Integer.parseInt(textField_4.getText()));
                                stmt.execute();
                                self.dispose();
                                mes.showMessage("success", "Thêm sách thành công");
                                if (comboBox.getSelectedItem() != null) {
                                    String store_id = (comboBox.getSelectedItem().toString()).split("-")[0];
                                    storeDa.updateStore(Integer.valueOf(store_id), "add");
                                }
                                if (frameAfter != null) {
                                    if (frameAfter instanceof Quan_ly_sach) {
                                        Quan_ly_sach m = (Quan_ly_sach) frameAfter;
                                        BookDA bookDa = new BookDA();
                                        m.updateModel(bookDa.getAll());
                                    }
                                }
                            } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }

                    }
                }

            }
        });
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
