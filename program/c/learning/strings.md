# 字符串

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

```