package org.frank.method;
/*
    方法：完成特定功能的代码块

    格式：
        修饰符 返回值类型 方法名(参数类型 参数名1, 参数类型 参数名2...) {
            方法体;
            return 返回值;
        }

        修饰符：public static
        返回值类型：功能最值的值的数据类型
        方法名：是为了方便调用而起的一个名字
        参数：
            形式参数：用于接收实际参数的变量
            实际参数：实际参与运算的数据
        方法体：完成特定功能的代码
        return 返回值：通过return把结果返回给调用者

    如何写方法？两个明确：
        1. 返回值的类型
            结果的数据类型
        2. 参数列表
            有几个参数参加，并且每个参数的类型是什么

    方法的执行特点：
        不调用不执行

    有明确返回值的方法的调用：
        1. 单独调用，没有意义
        2. 输出调用，不是很好，因为我们可能需要针对结果进行其他的操作
        3. 赋值调用（推荐方式）
*/
public class MethodDemo {
    public static void main(String[] args) {
        // 定义两个变量
        int x = 11;
        int y = 22;

        // 单独调用
//        sum(x, y);

        // 输出调用
        System.out.println(sum(x, y));

        // 赋值调用
        int result = sum(x, y);
        // 对result进行操作
        System.out.println(result);
    }

    public static int sum(int a, int b) {
        // 写一个方法，求两个数之和
        int c = a + b;
        return c;
    }
}
