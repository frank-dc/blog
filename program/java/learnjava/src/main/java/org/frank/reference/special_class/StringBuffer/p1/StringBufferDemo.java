package org.frank.reference.special_class.StringBuffer.p1;
/*
    StringBuffer: 线程安全的可变字符串。可以改变内容和长度。

    StringBuffer 和 String 的区别？
    1. StringBuffer的长度可变
    2. String的长度固定

    构造方法：
        1. StringBuffer(): 构造一个不带字符的字符缓冲区，其初始容量为16
        2. StringBuffer(int capacity): 构造一个不带字符的字符缓冲区，但指定初始容量
        3. StringBuffer(String str): 构造一个字符串缓冲区，长度为字符串长度，容量在其长度上加16

    成员方法：
        1. public synchronized int length()：返回长度实际值
        2. public synchronized int capacity(): 返回当前容量（理论值）

 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb);
        System.out.println(sb.length());    // 0
        System.out.println(sb.capacity());  // 16

        StringBuffer sb2 = new StringBuffer(20);
        System.out.println(sb2);
        System.out.println(sb2.length());       // 0
        System.out.println(sb2.capacity());     // 20

        StringBuffer sb3 = new StringBuffer("helloworld");
        System.out.println(sb3);            // helloworld
        System.out.println(sb3.length());   // 10
        System.out.println(sb3.capacity()); // 26
    }
}
