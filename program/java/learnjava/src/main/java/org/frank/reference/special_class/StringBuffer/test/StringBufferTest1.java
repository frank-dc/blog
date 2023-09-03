package org.frank.reference.special_class.StringBuffer.test;
/*
    将数组拼接成一个字符串
    1. 创建一个StringBuffer对象sb，遍历数组，调用append函数将数组元素追加到sb
    2. 将StringBuffer转换成String
 */
public class StringBufferTest1 {
    public static void main(String[] args) {
        int[] arr = { 11, 22, 33, 44, 55 };
        String s = arrayToString(arr);
        System.out.println(s);
    }

    public static String arrayToString(int[] arr) {
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + ", ");
            }
        }
        sb.append("]");
        return new String(sb);
    }
}
