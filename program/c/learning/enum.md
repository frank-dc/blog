# Enum 类型

## 简介
如果一种数据类型的取值只有少数几种可能，并且每种取值都有自己的含义，为了提高代码的可读性，可以将它们定义为`Enum`类型，中文名为`枚举`。 
```c
enum colors {RED, GREEN, BLUE};

printf("%d\n", RED);    // 0
printf("%d\n", GREEN);  // 1
printf("%d\n", BLUE);   // 2
```
`enum`的属性会自动声明为常量。
```c
enum colors color = BLUE;
printf("%d\n", color);  // 2
```
`enum`会自动编号（从 0 开始递增），为常量赋值。当然也可以为`enum`常量指定值（只能是整数）。
```c
enum {ONE = 1, TWO = 2};
printf("%d\t%d\n", ONE, TWO);   // 1	2
```
可以指定随意的值。
```c
enum {X = 2, Y = 5, Z = -1};
```
如果一组常量有的指定了值，有的没有指定值，则没有指定值的常量会从上一个指定值的常量开始自动递增。
```c
enum {
    enum {
    A,
    B,
    C = 5,
    D,
    E,
    F = 3,
    G,
    H
};
printf("A = %d\nB = %d\nC = %d\nD = %d\nE = %d\nF = %d\nG = %d\nH = %d\n", A, B, C, D, E, F, G, H);
```
```text
A = 0
B = 1
C = 5
D = 6
E = 7
F = 3
G = 4
H = 5
```

## 来源
* [https://wangdoc.com/clang/enum.html](https://wangdoc.com/clang/enum.html)