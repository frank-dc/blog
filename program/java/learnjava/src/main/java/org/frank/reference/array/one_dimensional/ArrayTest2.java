package org.frank.reference;
/*
    获取数组中的最小值和最大值
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = {11, 22, 33, 44, 55};
      
        // 调用 getMax 获取数组最大值
        int max = getMax(arr);
        // 在控制台输出 max
        System.out.println(max);
      
        // 调用 getMin 获取数组最小值
        int min = getMin(arr);
        // 在控制台输出 min
        System.out.println("arr 中的最小值是：" + min);
    }
    public static int getMax(int[] arr) {
        // 定义最大值的初始值
        int max = arr[0];

        for(int i = 0; i < arr.length; i++) {
            // 循环数组元素，并将其和 max 比较
            if(max < arr[i]) {
                // 较大值保存下来
                max = arr[i];
            }
        }
        // 返回 max
        return max;
    }

    public static int getMin(int[] arr) {
        // 定义最小值的初始值
        int min = arr[0];

        for(int i = 0; i < arr.length; i++) {
            // 循环数组元素，并将其和 min 比较
            if(min > arr[i]) {
                // 较小值保存下来
                min = arr[i];
            }
        }

        // 返回 min
        return min;
    }
}
