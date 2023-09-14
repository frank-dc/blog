package org.frank.reference.special_class.Date_DateFormat_Calendar.p2_DateFormat;

import java.util.Date;

public class DateToolTest {
    public static void main(String[] args) {
        Date d = new Date();

        System.out.println(DateTool.getRQ(d));
        System.out.println(DateTool.getNYR(d));
        System.out.println(DateTool.getSFM(d));
    }
}
