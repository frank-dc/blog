package org.frank.reference.array.two_dimensional;
/*
    二维数组遍历
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 定义一个二维数组
        int[][] arr = {{10, 11, 12}, {20, 21}, {30}};

        // 遍历
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr[x].length; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }
}
