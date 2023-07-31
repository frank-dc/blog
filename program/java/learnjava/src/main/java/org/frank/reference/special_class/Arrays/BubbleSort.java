package org.frank.reference.special_class.Arrays;
/*
    冒泡排序：每次遍历（长度递减），相邻两个比较，最大的项排到最后。
    从后往前推移
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
        PrintArray.printArray(arr);
        bubbleSort(arr);
        PrintArray.printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        for(int x = 0; x < arr.length - 1; x++) {
            for(int y = 0; y < arr.length - 1 - x; y++) {
                if(arr[y] > arr[y + 1]) {
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                }
            }
        }
    }
}
