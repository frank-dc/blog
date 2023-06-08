package org.frank.reference.lei_class.multi_files;

public class Phone {
    // 品牌变量
    String brand;

    // 价格变量
    int price;

    // 颜色变量
    String color;

    // 打电话的方法
    public void call(String name) {
        System.out.println("给" + name + "打电话");
    }

    // 发短信的方法
    public void sendMessage() {
        System.out.println("群发短信");
    }
}
