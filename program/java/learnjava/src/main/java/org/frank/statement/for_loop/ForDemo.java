package org.frank.statement.for_loop;
/*
    循环语句：
        初始化：做一些初始操作
        条件判断：让我们知道要循环多少次
        循环体：就是要做的事情
        控制条件变化：通过控制条件，让我们在合适的时候结束

    for 循环的格式：
        for(初始化语句;判断条件语句;控制条件语句) {
            循环体语句;
        }

    执行流程：
        1. 首先执行初始化语句
        2. 其次执行判断条件语句，看其返回值
            如果是 true，就继续
            如果是 false，就结束循环
        3. 执行循环体语句
        4. 执行控制条件语句
        5. 回到2
 */
public class ForDemo {
    public static void main(String[] args) {
        // 循环输出10次HelloWorld
        for(int x = 0; x < 10; x++) {
            System.out.println("#1 HelloWorld " + x);
        }

        // 其它实现方法
        for(int x = 1; x <= 10; x++) {
            System.out.println("#2 HelloWorld " + x);
        }

        for(int x = 1; x < 11; x++) {
            System.out.println("#3 HelloWorld " + x);
        }

        for(int x = 10; x > 0; x--) {
            System.out.println("#4 HelloWorld " + x);
        }
    }
}
