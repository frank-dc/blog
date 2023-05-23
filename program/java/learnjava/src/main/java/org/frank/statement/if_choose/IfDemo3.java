package org.frank.statement.if_choose;
/*
    if 语句格式2：
        if(关系表达式) {
            语句体1;
        }else {
            语句体2;
        }

    执行流程：
        1. 计算关系表达式，看其结果
        2. 如果是 true，就执行语句体1；如果是 false，就执行语句体2
        3. 继续向下执行
 */

public class IfDemo3 {
    public static void main(String[] args) {
        int x = 3;
        if(x == 3) {
            System.out.println("x等于3");
        }else {
            System.out.println("x不等于3");
        }

        if(x > 5) {
            System.out.println("x大于5");
        }else {
            System.out.println("x不大于5");
        }
    }
}
