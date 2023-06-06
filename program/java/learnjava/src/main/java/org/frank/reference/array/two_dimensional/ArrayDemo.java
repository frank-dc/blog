package org.frank.reference.array.two_dimensional;
/*
    二维数组：元素是一位数组的数组。

    定义格式1：
        数据类型[][] 数组名 = new 数据类型[m][n];

        m: 表示这个二维数组有多少个元素（一维数组），即二维数组的长度
        n: 表示这个二维数组中每一个一维数组元素个数

    变形格式：
        数据类型 数组名[][] = new 数据类型[m][n];
        数据类型[] 数组名[] = new 数据类型[m][n];
 */
public class ArrayDemo {
    public static void main(String[] args) {
        // 定义一个二维数组
        int[][] arr = new int[3][2];
        /*
            二维数组 arr 有 3 个一维数组
            每个一维数组有 2 个元素
         */

        System.out.println(arr);    // [[I@56cbfb61
        System.out.println(arr[0]); // [I@1134affc
        System.out.println(arr[1]); // [I@d041cf
        System.out.println(arr[2]); // [I@129a8472

        System.out.println(arr[0][1]);  // 0
        System.out.println(arr[2][1]);  // 0
    }
}
