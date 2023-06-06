package org.frank.reference.array.two_dimensional;

import java.util.Arrays;

/*
    定义格式3：
        数据类型[][] 数组名 = new 数据类型[][]{{元素...}, {元素...}, ..., {元素...}};

    变形格式：
        数据类型[][] 数组名 = {{元素...}, {元素...}, ..., {元素...}};
 */
public class ArrayDemo3 {
    public static void main(String[] args) {
        // 定义一个二维数组
        int[][] arr = {{10, 11, 12}, {20, 21}, {30}};

        System.out.println(arr);    // [[I@56cbfb61
        System.out.println(Arrays.toString(arr));   // [[I@1134affc, [I@d041cf, [I@129a8472]
        System.out.println(arr[0]); // [I@1134affc
        System.out.println(Arrays.toString(arr[0]));    // [10, 11, 12]
        System.out.println(arr[1]); // [I@d041cf
        System.out.println(arr[2]); // [I@129a8472

        System.out.println(arr[0][0]);  // 10
        System.out.println(arr[0][1]);  // 11
        System.out.println(arr[1][1]);  // 21
        System.out.println(arr[2][0]);  // 30
    }
}
