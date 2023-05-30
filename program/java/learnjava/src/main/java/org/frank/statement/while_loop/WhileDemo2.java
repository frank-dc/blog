package org.frank.statement.while_loop;
/*
    for 和 while 的区别：
    使用区别：控制条件语句所控制的那个变量，在 for 循环结束后，就不能再访问到了，因为 for 循环结束，
            该变量就从内存中消失，提高内存使用效率；但是 while 循环该变量仍然存在。

    场景区别：
            for 循环适合针对一个范围进行操作，比如`水仙花数`
          while 循环适合判断次数不明确操作，比如`吃葡萄`
 */
public class WhileDemo2 {
    public static void main(String[] args) {
        for(int x = 0; x < 10; x++) {
            System.out.println("x = " + x);
        }
//        System.out.println(x);

        int y = 0;
        while (y < 10) {
            System.out.println("y = " + y);
            y++;
        }
        System.out.println(y);

    }
}
