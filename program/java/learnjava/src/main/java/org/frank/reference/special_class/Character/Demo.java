package org.frank.reference.special_class.Character;
/*
    Character 类在对象中包装一个基本类型 char 的值，
    此外，该类提供了几种方法，以确定字符的类别（小写字母，数字等等），
    并将字符从大写转换成小写，反之亦然。
 */
public class Demo {
    public static void main(String[] args) {
        Character c = new Character('a');
        System.out.println(c);

        System.out.println(Character.isUpperCase(97));  // 'a'  false
        System.out.println(Character.isUpperCase('A'));     // true
        System.out.println(Character.isUpperCase('0'));     // false

        System.out.println(Character.isLowerCase('a'));     // true
        System.out.println(Character.isLowerCase(65));  // 'A'  false
        System.out.println(Character.isLowerCase('0'));     // false

        System.out.println(Character.isDigit('a')); // false
        System.out.println(Character.isDigit('A')); // false
        System.out.println(Character.isDigit('0')); // true

        System.out.println(Character.toUpperCase('a'));      // A
        System.out.println(Character.toUpperCase(97));  // 65
        System.out.println(Character.toUpperCase('0'));      // 0

        System.out.println(Character.toLowerCase('a'));     // a
        System.out.println(Character.toLowerCase(65));  // 97
        System.out.println(Character.toLowerCase('0'));     // 0
    }
}
