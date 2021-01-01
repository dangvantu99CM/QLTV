/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tudv
 */
public class Regex {

    public static int findNumber(String s) {
        s = s.replaceAll("\\s+", "");
        Pattern pattern = Pattern.compile("^([0-9])*\\-.*$");
        Matcher matcher = pattern.matcher(s);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return Integer.valueOf(matcher.group(1));
        }
        return -1;
    }
}
