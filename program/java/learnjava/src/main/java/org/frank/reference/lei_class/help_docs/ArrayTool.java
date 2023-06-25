package org.frank.reference.lei_class.help_docs;

/**
 * 这是针对数组进行操作的工具类
 * @author frank-dc
 * @version v1.0
 */

public class ArrayTool {
    /**
     * 这是私有构造方法
     */
    private ArrayTool() {}

    /**
     * 遍历数组，格式是：[元素1, 元素2, 元素3, ..., 元素n]
     * @param arr 需要被遍历的数组
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int x = 0; x < arr.length; x++) {
            if(x == arr.length -1) {
                System.out.print(arr[x]);
            } else {
                System.out.print(arr[x] + ", ");
            }
        }
        System.out.println("]");
    }

    /**
     * 获取数组中的最大值
     * @param arr 被获取最大值的数组
     * @return int 返回数组中的最大值
     */
    public static int getMax(int[] arr) {
        int max = arr[0];

        for(int item : arr) {
            if(max < item) {
                max = item;
            }
        }

        return max;
    }
}
