package org.frank.method;
/*
    没有明确返回值的方法调用：void 修饰的方法
        单独调用
 */
public class MethodDemo3 {
    public static void main(String[] args) {
        // 单独调用
        // 在控制台输出一个3行5列的星型
        printStar(3, 5);

        // 在控制台输出一个7行8列的星型
        printStar(7, 8);

        // 输出调用（Cannot resolve method 'println(void)'）
//        System.out.println(printStar(7,8));

        // 赋值调用（Illegal type: 'void'）
//        void v = printStar(1, 2);
//        System.out.println(v);
    }

    public static void printStar(int a, int b) {
        // 打印 a 行 b 列 "*"
        for(int x = 0; x < a; x++) {
            for(int y = 0; y < b; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
