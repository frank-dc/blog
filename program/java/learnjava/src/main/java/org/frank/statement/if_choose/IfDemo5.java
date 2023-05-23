package org.frank.statement.if_choose;

import java.util.Scanner;

/*
    if语句格式3：
		if(关系表达式1) {
		    语句体1;
		}else if(关系表达式2) {
			语句体2;
		}else if(关系表达式n) {
		    语句体n;
		}else {
			语句体n+1;
		}

	执行流程：
		1. 首先判断关系表达式1看其结果是 true 还是 false
		2. 如果是 true，就执行语句体1
		3. 如果是 false，就继续判断关系表达式2看其结果是 true 还是 false
		4. 如果是 true，就执行语句体2
		5. 如果是 false，就继续判断关系表达式n看其结果是 true 还是 false
		6. 如果是 true，就执行语句体n
		7. 如果是 false（即所有关系表达式都是false），就执行语句体n+1

	需求：
		键盘录入学生成绩，根据成绩输出对于的评价。
			90-100	优秀
			80-90	好
			70-80	良
			60-70	及格
			60以下	不及格
 */
public class IfDemo5 {
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        // 录入学生成绩
        System.out.println("请输入成绩：");
        int score = sc.nextInt();

        // 校验数据的时候，一定需要注意
        // 正确数据
        // 错误数据
        // 边界数据
        if(score < 0 || score > 100) {
            System.out.println("输入的成绩有误");
        }else if(score >= 90 && score <= 100) {
            System.out.println("优秀");
        }else if(score >=80 && score < 90) {
            System.out.println("好");
        }else if(score >= 70 && score < 80) {
            System.out.println("良");
        }else if(score >=60 && score < 70) {
            System.out.println("及格");
        }else {
            System.out.println("不及格");
        }
    }
}
