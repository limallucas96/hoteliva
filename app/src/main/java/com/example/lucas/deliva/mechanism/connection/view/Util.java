package com.example.lucas.deliva.mechanism.connection.view;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static String formatCurrency(Double val) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("PT", "BR"));
        return numberFormat.format(val);
    }

    public static boolean isValidEmail(CharSequence target) {
        Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher matcher = pattern.matcher(target);
        return matcher.matches();
    }


}
