# 函数
- [函数](#函数)
  - [简介](#简介)
  - [main 函数](#main-函数)
  - [参数的传值引用](#参数的传值引用)
  - [函数指针](#函数指针)
  - [函数原型](#函数原型)
  - [exit()](#exit)
  - [函数说明符](#函数说明符)
  - [可变参数](#可变参数)
  - [来源](#来源)

## 简介
函数是一段可以重复执行的代码。它可以接受不同的参数，完成对应的操作。

```c
int plus_one(int n) {
    return n + 1;
}
```

函数声明语法：
* 返回值类型。`int`
* 函数名称。`plus_one`
* 参数（参数类型 参数名称）。`int` `n`
* 函数体，写在大括号里面，大括号后面不用加分号。
* return 语句，给出函数的返回值，程序运行到这一行，就会跳出函数体，结束函数的调用。如果没有返回值，可以省略 return 语句，或者写成`return;`。

C 语言标准规定，函数只能声明在源码文件的顶层，不能声明在其他函数内部。函数必须声明后使用。

不返回值的函数，使用`void`关键字表示返回值的类型。没有参数的函数，声明时要用`void`关键字表示参数的类型。
```c
void myFunc(void) {
    // ...
}
```

## main 函数
C 语言规定，`main()`函数是程序的入口函数，即所有的程序一定要包含一个`main()`函数。程序总是从这个函数开始执行。

C 语言约定，返回值`0`表示函数运行成功，如果返回其他非零整数，就表示运行失败。正常情况下，如果 main() 里面省略`return 0;`这一行，编译器会自动加上，即 main() 的默认返回值为 0。

## 参数的传值引用
如果函数的参数是一个变量，那么调用时，传入的是这个`变量的值的拷贝`，`而不是变量本身`。
```c
void increment(int a) {
    a++;
}

int main() {
    int i = 10;
    increment(i);
    printf("%d\n", i);
}
```
上面示例中，调用`increment(i)`以后，变量本身不会发生变化，还是等于`10`。因为传入函数的是`i`的拷贝，而不是`i`本身，拷贝的变化，影响不到原始变量。这就叫做`传值引用`。

如果想要传入变量本身，只有一个办法，就是传入变量的内存地址。
```c
int Swap(int *x, int *y) {
    int temp;
    temp = *x;
    *x = *y;
    *y = temp;
}

int main() {
    int a = 1;
    int b = 2;
    Swap(&a, &b);
    printf("a: %d\nb: %d\n", a, b);
}
```
> 注意，函数不要返回内部变量的指针。因为当函数结束运行时，内部变量就消失了，这时指向内部变量`i`的内存地址就是无效的，再去使用这个地址是非常危险的。
```c
int* f(void) {
    int i;
    // ...
    return &i;      // 危险
}
```

## 函数指针
```c
void print(int a) {
    printf("%d\n", a);
}

void (*print_ptr)(int) = &print;    // 注意，(*print_ptr) 一定要写在圆括号里面，否则函数参数
// (int) 的优先级高于 *。
```
C 语言规定，函数名本身就是指向函数代码的指针，通过函数名就能获取函数地址。即`print`和`&print`是一回事。

对于任意函数，都有五种调用函数的写法。
```text
// 写法一
print(10)

// 写法二
(*print)(10)

// 写法三
(&print)(10)

// 写法四
(*print_ptr)(10)

// 写法五
print_ptr(10)
```

## 函数原型
因为函数必须先声明，后使用。由于程序总是先运行`main()`函数，导致所有其他函数都必须在`main()`函数之前声明。

但是，只要在程序开头处给出函数原型，函数就可以先试用，后声明。所谓函数原型，就是提前告诉编译器，每个函数的返回类型和参数类型。
```c
int twice(int);
// 等同于
int twice(int num);     // 函数原型包括参数名也可以，有助于理解函数的意图，但是对于编译器是多余的。

int main(int num) {
    return twice(num);
}

int twice(int num) {
    return 2 * num;
}
```

## exit()
在 main() 函数里面，exit() 等价于使用 return 语句；在其他函数里面使用 exit()，就是终止整个程序的运行，没有其他作用。

C 语言还提供了一个`atexit()`函数，用来登记`exit()`执行时额外执行的函数，用来做一些退出程序时的收尾工作。

以上原型定义在头文件`stdlib.h`里面。

## 函数说明符
1. extern 说明符
```c
extern int foo(int arg1, char arg2);

int main(void) {
    int a = foo(2, 'a');
    // ...
    return 0;
}
```
对于多文件的项目，源码文件会用到其他文件声明的函数。在当前文件里面，需要给出外部函数的原型，`extern`用来说明该函数的定义来自其他文件。

由于函数原型默认就是`extern`，所以这里不加`extern`，效果一样。

2. static 说明符
> 默认情况下，每次调用函数时，函数的内部变量都会重新初始化，不会保留上一次运行的值。
* static 可以改变上述行为，用于函数内部声明变量时，表示该变量只需要初始化一次。
```c
void counter(void) {
    static int count = 1;       // static 声明的变量默认值为 0。
    printf("%d\n", count);
    count++;
}

int main(void) {
    counter();  // 1
    counter();  // 2
    counter();  // 3
}
```
static 修饰的变量初始化时，只能赋值为常量，不能赋值为变量。
```c
int i = 3;
static int j = i;   // 错误
```

* static 可以用来修饰函数本身。表示该函数只能在当前文件里使用，其他文件不可以使用该函数。
```c
static int Twice(int num) {
    int result = num * 2;
    return resutl;
}
```

* static 可以用在参数里面，修饰参数数组。
```c
int sum_array(int a[static 3], int n) {
    // ...
}
```
上面示例中，static 告诉编译器，该数组长度至少为 3。

3. const 说明符
函数参数里面的 const 说明符，表示函数内部不得修改该参数变量。
```c
void f(const int* p) {
    *p = 0;     // 报错
    
    int x = 13;
    p = &x;     // 只限制修改 p 所指向的值，而 p 本身的地址是可以修改的。
}

void f(int* const p) {
    int x = 13;
    p = &x;     // 报错，限制 p，但是不限制 *p。
}

void f(const int* const p) {        // p 和 *p 都不能修改。
    // ...
}
```

## 可变参数
有些函数的参数数量是不确定的，声明函数的时候，可以使用省略号`...`表示可变数量的参数。
```c
int	 printf(const char * __restrict, ...) __printflike(1, 2);
```
头文件`stdarg.h`定义了一些宏，可以操作可变参数。

（1）va_list: 一个数据类型，用来定义一个可变参数对象。

（2）va_start: 一个函数，用来初始化可变参数对象。

（3）va_arg: 一个函数，用来取出当前那个可变参数。

（4）va_end: 一个函数，用来清理可变参数对象。
```c
double average(int i, ...) {
    double total = 0;
    va_list ap;
    va_start(ap, i);
    for (int j = 1; j <= i; ++j) {
        total += va_arg(ap, double);
    }
    va_end(ap);
    return total / i;
}
```
上面示例中，`va_list ap`定义 ap 为可变参数对象，`va_start(ap, i)`将参数i后面的参数统一放入 ap，`va_arg(ap, double)`用来从ap依次取出一个参数，并且指定该参数为 double 类型，`va_end(ap)`用来清理可变参数对象。

## 来源
* [https://wangdoc.com/clang/function.html](https://wangdoc.com/clang/function.html)

[返回 C 语言学习](README.md)