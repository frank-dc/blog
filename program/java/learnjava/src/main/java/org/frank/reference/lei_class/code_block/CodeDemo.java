package org.frank.reference.lei_class.code_block;
/*
    代码块：在 Java 中，使用 {} 括起来的代码被称为代码块。

    根据其位置和声明的不同，可以分为：
        1. 局部代码块：在方法中出现
            限定变量生命周期，及早释放，提高内存利用率。
        2. 构造代码块：在类中方法外出现
            多个构造方法中相同的代码存放到一起，每次调用构造都执行，并且在构造方法前执行。
        3. 静态代码块：在类中方法外出现，加了 static 修饰
            用于给类进行初始化，在加载的时候就执行，并且只执行一次。

    执行过程：静态代码库 --> 构造代码块 --> 构造方法 --> 局部代码块

	静态代码块：只执行一次。
	构造代码库：每次创建对象都执行。
 */

/**
 * 局部代码块
 */
class Code {
    public void show() {
        // 局部代码块 start
        {
            int x = 10;
            System.out.println(x);
        }
        // 局部代码块 end
//        System.out.println(x);  // cannot resolve symbol `x`
        int y = 20;
        System.out.println(y);
    }
}

/**
 * 构造代码块
 */
class Code1 {
    // 构造代码块 start
    {
        System.out.println("构造代码块");
    }
    // 构造代码块 end

    public Code1() {
        System.out.println("11111");
    }

    public Code1(String s) {
        System.out.println(s);
    }
}

/**
 * 静态代码块
 */
class Code2 {
    // 静态代码块 start
    static {
        System.out.println("静态代码块");
    }
    // 静态代码块 end

    public Code2() {
        System.out.println("222222");
    }

    public Code2(String s) {
        System.out.println(s);
    }
}

public class CodeDemo {
    static {
        System.out.println("333333");
    }
    public static void main(String[] args) {
        Code c = new Code();
        c.show();

        Code1 c1 = new Code1();
        Code1 c11 = new Code1("Hello Code1");

        Code2 c2 = new Code2();
        Code2 c22 = new Code2("Hello Code2");
    }
}

/*
    333333
    10
    20
    构造代码块
    11111
    构造代码块
    Hello Code1
    静态代码块
    222222
    Hello Code2
 */
