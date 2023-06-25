package org.frank.reference.lei_class.help_docs;
/*
    制作一个说明书的过程：
        1. 写代码
        2. 加入文档注释
        3. 通过javadoc工具生成说明书
            `javadoc -d 输出文件的目标目录 -author -version ArrayTool.java
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55};

        ArrayTool.printArray(arr);

        int max = ArrayTool.getMax(arr);
        System.out.println(max);
    }
}
