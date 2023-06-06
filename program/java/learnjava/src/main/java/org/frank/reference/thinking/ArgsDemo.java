package org.frank.reference.thinking;
/*
    基本类型和引用类型参数的传递问题
        基本类型：形式参数的改变对实际参数没有影响。
        引用类型：形式参数的改变直接影响实际参数。是因为形式参数接收的是实际参数的地址值。

    Java 中有没有引用传递？
        只有值传递，引用类型的地址值也是一个值。
 */

import java.util.Arrays;

public class ArgsDemo {
    public static void main(String[] args) {
        // 基本类型作为形式参数和实际参数
        int a = 10;
        int b = 20;
        System.out.println("实际参数：a = " + a + "\tb = " + b);  // a = 10	b = 20
        change(a, b);
        System.out.println("实际参数：a = " + a + "\tb = " + b);  // a = 10	b = 20
        System.out.println("基本类型：调用方法 change，形式参数被改变，但是实际参数不受影响。");

        System.out.println();
        // 引用类型作为形式参数和实际参数
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("实际参数 arr = " + Arrays.toString(arr));
        change(arr);
        System.out.println("实际参数 arr = " + Arrays.toString(arr));
        System.out.println("引用类型：调用方法 change，形式参数被改变，实际参数也相应改变。");
    }

    public static void change(int a, int b) {   // a = 10	b = 20
        System.out.println("改变前的形式参数：a = " + a + "\tb = " + b);  // a = 10	b = 20
        a = b;  // a = 20   改变形式参数 a
        b = a + b;  // b = 40   改变形式参数 b
        System.out.println("改变后的形式参数：a = " + a + "\tb = " + b);  // a = 20	b = 40
    }

    public static void change(int[] arr) {  // arr = {1, 2, 3, 4, 5}
        System.out.println("改变前的形式参数：arr = " + Arrays.toString(arr));
        for(int x = 0; x < arr.length; x++) {
            // 如果数组元素是偶数，则数组元素的值变为之前的两倍
            if(arr[x] % 2 == 0) {
                arr[x] *= 2;
            }
        }
        System.out.println("改变后的形式参数：arr = " + Arrays.toString(arr));
    }
}
