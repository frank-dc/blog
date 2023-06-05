package org.frank.reference.array.one_dimensional;
/*
    定义两个数组，分别输出数组名及其元素。然后分别给两个数组的元素赋值，再次分别输出数组名及其元素。
 */
public class ArrayDemo3 {
    public static void main(String[] args) {
        // 定义第一个数组
        int[] arr1 = new int[2];

        // 输出数组名及其元素
        System.out.println(arr1);       //[I@56cbfb61
        System.out.println(arr1[0]);    // 0
        System.out.println(arr1[1]);    // 0

        // 赋值并输出
        arr1[0] = 10;
        arr1[1] = 20;
        System.out.println(arr1);       // [I@56cbfb61
        System.out.println(arr1[0]);    // 10
        System.out.println(arr1[1]);    // 20

        // 定义第二个数组
        int[] arr2 = new int[2];

        // 输出数组名及其元素
        System.out.println(arr2);       // [I@1134affc
        System.out.println(arr2[0]);    // 0
        System.out.println(arr2[1]);    // 0

        // 赋值并输出
        arr2[0] = 100;
        arr2[1] = 200;
        System.out.println(arr2);       // [I@1134affc
        System.out.println(arr2[0]);    // 100
        System.out.println(arr2[1]);    // 200

        /*
        可以发现，每次新定义一个数组，会重新分配一个内存地址。
         */
    }
}
