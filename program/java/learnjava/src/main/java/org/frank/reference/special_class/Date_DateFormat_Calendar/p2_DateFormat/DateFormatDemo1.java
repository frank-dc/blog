package org.frank.reference.special_class.Date_DateFormat_Calendar.p2_DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    DateFormat: 是针对日期进行格式化和解析的抽象类
    其子类 SimpleDateFormat:
        格式化（日期对象 -> 日期字符串）
            Date -> String
            public final String format(Date date)

        解析（日期字符串 -> 日期对象）
            String -> Date
            public Date parse(String source)
 */
public class DateFormatDemo1 {
    public static void main(String[] args) throws ParseException {
        // Date -> String
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = sdf.format(d);
        System.out.println(result);

        // String -> Date
        String dt = "2008-08-08 12:00:05";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = sdf2.parse(dt);
        System.out.println(d2);
    }
}
