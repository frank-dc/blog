package org.frank.reference.special_class.Arrays.find;

import java.util.Arrays;

/*
    基本查找：适应于数组元素无序
    二分查找：适应于数组元素有序
 */
public class FindDemo {
    public static void main(String[] args) {
        int[] orderedArr = {13, 24, 57, 69, 80};
        int[] disorderedArr = {57, 13, 69, 80, 24};
//        int index = Arrays.binarySearch(arr, 13);
        int index = binarySearch(orderedArr, 80);
        System.out.println(index);

        index = basicSearch(disorderedArr, 80);
        System.out.println(index);
    }

    /*
        Arrays.binarySearch() 的实现
        二分查找
     */
    public static int binarySearch(int[] arr, int targetValue) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if(midVal < targetValue) {
                low = mid + 1;
            } else if(midVal > targetValue) {
                high = mid - 1;
            } else {
                return mid;  // targetValue found
            }
        }

        return -(low + 1);  // targetValue not found
    }

    /*
        基本查找
     */
    public static int basicSearch(int[] arr, int targetValue) {
        // 初始化目标索引，找不到则返回-1
        int targetIndex = -1;

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == targetValue) {
                targetIndex = i;
                break;
            }
        }

        return targetIndex;
    }
}
