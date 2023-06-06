package org.frank.reference.array.one_dimensional;
/*
    数组元素反转（就是把数组元素对调）

    分析：
        1. 把第一个和最后一个交换
	    2. 把第二个和倒数第二个交换
	       ...
 */
public class ArrayTest3 {
    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = {11, 22, 33, 44, 55};

        // 调用方法 printArray 打印数组
        printArray(arr);

        // 调用方法 reverse 反转数组元素
        int[] new_arr = reverse(arr);

        // 调用方法 printArray 打印数组
        printArray(new_arr);

    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public static int[] reverse(int[] arr) {
        for(int start = 0, end = arr.length - 1; start <= end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        return arr;
    }
}
