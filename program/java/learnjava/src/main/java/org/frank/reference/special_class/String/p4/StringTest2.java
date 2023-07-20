package org.frank.reference.special_class.String.p4;

import java.util.Scanner;

/*
    统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
    举例：Hello123World
    结果：
        大写：2
        小写：8
        数字：3

    分析：
        1. 键盘录入字符串（只有字母和数字）
        2. 定义三个统计变量，分别是大写字母数量、小写字母数量、数字数量
        3. 遍历字符串，获取每一个字符
        4. 判断字符（大写、小写还是数字）
            ASCII码：
                A: 65
                Z: 90
                a: 97
                z: 122
                0: 48
                9: 57
        5. 给出结果
 */
public class StringTest2 {
    public static void main(String[] args) {
        // 键盘录入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串（只包含字母和数字）：");
        String s = sc.nextLine();

        // 定义三个变量，分别统计大写字母、小写字母、数字出现的次数
        int upperCount = 0;
        int lowerCount = 0;
        int numberCount = 0;

        // 遍历字符串
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                lowerCount += 1;
            } else if(ch >= 'A' && ch <= 'Z') {
                upperCount += 1;
            } else {
                numberCount += 1;
            }
        }

        // 打印结果
        System.out.println("字符串 " + s + " 中大写字母：" + upperCount + "个");
        System.out.println("字符串 " + s + " 中小写字母：" + lowerCount + "个");
        System.out.println("字符串 " + s + " 中数字：" + numberCount + "个");
    }
}
