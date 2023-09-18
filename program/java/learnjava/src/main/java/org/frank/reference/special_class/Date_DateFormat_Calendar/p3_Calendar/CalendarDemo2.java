package org.frank.reference.special_class.Date_DateFormat_Calendar.p3_Calendar;

import java.util.Calendar;
/*
    public void add(int field, int amount): 根据给定的日历自动和值，改变时间
    public final void set(int year, int month, int date): 设置年月日
    public void set(int field, int value): 根据给定的日历，设置值
 */

public class CalendarDemo2 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "---" + (c.get(Calendar.MONTH) + 1) + "---" + c.get(Calendar.DATE));

        c.add(Calendar.YEAR, -3);
        c.add(Calendar.MONTH, 2);
        c.add(Calendar.DATE, -12);
        System.out.println(c.get(Calendar.YEAR) + "---" + (c.get(Calendar.MONTH) + 1) + "---" + c.get(Calendar.DATE));

        c.set(2012, 3, 5);
        System.out.println(c.get(Calendar.YEAR) + "---" + (c.get(Calendar.MONTH) + 1) + "---" + c.get(Calendar.DATE));

        c.set(Calendar.YEAR, 2025);
        System.out.println(c.get(Calendar.YEAR) + "---" + (c.get(Calendar.MONTH) + 1) + "---" + c.get(Calendar.DATE));
    }
}
