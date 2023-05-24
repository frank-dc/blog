package org.frank.statement.switch_choose;
/*
    switch 语句注意事项：
        1. case 后面只能是常量，不能是变量，而且多个case后面的值不能出现相同的
        2. default 可以省略，但是不建议，除非判断的值是固定的
        3. break 可以省略，但是不建议，可能对结果产生影响（最后一个break省略是没有影响的）
        4. default 的位置可以随意（不在最后的话，需要加上break）
        5. switch 语句的结束条件
            a. 遇到 break
            b. 执行到程序的末尾
 */
public class SwitchDemo2 {
    public static void main(String[] args) {
        int week = 3;
        //int y = 4;

        switch(week) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println(5);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
			/*
			default:
				System.out.println(5);
				//break;
			*/
        }
    }
}
