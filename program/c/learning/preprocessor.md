# 预处理器
- [预处理器](#预处理器)
  - [简介](#简介)
  - [#pragam](#pragam)
  - [#error](#error)
  - [#define](#define)
  - [带参数的宏](#带参数的宏)
    - [基本用法](#基本用法)
    - [`#`和`##`运算符](#和运算符)
    - [不定参数的宏](#不定参数的宏)
  - [#undef](#undef)
  - [#include](#include)
  - [#if...#endif](#ifendif)
  - [#ifdef...#endif](#ifdefendif)
  - [#ifndef...#endif](#ifndefendif)
  - [#line](#line)
  - [预定义宏](#预定义宏)
  - [来源](#来源)

## 简介
C 语言编译器在编译程序之前，会先使用预处理器（`preprocessor`）处理代码。

预处理器首先会清理代码，比如删除注释、多行语句合成一个逻辑行等。然后执行`#`开头的预处理指令。

习惯上，预处理指令放在代码的开头部分，`#`与预处理指令不留空白字符（如空格或制表符），预处理指令结尾处不需要分号。

## #pragam
用来修改编译器属性，以下示例让编译器以`C99`标准进行编译。
```c
#pragma c9x on
```

## #error
用于让预处理器抛出一个错误，终止编译。
```c
#if __STDC_VERSION__ != 201112L
    #error Not C11
#endif
```
```shell
$ gcc -std=c99 main.c
main.c:7:6: error: Not C11
```

## #define
用来将指定的词替换成另一个词。每条替换规则，称为一个`宏`（macro）。
```c
#define MAX 100
```
指定源代码里面的`MAX`（称为一个宏），全部替换成`100`。

作用是使得程序的可读性更好，也更容易修改。

`#define`允许多重替换，即一个宏可以包含另一个宏。
```c
#define TWO 2
#define FOUR TWO*TWO    // FOUR 会被替换成 2*2
```

> 注意，如果宏出现在字符串里，或是其他标识符的一部分，就会失效，并不会发生替换。

## 带参数的宏
### 基本用法
宏可以接受一个或多个参数。
```c
#define SQUARE(X) X * X

z = SQUARZ(2);  // 会被替换成 z = 2*2
```
> 注意，和函数有区别，请看下面示例。

```c
printf("%d\n", SQUARZ(3 + 4));
```
上面示例中，`SQUARZ(3 + 4)`如果是函数，输出应该是`49`(7 * 7)；但是，宏是替换成`3 + 4 * 3 + 4`，最后输出`19`。

所以，上面最好使用圆括号。
```c
#define SQUARZ(X) ((X) * (X))
```
宏相对函数的优点是相对简单，本质上是字符串替换，不涉及数据类型，不像函数必须定义数据类型。而且，宏将每一处都替换成实际的代码，省掉了函数调用的开销，性能相对好一些。

### `#`和`##`运算符
因为宏不涉及数据类型，所以替换后可能为各种类型的值。如果希望替换后的值为字符串，可以在替换文本的前面加上`#`。
```c
#define STR(X) #X

printf("%s\n", STR(3.141596))
// 等同于 printf("%s\n", "3.141596")
```
如果没有`#`，那么`STR(3.141596)`会被替换成一个浮点数。

```c
#define MK_ID(n) i##n

int MK_ID(1) = 5, MK_ID(2) = 9;
printf("%i\n", i1); // 5
printf("%i\n", i2); // 9
```
`##`是将替换后的文本跟其他标识符连接在一起，组成新的标识符。

上面`MK_ID(1)`、`MK_ID(2)`分别替换成`i1`、`i2`。`##`运算符的一个主要用途是批量生成变量名和标识符。

### 不定参数的宏
宏的参数还可以是不定数量的（即不确定有多少个参数），`...`表示剩余的参数。
```c
#define X(a, b, ...) (10 * (a) + 20 * (b)), __VA_ARGS__
```
替换的文本中，`__VA_ARGS__`代表多余的参数（每个参数之间使用逗号分隔）。
```c
X(3, 5, 3.14, "Hi", 12);
// 替换成
(10 * (3) + 20 * (5)), 3.14, "Hi", 12
```
> 注意，`...`只能代表宏的尾部参数。

`__VA_ARGS__`前面加上一个`#`号，可以让输出变成一个字符串。
```c
#define X(...) #__VA_ARGS__

printf("%s\n", X(1,2,3));  // "1, 2, 3"
```

## #undef
用来取消已经使用`#define`定义的宏。

有时候想重新定义一个宏，但不确定是否以前定义过，就可以先用`#undef`取消，然后再定义。因为同名的宏如果两次定义不一样，会报错，而`#undef`的参数如果是不存在的宏，并不会报错。

GCC 的`-U`选项可以在命令行取消宏的定义，相当于`#undef`。
```shell
$ gcc -ULIMIT foo.c
```
`-U`参数取消了宏`LIMIT`。

## #include
用于编译时将其它源码文件，加载进入当前文件。有两种形式。
```c
// 形式一，加载系统提供的文件。
#include <system.h>

// 形式二，加载用户提供的文件。
#include "/usr/local/lib/user.h"
```
GCC 的`-I`选项可以指定`include`命令中用户文件的加载路径。
```shell
$ gcc -Iinclude/ -o code code.c
```
`-Iinclude/`指定从当前目录的`include`子目录中加载用户文件。

## #if...#endif
用于预处理器的条件判断，满足条件编译否则忽略。
```c
#if HAPPY_FACTOR == 0
    printf("I'm not happy!\n");
#elif HAPPY_FACTOR == 1
    printf("I'm just regular.\n");
#else
    printf("I'm extra happy!\n");
#endif
```
`#if`的常见应用就是打开（或关闭）调试模式。
```c
#define DEBUG 1

#if DEBUG
printf("value of i : %d\n", i);
printf("value of j : %d\n", j);
#endif
```
GCC 的`-D`参数可以在编译时指定宏的值，可以很方便打开调试开关。
```shell
$ gcc -DDEBUG=1 foo.c
```

## #ifdef...#endif
用于判断某个宏是否被定义过。也可以与`#else`指令配合使用。

等同于`#if defined`。
```c
#ifdef FOO
// 等同于
#if defined FOO
```

## #ifndef...#endif
用于判断某个宏没有定义过。等同于`#if !defined`。
```c
#ifndef FOO
// 等同于
#if !defined FOO
```

## #line
* 自定义行号
```c
#line 300   
// ... 此行的行号重置为 300
// ... 此行的行号为 301
```
* 自定义文件名
```c
#line 300 "newfilename"
// ... 此行的行号重置为 300， 文件名重置为 newfilename
```

## 预定义宏
C 语言提供了一些预定义宏，可以直接使用。
* `__DATE__`：编译日期，格式`Mmm dd YYYY`
* `__TIME__`：编译时间，格式`HH:MM:SS`
* `__FILE__`：当前文件名。
* `__LINE__`：当前行号。
* `__func__`：当前正在执行的函数名，必须在函数作用域使用。
* `__STDC__`：如果被设为1，表示当前编译器遵循 C 标准。
* `__STDC_HOSTED__`：如果被设为1，表示当前编译器可以提供完整的标准库；否则被设为0（嵌入式系统的标准库常常是不完整的）。
* `__STDC_VERSION__`：编译所使用的 C 语言版本，是一个格式为yyyymmL的长整数，C99 版本为“199901L”，C11 版本为“201112L”，C17 版本为“201710L”。
```c
#include <stdio.h>

int main() {
    printf("This function: %s\n", __func__);
    printf("This file: %s\n", __FILE__);
    printf("This line: %d\n", __LINE__);
    printf("Compiled on: %s %s\n", __DATE__, __TIME__);
    printf("C Version: %ld\n", __STDC_VERSION__);
}

/* output follow
This function: main
This file: /Users/frank-dc/program/CLionProjects/c-learning/main.c
This line: 6
Compiled on: Sep  1 2022 21:43:30
C Version: 201112
*/
```

## 来源
* [https://wangdoc.com/clang/preprocessor.html](https://wangdoc.com/clang/preprocessor.html)