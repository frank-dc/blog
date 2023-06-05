package org.frank.reference.array.one_dimensional;
/*
    定义一个数组，输出数组名及其元素，然后给数组中的元素赋值，再次输出数组名及其元素。
 */
public class ArrayDemo2 {
    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = new int[3];

        // 输出数组名及其元素
        System.out.println(arr);    // [I@56cbfb61
        System.out.println(arr[0]); // 0
        System.out.println(arr[1]); // 0
        System.out.println(arr[2]); // 0

        // 给数组元素赋值
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        // 再次输出数组名及其元素
        System.out.println(arr);    // [I@56cbfb61
        System.out.println(arr[0]); // 10
        System.out.println(arr[1]); // 20
        System.out.println(arr[2]); // 30

        /*
        可以发现，赋值后，数组的内存地址值是不变的。
         */
    }
}
