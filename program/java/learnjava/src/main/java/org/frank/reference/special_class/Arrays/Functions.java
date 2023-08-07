package org.frank.reference.special_class.Arrays;
/*
    java.util.Arrays: 针对数组进行操作的工具类，提供了排序、查找的功能。

    成员方法：
        public static String toString(int[] a): 把数组转换成字符串
        public static void sort(int[] a): 排序（快速排序）
        public static int binarySearch(int[] a, int key): 二分查找

    注意：
        如果数组本身是无序的，不能直接使用二分查找。
        并且，先排序，再二分也是有问题的，因为排序后就改变了数组中元素原始的索引位置。
 */
import java.util.Arrays;

public class Functions {
    public static void main(String[] args) {
        int[] arr = {24, 13, 69, 80, 57};

        System.out.println(Arrays.toString(arr));   // [24, 13, 69, 80, 57]

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));   // [13, 24, 57, 69, 80]

        System.out.println(Arrays.binarySearch(arr, 80));   // 4
        System.out.println(Arrays.binarySearch(arr, 100));  // -6
    }
}
