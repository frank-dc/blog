package org.frank.reference.special_class.Date_DateFormat_Calendar.p3_Calendar;

import java.util.Calendar;
/*
    Calendar:把时间分割成了一个个的年，月，日，时，分，秒等。如果我要得到一个完整的年月日时分秒，需要我们自己拼数据。

    日历对象	---		年，月，日，时，分，秒

    public int get(int field):返回给定日历字段的值。
 */

public class CalendarDemo1 {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        System.out.println(now);

        int year = now.get(Calendar.YEAR);
        System.out.println(year);

        int month = now.get(Calendar.MONTH);
        System.out.println(month);

        int date = now.get(Calendar.DATE);
        System.out.println(date);

        int hour = now.get(Calendar.HOUR);
        System.out.println(hour);

        int minute = now.get(Calendar.MINUTE);
        System.out.println(minute);

        int second = now.get(Calendar.MINUTE);
        System.out.println(second);
    }
}
