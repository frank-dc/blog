# 数据类型
- [数据类型](#数据类型)
    - [字符类型](#字符类型)
    - [整数类型](#整数类型)
        - [1. signed、unsigned](#1-signedunsigned)
        - [2. 子类型](#2-子类型)
        - [3. 整数的进制](#3-整数的进制)
    - [浮点数类型](#浮点数类型)
    - [布尔类型](#布尔类型)
    - [字面量的类型](#字面量的类型)
    - [字面量后缀](#字面量后缀)
    - [溢出](#溢出)
    - [sizeof 运算符](#sizeof-运算符)
    - [类型的自动转换](#类型的自动转换)
    - [类型的显示转换](#类型的显示转换)
    - [可移植类型](#可移植类型)
    - [来源](#来源)

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
整数类型声明使用`int`关键字。不同的计算机的`int`类型的大小不一样，比较常见的是使用`4个字节（32比特）`存储，但是`2个字节（16比特）`或`8个字节（64比特）`也有可能使用。

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
`sizeof`是 C 语言提供的一个运算符，`返回`某种数据类型或某个值占用的`字节数量`。
```c
// 参数为数据类型
sizeof(int);        // output: 4
sizeof(char);       // output: 1
sizeof(int64_t);    // output: 8

// 参数为变量
int x;
sizeof(x);          // output: 4

// 参数为数值
sizeof(3.14);       // output: 8
```

## 类型的自动转换
某些情况下，C 语言会自动转换某个值的类型。 
> 赋值运算自动转换
1. 浮点数赋值给整数变量。
```c
int x = 3.14;
```
C 语言会整个舍弃小数部分，而不是四舍五入。因此上面示例中，`x`的值是`3`。

2. 整数赋值给浮点数变量。
```c
float y = 12 * 3;
```
上面示例中，变量`y`的值是`36.0`。

3. 窄类型赋值给宽类型。

4. 宽类型赋值给窄类型。
```c
int i = 321;
char ch = i;
printf("%c\n", ch)  // output: A
```
`i`（int 类型32比特）的二进制是 `00000000 00000000 00000001 01001011`

因为`ch`（char 类型）为8比特，只能保留后面的八位`01001011`（十进制的 65，相当于字符`A`）。

> 混合类型的运算自动转换
1. 整数与浮点数混合运算时，整数转为浮点数类型。
2. 不同的浮点数类型混合运算时，宽度较小的类型转为宽度较大的类型，比如`float`转为`double`。
3. 不同的整数类型混合运算时，宽度较小的类型会提升为宽度较大的类型，比如`short`转为`int`，`int`转为`long`，`signed`转为`unsigned`。

> 函数

函数的参数和返回值，会自动转成函数定义里指定的类型。
```c
int dostuff(int, unsigned char);

char m = 42;
unsigned short n = 43;
long long int c = dostuff(m, n);
```
上面示例中，参数变量m和n不管原来的类型是什么，都会转成函数dostuff()定义的参数类型。


## 类型的显示转换
C 语言提供了类型的显示转换，允许手动转换类型。

只要在一个值或变量的前面，使用圆括号指定类型`(type)`。


## 可移植类型
C 语言的整数类型（short、int、long）在不同计算机上，占用的字节宽度可能是不一样的，无法提前知道他们到底占用多少个字节。

头文件`stdint.h`创造了一些新的类型别名。
1. 精确宽度整数类型（exact-width integer type），保证某个整数类型的宽度是确定的。
```c
int8_t
int16_t
int32_t
int64_t
uint8_t
uint16_t
uint32_t
uint64_t
```
2. 最小宽度类型（minimum width type），保证某个整数类型的最小长度。
```c
int_least8_t
int_least16_t
int_least32_t
int_least64_t
uint_least8_t
uint_least16_t
uint_least32_t
uint_least64_t
```
3. 最快的最小宽度类型（fast minimum width type），可以使整数计算达到最快的类型。
```c
int_fast8_t
int_fast16_t
int_fast32_t
int_fast64_t
uint_fast8_t
uint_fast16_t
uint_fast32_t
uint_fast64_t
```
4. 可以保存指针的整数类型。
```text
intptr_t：可以存储指针（内存地址）的有符号整数类型。
uintptr_t：可以存储指针的无符号整数类型。
```
5. 最大宽度整数类型，用于存放最大的整数。
```text
intmax_t：可以存储任何有效的有符号整数的类型。
uintmax_t：可以存放任何有效的无符号整数的类型。
```

## 来源
* [https://wangdoc.com/clang/types.html#navbar](https://wangdoc.com/clang/types.html#navbar)

<div style="text-align: center;">[返回 C 语言学习](README.md)</div>