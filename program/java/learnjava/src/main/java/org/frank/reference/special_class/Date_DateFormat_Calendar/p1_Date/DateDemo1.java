package org.frank.reference.lei_class.Date_DateFormat_Calendar.p1_Date;

import java.util.Date;
/*
    类 Date 表示特定的瞬间，精确到毫秒

    构造方法：
        public Date(): 默认就是当前时间
        public Date(long date): 赋值给定的毫秒值

    成员方法：
        public long getTime(): 获取毫秒值
        public void setTime(long time): 将毫秒值作为参数传递给Date对象
 */

public class DateDemo1 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println("Date d: " + d);

        long time = System.currentTimeMillis();
        System.out.println(time);
        Date d2 = new Date(time);
        System.out.println("Date d2: " + d2);

        Date d3 = new Date(3600000);
        System.out.println("Date d3: " + d3);

        Date d4 = new Date();
        System.out.println(d4.getTime());
        System.out.println(System.currentTimeMillis());
        d4.setTime(3600000);
        System.out.println("Date d4: " + d4);
    }
}
