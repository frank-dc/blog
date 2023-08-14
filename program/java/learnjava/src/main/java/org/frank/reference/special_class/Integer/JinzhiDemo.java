package org.frank.reference.special_class.Integer;

/*

常用的基本进制转换
		public static String toBinaryString(int i)
		public static String toOctalString(int i)
		public static String toHexString(int i)

十进制到其他进制
		public static String toString(int i,int radix)

其他进制到十进制
		public static int parseInt(String s,int radix)

 */
public class JinzhiDemo {
    public static void main(String[] args) {
        // 十进制转其它进制，通过以下测试，进制的范围是2 ~ 36，详情见 Character.MIN_RADIX，Character.MAX_RADIX
        System.out.println(Integer.toString(100, 2));   // 1100100
        System.out.println(Integer.toString(100, 8));   // 144
        System.out.println(Integer.toString(100, 16));  // 64
        System.out.println(Integer.toString(100, 1));   // 100
        System.out.println(Integer.toString(100, 100)); // 100
        System.out.println(Integer.toString(100, 50));  // 100
        System.out.println(Integer.toString(100, 25));  // 40
        System.out.println(Integer.toString(100, 37));  // 100
        System.out.println(Integer.toString(100, 31));  // 37
        System.out.println(Integer.toString(100, 34));  // 2w
        System.out.println(Integer.toString(100, 35));  // 2u
        System.out.println(Integer.toString(100, 36));  // 2s

        // 其它进制转十进制
        System.out.println(Integer.parseInt("100", 2)); // 4
        System.out.println(Integer.parseInt("100", 8)); // 64
        System.out.println(Integer.parseInt("100", 16));    // 256
        System.out.println(Integer.parseInt("100", 36));    // 1296

        // 十进制转二进制、八进制、十六进制
        System.out.println(Integer.toBinaryString(100));    // 1100100
        System.out.println(Integer.toOctalString(100));     // 144
        System.out.println(Integer.toHexString(100));       // 64
    }
}
