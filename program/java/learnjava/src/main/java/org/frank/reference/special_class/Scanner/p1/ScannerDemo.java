package org.frank.reference.special_class.Scanner.p1;
/*
    Scanner: JDK5以后，用于帮助我们实现键盘录入数据的。

    构造方法：
        public Scanner(InputStream source) {
            this(new InputStreamReader(source), WHITESPACE_PATTERN);
        }
 */
import java.io.InputStream;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // System 类下有这样的一个成员变量
        // public static final InputStream in = null;
        // InputStream is = System.in
    }
}
