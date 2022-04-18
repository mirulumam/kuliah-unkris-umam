package id.chairulumam.kuliah.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Helper {

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        try {
            bd = bd.setScale(decimalPlace, RoundingMode.HALF_UP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bd.floatValue();
    }

}
