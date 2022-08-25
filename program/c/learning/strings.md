# 字符串
- [字符串](#字符串)
  - [简介](#简介)
  - [字符串变量的声明](#字符串变量的声明)
  - [字符串相关函数](#字符串相关函数)
  - [字符串数组](#字符串数组)
  - [来源](#来源)

## 简介
1. C 语言没有单独的字符串类型，字符串被当做字符数组，即`char`类型的数组。
2. 字符串当中的字符储存在相邻的内存单元之中，结尾自动添加`\0`字符，ASCII码是 48（二进制是 00110000）。
3. 双引号里面是字符串（结尾会自动添加`\0`），单引号里面是字符。
```c
{'H', 'e', 'l', 'l', 'o', '\0'};
    
// 等价于
"Hello"     // C 语言的简写法，会被自动视为字符数组。
```
4. 字符串不能使用单引号，双引号里面即使只有一个字符，也会被处理成字符串（末尾加`\n`）。
```c
char * s = 'Hello';     // 错误
```
5. 行尾使用反斜杠`\`，将一行拆成多行。
6. C 语言允许合并多个字符串字面量，只要这些字符串之间没有间隔，或者只有空格，会将它们自动合并。
```c
char * s = "Hello, "    "how are you ""today!";
char * a = "Hello, "
           "how are you "
           "today!";
printf("%s\n", s);      // Hello, how are you today!
printf("%s\n", a);      // Hello, how are you today!
```
7. `printf`使用占位符`%s`输出字符串。

## 字符串变量的声明
```c
// 写法一
char s[14] = "Hello world!"   // 数组长度可以省略 s[]

// 写法二
char * s = "Hello world!"   // 声明一个指针，指向字符数组。
```
字符数组的长度，可以大于字符串的实际长度，但是不能小于，否则可能导致字符串出错。

> 为什么声明为指针时不能修改，声明为数组是可以修改?

因为声明为指针时，系统会将字符串的字面量保存在内存的常量区，这个区是不允许用户修改的。
```c
char * s = "hello";
// 可以在申明时，使用 const 说明符，提醒用户该字符串是只读的。
const char * s = "hello";
s[0] = 'z';
printf("%s\n", s);  // Process finished with exit code 138 (interrupted by signal 10: SIGBUS)
```

而声明为数组时，编译器会给数组单独分配一段内存，字符串字面量会被编译器解释成字符数组，逐个字符写入这段新分配的内存之中，这段内存是允许修改的。
```c
char s[6] = "hello";
s[0] = 'z';
printf("%s\n", s);      // zello
```

> 声明为指针时，指针变量可以指向其它字符串
```c
char * s = "hello";
s = "world";
printf("%s\n", s);      // world
```
> 声明为数组时，字符数组变量不能指向另一个字符串。
```c
char s[6] = "hello";
s = "world";
printf("%s\n", s);      // error: array type 'char [6]' is not assignable
```
原因是字符数组的变量名，跟所指向的数组是绑定的，C 语言规定，该数组变量是一个不可修改的左值，不能用`赋值运算符`为它重新赋值。

想要重新赋值，必须使用 C 语言原生提供的`strcpy()`函数，通过字符串拷贝赋值，数组变量的地址依然不变。`strcpy()`只是在原地址写入新的字符串，而不是让数组变量指向新的地址。
```c
char s[] = "hello";
strcpy(s, "world");     // strcpy 原型定义在 string.h
printf("%s\n", s);
```

## 字符串相关函数
1. `strlen()`函数返回字符串字面量的字节长度，不包括末尾的空字符`\0`。而`sizeof`返回字符串变量字节长度。
```c
char s[] = "hello";

printf("sizeof: %d\n", sizeof(s));      // 6
printf("strlen: %d\n", strlen(s));      // 5

char s[50] = "hello";
printf("sizeof: %d\n", sizeof(s));      // 50
```

2. `strcpy()`函数的作用就是上文提到的，将一个字符串赋值给字符数组变量，因为字符串的复制不能使用赋值运算符。
```c
char * s1 = "Beast";
char s2[] = "Be the best that you can be.";

char * ps;

ps = strcpy(s2 + 7, s1);    // 从 s2 第7个位置开始拷贝字符串 Beast，后面内容会被截去。
                            // 该函数返回的是一个指针，指向拷贝开始的位置。

puts(s2);   // Be the Beast
puts(ps);   // Beast

printf("%p\n", s1);     // 0x104fd3f90
printf("%p\n", ps);     // 0x16ae2f877
```
> 该函数使用有安全风险，因为它并不检查目标字符串的长度，是否足够容纳原字符串的副本，可能导致写入溢出。建议使用`strncpy()`函数。

3. `strncpy()`函数作用如`strcpy()`，多了第三个参数，用来指定复制的最大字符数，防止溢出目标字符串变量的边界。
```c
char s1[40];
char s2[12] = "hello world";

strncpy(s1, s2, 7);

printf("%s\n", s1);     // hello w
```

4. `strcat()`、`strncat()`函数用于连接字符串。后者可以指定最大添加的字符数，所以`strcat()`需要注意原字符串的长度。
```c
char s1[10] = "Monday";
char * s2 = "Tuesday";

strncat(s1, s2, 3);
puts(s1);       // MondayTue
```

5. `strcmp()`、`strncmp()`函数用于比较两个字符串的内容，前者比较的是整个字符串，后者是比较到指定的位置。
```c
char * s1 = "How do you do!";
char * s3 = "How are you?";

printf("%d\n", strncmp(s1, s3, 5));     // 3
printf("%d\n", strncmp(s3, s1, 5));     // -3
printf("%d\n", strncmp(s1, s3, 3));     // 0
```

6. `sprintf()`、`snprintf()`函数用于将数据写入字符串，而不是输出到显示器。
```c
char * s1 = "Hello";
char * s2 = "world";
char s[50];

sprintf(s, "%s %s", s1, s2);
printf("%s\n", s);      // Hello world

snprintf(s, 10, "%s %s", s1, s2);       // 可以控制写入的字符串的长度。
printf("%s\n", s);      // Hello wor
```

## 字符串数组
每个字符串本身是一个字符数组，多个字符串需要通过二维的字符数组实现。
```c
char weekdays[7][10] = {
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
};
```

因为第一维的长度，编译器可以自动计算，因此可以省略。
```c
char weekdays[][10] = {
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
};
```

第二维的长度统一设定为10，浪费空间，可以将第二维从`字符数组`改成`字符指针`。
```c
char * weekdays[] = {
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
};
```
这样的话其实是一个一维数组，成员就是7个字符指针，每个指针指向一个字符串（字符数组）。

## 来源
* [https://wangdoc.com/clang/string.html](https://wangdoc.com/clang/string.html)

<div style="text-align: center;">[返回 C 语言学习](README.md)</div>