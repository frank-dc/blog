package org.frank.reference.special_class.Arrays;

import java.util.Arrays;

/*
    把字符串中的字符进行排序
    举例："dcabgfe"
    结果："abcdefg"
 */
public class ArraysTest {
    public static void main(String[] args) {
        // 定义一个字符串
        String s = "dcabgfe";

        // 将字符串转换成数组
        char[] chs = s.toCharArray();
        System.out.println(Arrays.toString(chs));

        // 调用bubbleSort or selectSort排序
//        bubbleSort(chs);
        selectSort(chs);
        System.out.println(Arrays.toString(chs));

        // 将排序后的字符数组转换成字符串
        String ss = String.valueOf(chs);
        System.out.println(ss);

    }
    public static void bubbleSort(char[] chs) {
        for(int i = 0; i < chs.length - 1; i++){
            for(int j = 0; j < chs.length - i - 1; j++) {
                if(chs[j] > chs[j + 1]) {
                    char temp = chs[j];
                    chs[j] = chs[j + 1];
                    chs[j + 1] = temp;
                }
            }
        }
    }

    public static void selectSort(char[] chs) {
        for(int x = 0; x < chs.length - 1; x++) {
            for(int y = x + 1; y < chs.length - 1; y++) {
                if(chs[x] > chs[y]) {
                    char temp = chs[x];
                    chs[x] = chs[y];
                    chs[y] = temp;
                }
            }
        }
    }
}
