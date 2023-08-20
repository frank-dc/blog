package org.frank.reference.special_class.Integer;
/*
    int 和 String 类型的相互转换

    int -> String
        String.valueOf(number)
        Integer.toString(number)

    String -> int
        Integer.parseInt(s);
 */
public class Demo1 {
    public static void main(String[] args) {
        int number = 100;
        // int -> String
        String s1 = number + "";
        System.out.println(s1);

        String s2 = String.valueOf(number);
        System.out.println(s2);

        // int -> Integer -> String
        Integer i = new Integer(number);
        String s3 = i.toString();
        System.out.println(s3);

        String s4 = Integer.toString(number);
        System.out.println(s4);

        // String -> int
        String s = "100";

        // String -> Integer -> int
        Integer ii = new Integer(s);
        int num = ii.intValue();
        System.out.println(num);

        int num2 = Integer.parseInt(s);
        System.out.println(num2);
    }
}
