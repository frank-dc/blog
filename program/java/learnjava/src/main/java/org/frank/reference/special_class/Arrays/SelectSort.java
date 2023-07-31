package org.frank.reference.special_class.Arrays;
/*
    选择排序：每次遍历，将余下的项和最前面一个比较，最小的项排到最前面一个
    从前往后推移
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {24, 66, 80, 57, 13};
        PrintArray.printArray(arr);
        selectSort(arr);
        PrintArray.printArray(arr);
    }

    public static void selectSort(int[] arr) {
        for(int x = 0; x < arr.length - 1; x++) {
            for(int y = x + 1; y < arr.length; y++) {
                if(arr[y] < arr[x]) {
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
    }
}
