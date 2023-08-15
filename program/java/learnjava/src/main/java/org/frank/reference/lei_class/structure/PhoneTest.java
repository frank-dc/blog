package org.frank.reference.lei_class.structure;


class Phone {
    private String brand;
    private int price;
    private String color;

    public Phone() {}

    public Phone(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void show() {
        System.out.println("我的手机品牌是：" + brand + "\t价格是：" + price + "\t颜色是：" + color);
    }
}

public class PhoneTest {
    public static void main(String[] args) {
        // 无参创建 Phone 对象，通过 setXxx 设置成员变量
        Phone p1 = new Phone();
        p1.setBrand("OPPO");
        p1.setPrice(2800);
        p1.setColor("白色");
        p1.show();

        // 带参创建 Phone 对象
        Phone p2 = new Phone("iPhone", 9800, "黑色");
        p2.show();
    }
}
