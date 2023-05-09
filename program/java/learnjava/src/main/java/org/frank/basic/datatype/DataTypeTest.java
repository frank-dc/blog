package org.frank.basic.datatype;

public class DataTypeTest {
    public static void main(String[] args){
        byte b1=3, b2=4, b;
//        b = b1 + b2;  Java在对 byte 和 short 类型进行运算时会将它们自动提升为 int 类型，因此
//                      `b1 + b2`的结果是一个 int 类型的值。由于 int 类型的值不能直接赋给 byte
//                      类型的变量，所以这一行代码会报编译错误。
        b = (byte)(b1 + b2);   // 如果想将 int 类型的值赋给 byte 类的变量，需要使用强制类型转换。
//                                或者将`b`的类型改为 int。
        b = 3 + 4;  // 将字面量值赋给`b`是可行的，因为 7 在 byte 类型范围内(-128 ~ 127)，可以用 byte 类型表示。
        System.out.println(b);
    }
}
