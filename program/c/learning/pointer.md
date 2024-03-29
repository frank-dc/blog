# 指针
- [指针](#%E6%8C%87%E9%92%88)
    - [介绍](#%E4%BB%8B%E7%BB%8D)
    - [* 运算符](#-%E8%BF%90%E7%AE%97%E7%AC%A6)
    - [& 运算符](#-%E8%BF%90%E7%AE%97%E7%AC%A6)
    - [指针变量的初始化](#%E6%8C%87%E9%92%88%E5%8F%98%E9%87%8F%E7%9A%84%E5%88%9D%E5%A7%8B%E5%8C%96)
    - [指针的运算](#%E6%8C%87%E9%92%88%E7%9A%84%E8%BF%90%E7%AE%97)
    - [来源](#%E6%9D%A5%E6%BA%90)

## 介绍
指针是一个值，代表一个内存地址

字符`*`表示指针，通常跟在类型关键字的后面，表示指针指向的是什么类型的值。
```c
int * intPtr;       // * 可以放在 int 和 intPtr 之间任何位置。
int * foo, * bar;   // 同时声明两个指针变量，只能如示例所示。
```

## * 运算符
`*`这个符号除了`声明指针以外`，还可以作为运算符，用来取出`指针变量所指向的` `内存地址里面的值`。

事实上，函数内部通过指针，将值传到外部，是 C 语言的常用方法。

变量地址而不是变量值传入函数，还有一个好处。对于需要大量存储空间的`大型变量`，复制变量值传入函数，非常浪费时间和空间，不如传入指针来得高效。

## & 运算符
`&`运算符用来取出一个变量所在的内存地址。

`&`运算符（取内存地址）与`*`运算符（取内存地址里面的值）互为逆运算，下面的表达式总是成立。
```c
int i = 5;

if (i == *(&i)) // 正确
```
## 指针变量的初始化
声明指针变量后，编译器为指针变量本身分配一个内存空间（里面的值是随机的），指针变量指向的地址也是随机的。
```c
int * p;
*p = 1;     // 错误
```
正确的做法是，声明指针变量后，必须先让它指向一个分配好的地址，然后再进行读写，这叫做指针变量的初始化。
```c
int * p;
int i;

p = &i;     // 变量 i 的内存地址是分配好的，让指针变量 p 指向 i 的内存地址。
*p = 13;    // 对内存地址进行赋值。
```

为了防止读写未初始化的指针变量，可以养成习惯，将未初始化的指针变量设为`NULL`。
```c
int* p = NULL;
```
NULL在 C 语言中是一个常量，表示地址为0的内存空间，这个地址是无法使用的，读写该地址会报错。

## 指针的运算
* 指针与整数值的加减运算。

指针与整数值的运算，表示指针的移动。指针移动的单位，与指针指向的数据类型有关。数据类型占用多少个字节，每单位就移动多少个字节。
```c
int a = 2021;       // 4 个字节
int *pa = &a;

long long d = 1099; // 8 个字节
long long *pd = &d;

char c = 'a';       // 1 个字节
char *pc = &c;

printf("before pa = %#X\tpd = %#X\tpc = %#X\n", pa, pd, pc);
pa = pa + 1;
pd = pd + 1;
pc = pc + 1;
printf("after  pa = %#X\tpd = %#X\tpc = %#X\n", pa, pd, pc);
```
```text
// 输出
before pa = 0X6D3933E4	pd = 0X6D3933D0	pc = 0X6D3933C7
after  pa = 0X6D3933E8	pd = 0X6D3933D8	pc = 0X6D3933C8
```
![指针变量加减运算的结果跟数据类型的长度有关](https://github.com/frank-dc/drawpics/blob/main/addition_and_subtraction_of_pointer_and_integers.png?raw=true)

如图所示，`int`类型占用`4`个字节，如果`pa + 1`如图（2）红色虚线地址加 1 的话，那么前3个字节是变量`a`的，后面1个字节是其他数据的，把他们`搅合`在一起显然没有实际意义，取得的数据也会非常怪异。

如果`pa + 1`如图（3）地址加 4 的话，正好能够完全跳过整数变量 a，指向它后面的内存。

* 指针与指针的加法运算。

两个指针进行加法是非法的。`error: invalid operands to binary expression`
* 指针与指针的减法运算。

相同类型的指针允许进行减法运算，返回它们之间的距离，即相隔多少个数据单位。

高位地址减去低位地址，返回的是正值；低位地址减去高位地址，返回的是负值。返回的值属于`ptrdiff_t`类型，是一个带符号的整数类型别名，具体类型根据系统不同而不同。这个类型的原型定义在头文件`stddef.h`里面。
```c
short * j1;     // 2 个字节
short * j2;
j1 = (short *)0x1234;
j2 = (short *)0x1238;
ptrdiff_t dist = j1 - j2;
printf("%d\n", dist);       // output: -2
```
* 指针与指针的比较运算。
  
指针之间的比较运算，比较的是各自的内存地址哪一个更大，返回值是整数`1`（true）或`0`（false）。

## 来源
* [https://wangdoc.com/clang/pointer.html](https://wangdoc.com/clang/pointer.html)
