package org.frank.reference.special_class.StringBuffer.function;
/*
    String 和 StringBuffer 实现相互转换。
 */
public class StringBufferDemo2 {
    public static void main(String[] args) {
        // String -> StringBuffer
        String s = "hello";
        StringBuffer sb = new StringBuffer(s);

        // StringBuffer -> String
        String ss = new String(sb);
    }
}
