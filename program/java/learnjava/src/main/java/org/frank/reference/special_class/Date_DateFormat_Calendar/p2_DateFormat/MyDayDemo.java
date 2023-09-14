package org.frank.reference.special_class.Date_DateFormat_Calendar.p2_DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    计算你来到这个世界多少天了？
    1. 输入你出生的年月日
    2. 将字符串转换为日期对象
    3. 通过日期对象获取一个毫秒值
    4. 获取当前日期的毫秒值
    5. 用 4 - 3 得到一个毫秒值
    6. 将 5 得到的毫秒值计算成天为单位
 */
public class MyDayDemo {
    public static void main(String[] args) throws ParseException {
        // 键盘录入你出生的年月日
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的出生日期（yyyy-mm-dd）：");
        String dt_str = sc.nextLine();

        // 将日期字符串dt_str转换成日期对象
        String[] dt_formats = {"yyyy-MM-dd", "yyyy.MM.dd", "yyyy/MM/dd"};
        Date dt_obj = null;
        for(String item : dt_formats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(item);
                dt_obj = sdf.parse(dt_str);
                break;
            } catch (ParseException e) {
                continue;
            }

        }


        // 通过dt_obj获取一个毫秒值
        long myTime = dt_obj.getTime();

        // 获取当前时间毫秒值
        long curTime = System.currentTimeMillis();

        // 用 4 - 3 得到一个毫秒值
        long dateTime = curTime - myTime;

        // 日期毫秒值转成天数
        int days = (int) (dateTime / 1000 / 24/ 60 / 60);
        System.out.println("你已经来到这个世界 " + days + " 天了。");
        System.out.println("你已经来到这个世界 " + days / 365 + " 年了。");
    }
}
