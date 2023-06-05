package org.frank.reference.array.one_dimensional;
/*
    定义两个数组，先定义一个数组，赋值、输出
    再定第二个数组，将第一个数组的地址赋值给第二个数组
    给第二个数组元素赋值，最终输出两个数组名及其元素
 */
public class ArrayDemo4 {
    public static void main(String[] args) {
        // 定义第一个数组
        int[] arr1 = new int[2];

        // 赋值并输出
        arr1[0] = 10;
        arr1[1] = 20;
        System.out.println(arr1);       // [I@56cbfb61
        System.out.println(arr1[0]);    // 10
        System.out.println(arr1[1]);    // 20

        // 定义第二个数组，并将第一个数组地址值赋给它
        int[] arr2 = arr1;

        // 给第二个数组元素赋值
        arr2[1] = 200;

        // 输出两个数组名及其元素
        System.out.println(arr1);       // [I@56cbfb61
        System.out.println(arr1[0]);    // 10
        System.out.println(arr1[1]);    // 200

        System.out.println(arr2);       // [I@56cbfb61
        System.out.println(arr2[0]);    // 10
        System.out.println(arr2[1]);    // 200
        /*
        可以发现，两个数组的下标为 1 的元素值都变成了200，原因是当第二个数组地址赋值给第一个数组时，
        这两个数组其实都是引用的同一个内存地址（这两个数组其实是同一个）
         */
    }
}
