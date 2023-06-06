package org.frank.reference.array.one_dimensional;
/*
    给定数组元素，返回其索引。
 */
public class ArrayTest5 {
    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};

        // 调用方法 getIndex
        int index = getIndex(arr, 55);
        System.out.println("55 在数组中的索引是： " + index);
    }

    public static int getIndex(int[] arr, int key) {
        // 初始化 index = -1
        int index = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                // 找到数组元素为 key 时，将索引赋值给 index
                index = i;
                break;
            }
        }

        return index;
    }
}
