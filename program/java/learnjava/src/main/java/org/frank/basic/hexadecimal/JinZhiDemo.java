package org.frank.basic.hexadecimal;
/*
    二进制（binary）
        由0,1组成，以 0b 开头。
    八进制（octal）
        由0,1,...7组成，以 0 开头。
    十进制（decimal/integer）
        由0,1,...9组成，整数默认是十进制。
    十六进制（hexadecimal)
        由0,1,...9,A,B,C,D,E,F（大小写均可），以0x开头。

*/
public class JinZhiDemo {
    public static void main(String[] args) {
        System.out.println(0b1000); // 8
        System.out.println(01000);  // 512
        System.out.println(1000);   // 1000
        System.out.println(0x1000); // 4096
    }
}
