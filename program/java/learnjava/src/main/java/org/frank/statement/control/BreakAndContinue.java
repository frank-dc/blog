package org.frank.statement.control;

public class BreakAndContinue {
    public static void main(String[] args) {
        for(int x = 1; x <= 10; x++){
            if(x % 3 == 0) {
//                System.out.println("Java");   // <a>
//                break;                          // <b>
                continue;                     // <c>
            }
            System.out.println("Java");
        }

        //我想在控制台输出2次:“Java“       使用 break，<a> 和 <c> 注释掉
        //我想在控制台输出7次:“Java“       使用 continue，<a> 和 <b> 注释掉
        //我想在控制台输出13次:“Java“	    不使用 break 和 continue，即<b>和<c>注释掉
    }
}
