package org.frank.reference.special_class.Integer;
/*
    byte范围的缓存池

    -128 ~ 127 是从一个缓存数组中返回的，所以不会创建新的对象（即分配新的内存地址）

    另外，`==`比较的是对象是否相同（即内存地址是否一样），`equals`方法只是比较值是否相等。

    附上Integer.valueOf源码
    ```
    public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
    ```
 */
public class Test2 {
    public static void main(String[] args) {
        Integer i1 = new Integer(127);
//        Integer i1 = Integer.valueOf(127);
        Integer i2 = new Integer(127);
//        Integer i2 = Integer.valueOf(127);
        System.out.println(i1 == i2);   // false
        System.out.println(i1.equals(i2));  // true

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);   // false
        System.out.println(i3.equals(i4));  // true

        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);   // true
        System.out.println(i5.equals(i6));  // true

        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);   // false
        System.out.println(i7.equals(i8));  // true


    }
}
