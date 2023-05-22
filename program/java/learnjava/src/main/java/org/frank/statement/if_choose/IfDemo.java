package org.frank.statement.if_choose;
/*
    选择结构：
        1. if语句
        2. switch语句

    if 语句格式1
        if(关系表达式) {
            语句体;
        }

    执行流程：
        1. 计算关系表达式，看其结果
        2. 如果是 true，就执行语句体；如果是 false 就不执行语句体
        3. 继续向下执行
 */

public class IfDemo {
    public static void main(String[] args) {
        int x = 3;

        if(x == 3) {
            System.out.println("x等于3");
        }

        if(x > 5) {
            System.out.println("x大于5");
        }

        System.out.println("over");
    }
}
