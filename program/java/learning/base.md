# 基础

## java 程序基本结构
以 [Hello.java](../src/Hello.java) 为例，
```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```
`public`、`class`、`static`都是关键字。

* java 是面向对象的编程语言，用`class`关键字定义类名`Hello`。

* `public`关键字是访问修饰符，表示该`class`是公开的。

* 在`class`内部可以定义若干方法（method），其中`main`就是方法名，返回值类型是`void`（表示没有任何返回值）。
`static`同`pulic`也是修饰符，表示该方法是静态方法，java入口程序规定的方法必须是静态方法。

注释有三种如下写法
```java
// 第一种

/*
        第二种
 */

/**
 * 第三种
 */
```

> 另外，类名首字母习惯以大写字母开头，驼峰式命名。方法名习惯以小写字母开头。


## 数据类型
### 基本数据类型
* 整数类型：byte、short、int、long
* 浮点数类型：float、double
* 字符类型：char
* 布尔类型：bool

### 引用类型
引用类型最常用的就是`String`字符串。
```java
public class Main {
    public static void main(String[] args) {
        String s = "hello";
    }    
}
```

### 常量
定义变量的时候加上`final`修饰符，这个变量就变成了常量。

常量在定义式进行初始化时就不能再次赋值。
根据习惯，常量名经常全部大写。

### var 关键字
有些时候，类型的名字太长，如果想省略变量类型，可以使用`var`关键字。
```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
    }
};
// 等同于
public class Main {
    public static void main(String[] args) {
        var sb = new StringBuilder();       
    }
}
```

## 整数运算是类型自动提升和强制转换
```java
public class Main {
    public static void main(String[] args) {
        short s = 1234;
        int i = 123456;
        int x = s + i; // s自动转型为int
        short y = s + i; // 编译错误!
    }
}
```

## 数组、字符串都和 C 语言类似
