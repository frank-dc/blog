package org.frank.reference.array.two_dimensional;
/*
    定义格式2：
        数据类型[][] 数组名 = new 数据类型[m][];

        m: 表示这个二维数组有多少个一维数组
 */
public class ArrayDemo2 {
    public static void main(String[] args) {
        // 定义一个二维数组
        int[][] arr = new int[3][];
        /*
            这里我们仅仅知道这个二维数组有多少个一维数组
            但是我们不知道每个一维数组有多少个元素
         */

        System.out.println(arr.toString());    // [[I@56cbfb61
        System.out.println(arr[0]); // null
        System.out.println(arr[1]); // null
        System.out.println(arr[2]); // null

        // arr[0][0] = 100; // 报错 NullPointerException
        // System.out.println(arr[0][0]);

        arr[0] = new int[3];    // 初始化第一个一维数组，长度为3
        arr[1] = new int[1];    // 初始化第二个一维数组，长度为1
        arr[2] = new int[2];    // 初始化第三个一维数组，长度为2
        System.out.println(arr[0]); // [I@1134affc
        System.out.println(arr[1]); // [I@d041cf
        System.out.println(arr[2]); // [I@129a8472

        arr[0][1] = 100;
        arr[2][0] = 200;
        System.out.println(arr[0][1]);
        System.out.println(arr[2][0]);
    }
}
