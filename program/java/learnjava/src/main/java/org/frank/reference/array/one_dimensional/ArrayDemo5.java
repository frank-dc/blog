package org.frank.reference.array.one_dimensional;
/*
    静态初始化格式：
        数据类型[] 数组名 = new 数据类型[]{元素1, 元素2, ..., 元素n};

    简化格式：
        数据类型[] 数组名 = {元素1, 元素2, ..., 元素n};
 */
public class ArrayDemo5 {
    public static void main(String[] args) {
        // 定义一个数组（静态初始化）
//        int[] arr = new int[]{11, 22, 33};
        int[] arr = {11, 22, 33};

        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
