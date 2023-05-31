package org.frank.statement.control;
/*
    break 的用法就是：中断
        1. 跳出单层循环
        2. 跳出多层循环（带标签的用法）

    break 的使用场景
        1. 在 switch 选择结构语句中
        2. 在循环语句中
    离开使用场景的存在是没有意义的
 */
public class BreakDemo {
    public static void main(String[] args) {
        /*
        for(int x = 0; x < 10; x++) {
            if(x % 2 == 0) {
                System.out.println(x);
                break;
            }
        }
         */

        wc:for(int x = 0; x < 3; x++) {
            nc:for(int y = 0; y < 4; y++) {
                System.out.print("*");
                break nc;
            }
            System.out.println();
            break wc;
        }
    }
}
