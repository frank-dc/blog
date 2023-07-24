package org.frank.reference.special_class.String.P6;
/*
    String类的替换功能
        public String replace(CharSequence target, CharSequence replacement): 替换字符串中的字符串
        public String replace(char oldChar, char newChar): 替换字符串中的字符
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "helloworld";

        String ns = s.replace("llo", "LLO");
        System.out.println("s = " + s);
        System.out.println("ns = " + ns);

        String ns2 = s.replace('o', 'O');
        System.out.println("s = " + s);
        System.out.println("ns2 = " + ns2);
    }
}
