# typedef 命令
- [typedef 命令](#typedef-命令)
  - [简介](#简介)
  - [用法](#用法)
  - [好处](#好处)
  - [来源](#来源)

## 简介
`typedef`命令用来为某个类型起别名。
```c
typedef type alias;
```

## 用法
* 常规用法
```c
typedef unsigned char unchar;
unchar c = 'z';
```
`unsigned char`就是`type`（类型），`unchar`就是`alias`（别名）。

* 可以指定多个别名。
```c
typedef int aint, bint, cint;
```

* 可以为指针起别名，慎用，不容器看出指针变量类型。
```c
typedef int* intptr;

int a = 10;
intptr x = &a;
```

* 为数组类型起别名。
```c
typedef int five_ints[5];

five_ints x = {11, 22, 33, 44, 55};
```

* 为函数起别名。
```c
typedef signed char(*fp)(void);
```
类型别名`fp`是一个指针，代表函数`signed char(*)(void)`。

## 好处
* 代码更好的可读性
```c
typedef char* STRING;
STRING name;    // 可以轻易识别 name 是字符串。
```

* 为复杂数据结构（struct、union、enum）创建别名，便于引用。
```c
// 写法一
struct treenode {
    // ...
};

typedef struct treenode* Tree;

// 写法二
struct treenode {
    // ...
} Tree;

// 写法三
struct {
    // ...
} Tree;

```

* 方别以后为变量改类型。
```c
typedef float app_float;
app_float f1, f2, f3;
```
如果要将`f1`、`f2`、`f3`类型改为`long dubble`，只需要改`typedef`语句。
```c
typedef long dubble app_float;
```

* 提高代码可移植性，适配不同架构的计算机。
```c
typedef long int ptrdiff_t;
typedef unsigned long int size_t;
typedef int wchar_t;
```
这些整数类型别名都放在头文件stdint.h，不同架构的计算机只需修改这个头文件即可，而无需修改代码。

* 简化类型声明。
```c
char (*(*x(void))[5])(void);
```
可以这样声明
```c
typedef char(*Func)(void);
typedef Func Arr[5];
Arr* x(void);
```

## 来源
* [https://wangdoc.com/clang/typedef.html](https://wangdoc.com/clang/typedef.html)