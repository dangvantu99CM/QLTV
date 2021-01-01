/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseClass;

import Config.Constant;
import View.Thong_bao.Message;
import java.sql.Connection;
import java.util.regex.Matcher;
import javax.swing.JComboBox;

/**
 *
 * @author tudv
 */
public class Validate {

    private Message mess = BaseClass.getMessage();

    public String validateEmail(String email) {
        Matcher matcher = Constant.VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return !matcher.find() ? Constant.error_format_mail() : "";
    }

    public String validateFieldRequired(String value,String fieldName) {
        if (value.equals("")) {
            return Constant.error_field_required(fieldName);
        }
        return "";
    }

    public String validateSamePass(String oldPass, String newPass) {
        if (oldPass.equals(newPass)) {
            return "";
        }
        return Constant.error_same_pass_work();
    }

    public String validateSelected(JComboBox combobox,String field_name) {
        if (combobox.getSelectedItem() == null) {
            return Constant.error_empty_selected(field_name);
        }
        return "";
    }
}
