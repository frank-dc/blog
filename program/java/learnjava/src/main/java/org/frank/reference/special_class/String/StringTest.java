package org.frank.reference.special_class.String;
/*
    需求：统计字符串中子字符串出现的次数。
    举例：在字符串"woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun"中java出现了5次
 */
public class StringTest {
    public static void main(String[] args) {
        String originString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String subString = "java";

        int count = getCount(originString, subString);
        System.out.println(subString + "出现了：" + count + "次");
    }

    public static int getCount(String originString, String subString) {
        // 定义统计变量
        int count = 0;

        // 调用indexOf()方法，查找子字符串第一次出现的索引
        int firstIndex = originString.indexOf(subString);

        // 定义一个变量，用于记录每次最新的查找位置
        int startIndex = 0;

        // 如果firstIndex是-1，说明子字符串不存在
        while(firstIndex != -1) {
            // 统计变量加1
            count++;
            // 计算最新的查找位置
            startIndex = firstIndex + subString.length();
            // 从最新的位置开始，再查一次subString在originString中出现的位置
            firstIndex = originString.indexOf(subString, startIndex);
        }

        return count;
    }
}
