package org.frank.reference.lei_class.final_keyword;
/*
    final 的初始化时机：
        1. 在定义的时候立即给值，以后再也不能改了。
        2. 在定义后，构造方法结束前赋值都可以。(没明白)
 */

class Demo {
    int num;
    final int num2 = 1;


//    static {
//        num2 = 10;  // Non-static field 'num2' cannot be referenced from a static context
//    }


    public Demo() {
//        num2 = 20;
    }

}

public class FinalDemo3 {
    public static void main(String[] args) {
        Demo d = new Demo();
        System.out.println(d.num);
        System.out.println(d.num2);
    }
}
