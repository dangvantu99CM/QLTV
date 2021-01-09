/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tudv
 */
public class Constant {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static String error_field_required(String field_name) {
        return "Nhập " + field_name + " là bắt buộc.";
    }

    public static String error_format_mail() {
        return "Vui lòng nhập đúng định dạng e-mail.";
    }

    public static String error_same_pass_work() {
        return "Mật khẩu nhập lại không đúng";
    }

    public static String error_empty_selected(String field_name) {
        return "Chọn " + field_name + " là bắt buộc.";
    }

    public static String getStringDateNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
