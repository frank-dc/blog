package org.frank.reference.special_class.Date_DateFormat_Calendar.p2_DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
    private DateTool(){}

    public static String getRQ(Date d) {
        /**
         * 获取年月日时分秒的方法
         * @param d
         * @return String
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    public static String getNYR(Date d) {
        /**
         * 获取年月日的方法
         * @param d
         * @return String
         */
        return new SimpleDateFormat("yyyy-MM-dd").format(d);
    }

    public static String getSFM(Date d) {
        /**
         * 获取时分秒的方法
         * @param d
         * @return String
         */
        return new SimpleDateFormat("HH:mm:ss").format(d);
    }
}
