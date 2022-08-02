# 数据类型

## 字符类型
字符类型声明使用`char`关键字。在计算机内部，字符类型使用`1个字节（8比特）`存储。C 语言将其当做整数处理，所以字符就是宽度为一个字节的整数。每个字符对应一个整数（参考 ASCII），比如`A`对应整数`65`。

C 语言规定，字符常量必须放在`单引号`里面。

反斜杠转义：用来表示 ASCII 码定义的一些无法打印的控制字符，它们也属于字符类型的值。
比如
```text
\n: 换行符。
\r: 回车符，光标移动到同一行的开头。
\t: 制表符，光标移到下一个水平制表位，通常是下一个8的倍数。
\v: 垂直分隔符，光标移到下一个垂直制表位，通常是下一行的同一列。
\0: null字符，代表没有内容。注意，这个值不等于数字0。
```

```c
char x = 'A';
char x = 65;
char x = '\101';        // 八进制
char x = '\x41';        // 十六进制
```


## 整数类型
整数类型声明使用`int`关键字。不通的计算机的`int`类型的大小不一样，比较常见的是使用`4个字节（32比特）`存储，但是`2个字节（16比特）`或`8个字节（64比特）`也有可能使用。

* 16位：-2<sup>15</sup> ~ 2<sup>15</sup> - 1

2<sup>15</sup> = 32767
* 32位：-2<sup>31</sup> ~ 2<sup>31</sup> - 1

2<sup>31</sup> = 2147483648
* 64位：-2<sup>63</sup> ~ 2<sup>63</sup> - 1

### 1. signed、unsigned

对于`int`类型，默认是带正负号的，等同于`signed int`。
对于不带正负号，只表示非负整数，必须使用关键字`unsigned`声明变量。同样长度的内存能够表示的最大整数值，增大了一倍。
```c
unsigned int a;
```

字符类型`char`也可以设置`signed`和`unsigned`。

### 2. 子类型
* short int（简写为`short`）：占用空间不多于`int`，一般占用 2 个字节。
* long int（简写为`long`）：占用空间不少于`int`，至少为 4 个字节。
* long long int（简写为`long long`）：占用空间多于`long`，至少为 8 个字节。

### 3. 整数的进制
C 语言中
* 八进制使用`0`作为前缀。
* 十六进制使用`0x`或`0X`作为前缀。
* 有些编译器使用`0b`前缀，表示二进制数，但不是标准。

`printf()`的进制相关占用符如下：
* `%d`：十进制整数。
* `%o`：八进制整数。
* `%x`：十六进制整数。
* `%#o`：带上前缀`0`的八进制整数。
* `%#x`：带上前缀`0x`的十六进制整数。
* `%#X`：带上前缀`0X`的十六进制整数。
```c
    int x = 100;
    printf("dec = %d\n", x);        // dec = 100
    printf("octal = %o\n", x);      // octal = 144
    printf("hex = %x\n", x);        // hex = 64

    printf("octal = %#o\n", x);     // octal = 0144
    printf("hex = %#x\n", x);       // hex = 0x64
    printf("hex = %#X\n", x);       // hex = 0X64
```

## 浮点数类型
参考 (https://github.com/frank-dc/blog/blob/main/program/understanding_float_point.md)

## 布尔类型
C 语言起初没有为布尔值单独设置一个类型，而是使用整数`0`表示伪，所有非零值表示真。

C99 标准添加了类型`_Bool`，表示布尔值。也只是整数类型的别名，还是使用`0`表示伪，`1`表示真。
```c
_Bool isNormal = 0;
if (isNormal) {
    printf("Everything is OK.\n");
}
else {
    printf("Error occur.\n");
}

// output: Error occur.
```

头文件`stdbool.h`定义了另一个类型别名`bool`，并且定义了`true`代表`1`，`false`代表`0`。
```c
#include <stdbool.h>
bool flag = true;
if (flag) {
    printf("Everything is OK.\n");
}
else {
    printf("Error occur.\n");
}
```

## 字面量的类型
```c
int x = 123;
```
字面量（literal）指的是代码里面直接出现的值。如上面代码，`x`是变量，`123`就是字面量。

编译时，字面量也会写入内存，因此编译器必须为字面量指定数据类型，就像必须为变量指定数据类型一样。


## 字面量后缀
让编译器知道字面量的类型。

常用的字面量后缀有：
* `f` 和 `F`: float 类型。
* `l` 和 `L`: 对于整数是 long int 类型，对于小数是 long dubble 类型。
* `ll` 和 `LL`: Long Long 类型。
* `u` 和 `U`: 表示unsigned int。

`u`可以和其它字面量后缀结合，无关乎顺序，比如`10UL`、`10LLU`。


## 溢出
每一种数据类型都有数值范围，如果存放的数值超出了这个范围（小于最小值或大于最大值），需要更多的二进制位存储，就会发生溢出。
大于最大值，叫做向上溢出（overflow）；小于最小值，叫做向下溢出（underflow）。

一般来说，编译器不会对溢出报错，会正常执行代码，但是会忽略多出来的二进制位，只保留符合长度的二进制位。
```c
unsigned char x = 255;      // 字符占一个字节，1111 1111
x++;                        // 256 -> 1 0000 0000
printf("%d\n", x);          // output: 0，最高位1被丢弃
```

> 溢出很容器被忽视，编译器又不会报错，所以必须非常小心。

错误1：
```c
for (unsigned int i = n; i >= 0; --i) // 错误
```
unsigned int 最小值就是 0，不可能得到小于 0 的结果，导致无限循环。

错误2：
```c
unsigned int ui;
unsigned int sum;

// 错误
if (sum + ui > UINT_MAX) too_big();
else sum = sum + ui;

// 正确
if (ui > UINT_MAX - sum) too_big();
else sum = sum + ui;
```
因为 ui 和 sum 都是 unsigned int 类型，相加后的和可能发生溢出，但还是 unsigned int 类型，不可能大于`UINT_MAX`。

正确的比较方法是，判断 UINT_MAX - sum 和 ui 之间的大小关系。

错误3：和错误1 类似
```c
unsigned int i = 5;
unsigned int j = 7;

// 错误
if (i - j < 0) 
  printf("negative\n");
else
  printf("positive\n");

// 正确
if (j > i)
```
也是因为 unsigned int 不可能得到小于 0 的结果。


## sizeof 运算符

## 来源
* [https://wangdoc.com/clang/types.html#navbar](https://wangdoc.com/clang/types.html#navbar)