package org.frank.reference.array.one_dimensional
/*
    数组遍历：
        依次输出数组中的每一个元素
        
    分析：
        1. 定义一个数组，通过静态初始化方式赋值
        2. 输出数组元素
*/

public class ArrayTest {
    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = {11, 22, 33, 44, 55};
        
        // 方式一
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        
        // 方式二：可以观察出来数组有5个元素
        for(int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
        for(int item : arr) {
            // for-each 格式
            System.out.println(item);
        }
        
        // 方式三
        /*
            数组提供了一个长度属性：length
            用来获取数组的长度
            用法：数组名.length
        */
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
