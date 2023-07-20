package org.frank.reference.special_class.String.p3;

import java.util.Scanner;

/*
    需求：模拟登录，给三次机会，用户密码错误则提示还剩几次。

    分析：
        1. 给出固定的用户和密码
        2. 键盘录入用户和密码
        3. 分别比较用户和密码
        4. 给出三次机会
 */
public class StringTest {
    public static void main(String[] args) {
        // 固定的用户名和密码
        final String inner_username = "admin";
        final String inner_password = "admin123";

        for(int i = 0; i < 3; i++) {
            // 用户键入用户名和密码
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String username = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();

            if(inner_username.equals(username) && inner_password.equals(password)) {
                System.out.println("登录成功！");
                break;
            } else {
                if (i == 2) {
                    System.out.println("账号被锁定，请联系管理员。");
                } else {
                    System.out.println("登录失败，请重新输入，还剩 " + (2 - i) +" 次机会。");
                }
            }

        }
    }
}
