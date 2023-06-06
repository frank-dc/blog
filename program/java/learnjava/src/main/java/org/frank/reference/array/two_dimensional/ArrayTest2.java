package org.frank.reference.array.two_dimensional;
/*
    公司年销售额求和
        某公司按照季度和月份统计的数据如下：单位（万元）
        第一个季度：22,66,44
        第二个季度：77,33,88
        第三个季度：25,55,65
        第四个季度：55,66,77

    分析：
        1. 通过观察，需要定义一个二维数组
        2. 定义求和变量
        3. 遍历二维数组，获取每一个元素，然后累加
        4. 输出结果
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        // 定义一个二维数组
        int[][] arr = {{22, 66, 44}, {77, 33, 88}, {25, 55, 65}, {55, 66, 77}};

        // 定义求和变量
        int sum = 0;

        // 遍历二维数组
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr[x].length; y++) {
                sum += arr[x][y];
            }
        }

        // 输出结果
        System.out.println(sum);
    }
}
