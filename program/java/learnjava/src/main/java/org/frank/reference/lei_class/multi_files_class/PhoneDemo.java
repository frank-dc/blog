package org.frank.reference.lei_class.multi_files_class;

public class PhoneDemo {
    public static void main(String[] args) {
        // 创建手机对象
        Phone p = new Phone();

        // 输出成员变量
        System.out.println("初始品牌是：" + p.brand); // null
        System.out.println("初始价格是：" + p.price); // 0
        System.out.println("初始颜色是：" + p.color); // null

        // 给成员变量赋值
        p.brand = "三星";
        p.price = 2999;
        p.color = "蓝色";

        // 再次输出成员变量
        System.out.println("品牌是：" + p.brand); // 三星
        System.out.println("价格是：" + p.price); // 2999
        System.out.println("颜色是：" + p.color); // 蓝色

        // 调用成员方法
        p.call("王祖贤");
        p.sendMessage();
    }
}
