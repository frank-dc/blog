package org.frank.reference.lei_class.definition;
/*
    第一步：分析事物
        手机事物：
            属性：品牌，价格，颜色
            行为：打电话，发短信

    第二步：把事物转换成类
        手机类：
            成员变量：品牌，价格，颜色
            成员方法：打电话，发短信

    第三步：把类用英文体现
		Student:
			成员变量：sid，name，age
			成员方法：study()，eat()，sleep()

    第四步：写代码
        成员变量：其实就是一个变量，只不过定义在类中方法外，并且也可以不给初始值。
        成员方法：其实就是一个方法，只不过不需要static了。
 */
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
