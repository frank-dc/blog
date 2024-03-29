package org.frank.basic.logic;
/*
    &,|,!,^

    可以参考comparison/OperatorDemo2
 */

public class OperatorDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        System.out.println("&: 逻辑与   有false则false");
        System.out.println(a > b & a > c);  // false & false = false
        System.out.println(a > b & a < c);  // false & true = false
        System.out.println(a < b & a > c);  // true & false = false
        System.out.println(a < b & a < c);  // true & true = true

        System.out.println("|: 逻辑或   有true则true");
        System.out.println(a > b | a > c);  // false | false = false
        System.out.println(a > b | a < c);  // false | true = true
        System.out.println(a < b | a > c);  // true | false = true
        System.out.println(a < b | a < c);  // true | true = true

        // 情侣：男男，男女，女女，女男
        System.out.println("^: 逻辑异或  相同则false，不同则true");
        System.out.println(a > b ^ a > c);  // false ^ false = false
        System.out.println(a > b ^ a < c);  // false ^ true = true
        System.out.println(a < b ^ a > c ); // true ^ false = true
        System.out.println(a < b ^ a < c);  // true ^ true = false

        System.out.println("!: 逻辑非  取反");
        System.out.println((a > b));    // false
        System.out.println(!(a > b));   // true
        System.out.println(!!(a > b));  // false
        System.out.println(!!!(a > b)); // true
    }
}
