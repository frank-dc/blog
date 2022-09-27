# 变量说明符
- [变量说明符](#变量说明符)
  - [简介](#简介)
  - [const](#const)
  - [static](#static)
  - [auto](#auto)
  - [extern](#extern)
  - [register](#register)
  - [volatile](#volatile)
  - [restrict](#restrict)
  - [来源](#来源)

## 简介
C 语言允许声明变量的时候，加上一些指定的说明符，为编译器提供变量行为的额外信息。主要作用是帮助编译器优化代码，有时会对程序产生影响。

## const
`const`说明符表示变量是只读的，不得被修改。
```c
const double PI = 3.14159;
PI = 3; // error: cannot assign to variable 'PI' with const-qualified type 'const double'.
```
```c
const int arr[] = {11, 22, 33, 44, 55};
arr[1] = 222;   // error: cannot assign to variable 'arr' with const-qualified type 'const int [5]'.
```
> 对于指针变量，`const` 有两种写法，含义是不一样的。
* `const`在`*`前面，表示赋给指针的`值不能修改`。
```c
// const 表示指向的值 *x 不能修改。
const int * x;
// 或者
int const * x;

int v = 1;
x = &v;
printf("%d\n", *x); // 1
printf("%d\n", (*x)++); // error: read-only variable is not assignable.
```
* `const`在`*`后面，表示指针指向的`地址不能修改`。
```c
// const 表示指向的地址 x 不能修改。
int * const x;

int p = 1;
x = &p; // 不能赋值，得在定义时赋值。

int * const x = &p;
printf("%p\n", x++);    // error: cannot assign to variable 'y' with const-qualified type 'int *const'
```
* 两者结合，表示两者皆不能修改。
```c
const int* const x;
```
> 防止函数体内修改函数参数，可以对某个参数添加`const`说明符。

```c
void find(const int* arr, int n);
```

## static
`static`说明符对于局部变量和全局变量有不同的含义。
* 用于局部变量

`static`用于函数内部声明的局部变量时，表示该变量的值在函数每次执行后都会得到保留，下次执行时不会进行初始化，类似于一个函数内部的全局变量。
* 用于全局变量

`static`用于函数外部声明的全局变量时，表示该变量只用于当前文件，其它源码文件不可以引用该变量，即改变量不会被链接（link）。

`static`修饰的变量，初始化时，值不能等于变量，只能是常量。
```c
int n = 10;
static int m = n;   // error: initializer element is not a compile-time constant
```

在申明函数前加上`static`，表明该函数只在当前文件使用，其它文件可以定义同名函数。

## auto
`auto`说明符表示该变量的存储，由编译器自主分配内存空间，且只存在于定义时所在的作用域，退出作用域时会自动释放。

由于只要不是extern的变量（外部变量），都是由编译器自主分配内存空间的，这属于默认行为，所以该说明符没有实际作用，一般都省略不写。
```c
auto int a;
// 等同于
int a;
```

## extern
`extern`说明符表示该变量在其他环境里面声明，没有必要在当前文件里面为它分配内存空间。通常用来表示，该变量是多个文件共享的。
```c
extern int a;
```
上述示例中表明变量`a`在其他文件里面定义和初始化，当前文件不必为它分配内存。

如果声明变量时，同时进行初始化，`extern`就会无效。
```c
extern int i = 0;
// 等同于
int i = 0;
```

函数内部使用`extern`说明符申明变量，就相当于该变量是静态存储，每次执行都要从外部获取它的值。

函数本身默认是`extern`，即函数可以被外部文件共享，通常省略`extern`不写。如果只希望函数在当前文件可用，可以加上 [static](#static)。
```c
extern int f(int i);
// 等同于
int f(int i);
```

## register
`register`说明符向编译器表示，该变量应该放进寄存器，以便提高更快的读取速度。但是编译器不一定严格执行，可能会忽略。

设为`register`的变量，不能获取它的地址。
```c
register int a;
int* p = &a;    // error: address of register variable requested
```

## volatile
`volatile`说明符表示所声明的变量，可能会发生预想不到的变化（即其他程序可能会更改其值），不受当前程序控制，让编译器不要对这类变量优化，每次使用时应该查询一下它的值。

硬件设备的编程中，这个说明符很常用。

## restrict
`restrict`说明符允许编译器优化某些代码。它只能用于指针，表明该指针是访问数据的唯一方式。
```c
int foo[10];
int* bar = foo;
```
上面示例中，变量`foo`指向的内存，`foo`和`bar`都可以访问，因此就不能将`foo`设置为`restrict`。

如果编译器知道某块内存只能用一种方式访问，就可以更好地优化代码，不用担心其它地方会修改值。

`restrict`用于函数参数时，表示参数的内存地址之间没有重叠。
```c
void swap(int* restrict a, int* restrict b) {
    int t;
    t = *a;
    *a = *b;
    *b = t;
}
```

## 来源
* [https://wangdoc.com/clang/specifier.html](https://wangdoc.com/clang/specifier.html)