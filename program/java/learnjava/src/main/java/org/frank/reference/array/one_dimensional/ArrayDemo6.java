package org.frank.reference.array.one_dimensional;
/*
    数组操作常见的两个问题：
        1. 数组索引越界
            ArrayIndexOutOfBoundsException
            因为我们访问了不存在的索引
        2. 空指针异常
            NullPointerException
            因为数组已经不再指向堆内存，所以就不能再去访问堆内存的元素了
 */
public class ArrayDemo6 {
    public static void main(String[] args) {
        // 定义数组
        int[] arr = {11, 22, 33};

        // 数组索引越界
//        System.out.println(arr[3]);

        // 空指针异常
        arr = null;
        System.out.println(arr[0]);
    }
}
