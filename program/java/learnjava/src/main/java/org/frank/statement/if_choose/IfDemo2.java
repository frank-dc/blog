package org.frank.statement.if_choose;
/*
    if 语句注意事项：
        1. 关系表达式无论简单还是复杂，结果必须是boolean类型
        2. 在做判断的时候，建议常量放左边。
		3. if语句控制的语句体如果是一条语句，大括号可以省略；
		   如果是多条语句，就不能省略。建议永远不要省略
		4. 一般来说：有左大括号就没有分号，有分号就没有左大括号

 */

public class IfDemo2 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int z = 30;

        if(x > y) {
            System.out.println("x大于y");
        }
//        if(30) {
//            System.out.println("关系表达式必须是boolean类型");
//        }
        if(true) {
            System.out.println("关系表达式必须是boolean类型");
        }

        if(x < y && x < z) {
            System.out.println("x小于y且x小于z");
        }

        boolean flag = false;
        if(flag == true) {
            System.out.println("flag is true");
        }

        if(flag == false) {
            System.out.println("flag is false");
        }

        if(flag = true) {
            System.out.println("这会执行的");
        }

//        if(true = flag) {
//            System.out.println("这会报错");
//        }

        System.out.println("以下验证注意事项4");
        if(false) {
            System.out.println("aaa");
            System.out.println("bbb");
        }

        if(false);

        //代码块
        {
            System.out.println("111");
            System.out.println("222");
        }
        System.out.println("over");
    }
}
