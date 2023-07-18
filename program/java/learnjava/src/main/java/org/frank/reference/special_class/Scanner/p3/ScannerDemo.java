package org.frank.reference.special_class.Scanner.p3;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int -- int
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        System.out.println("#####\n" + x + "\n" + y + "\n#####");

        // string -- string
//        String a = sc.nextLine();
//        String b = sc.nextLine();
//        System.out.println("#####\n" + a + "\n" + b + "\n#####");

        // string -- int
//        String m = sc.nextLine();
//        int n = sc.nextInt();
//        System.out.println("#####\n" + m + "\n" + n + "\n#####");

        // int -- string    有问题，把回车换行给了String
        int i = sc.nextInt();
//        String j = sc.nextLine();
//        System.out.println("#####\n" + i + "\n" + j + "\n#####");

        // 解决方法：
        // 1. 重新创建一个新的键盘录入对象。
        // 2. 把键盘所有录入数据全部当做String类型接收。
        sc = new Scanner(System.in);
        String j = sc.nextLine();
        System.out.println("#####\n" + i + "\n" + j + "\n#####");
    }
}
