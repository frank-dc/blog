package org.frank.reference.thinking;
/*
    成员变量和局部变量的区别：
        1. 在类中的位置不同
            成员变量：类中方法外
            局部变量：方法内或方法声明上
        2. 在内存中的位置不同
            成员变量：堆内存（由用户手动管理）
            局部变量：栈内存（由系统自动管理）
        3. 生命周期不同
            成员变量：随着对象的存在而存在，随着对象的消失而消失
            局部变量：随着方法的调用而存在，随着方法的调用完毕而消失
        4. 初始化值不同
            成员变量：有默认的初始值
            局部变量：没有默认的初始值，必须先赋值才能使用
    注意：
        如果有同名的变量，一般会采用就近原则。
 */
public class VariableDemo {
    // 成员变量
    int x;
    public static void main(String[] args) {
        // 局部变量
//        int y;
//        System.out.println(x);  // java: 无法从静态上下文中引用非静态 变量 x，除非使用static修饰
//        System.out.println(y);  // java: 可能尚未初始化变量y
        VariableDemo vd = new VariableDemo();
        System.out.println(vd.x);   // 0
    }
}
