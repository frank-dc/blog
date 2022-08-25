# 内存管理
- [内存管理](#内存管理)
  - [简介](#简介)
  - [void 指针](#void-指针)
  - [内存管理相关函数](#内存管理相关函数)
  - [restrict 说明符](#restrict-说明符)
  - [来源](#来源)

## 简介
C 语言的内存管理，分成两部分，一部分是`系统管理`的，另一部分是`用户手动管理`的。

系统管理的内存，主要是函数内部的变量（即局部变量）[^1]，这些变量所在的内存称为`栈（stack）`，即`栈`所在的内存是系统自动管理的。

[^1]: 这部分变量在函数运行时进入内存，函数运行结束后自动从内存卸载。

用户手动管理的内存，主要是程序运行的整个过程中都存在的变量（即全局变量）[^2]，这些变量所在的内存称为`堆（heap）`，即`堆`所在的内存是用户手动管理的。

[^2]: 这些变量需要用户手动从内存释放，如果使用后忘记释放，它们就会一直占用内存，直到程序退出，这种情况称为`内存泄露（memory leak）`。

## void 指针
前面说过，申请内存[^3]的时候，必须要确定数据类型。
[^3]: 每一块内存都有地址，指针变量就是可以指向内存地址。

但是会有这种需求：申请内存的时候，事先不确定数据类型，需要使用的时候才能确定。为了满足这种需求，C 语言提供了一种不定类型的指针，叫做 `void 指针`。
```text
void 指针只有内存块的地址信息，没有类型信息，等到使用该内存块的时候，再向编译器补充说明，里面的数据是何种类型。
```
void 指针与其他所有类型的指针之间可以互相转换。
```c
int x = 10;

void * p = &x;  // 整数指针转为 void 指针。
int * q = p;    // void 指针转为整数指针。
```
> 注意，由于不知道 void 指针指向什么类型的值，所以不能用 `*` 运算符取出它指向的值。
```c
int x = 10;
void * p = &x;

printf("%d\n", *p);     // error: argument type 'void' is incomplete
```

## 内存管理相关函数
* `malloc()`函数用于分配内存，该函数向系统要求一段内存，系统就在`堆`里面分配一段连续的内存块给它。
```c
// 原型定义
void	*malloc(size_t __size) 
```
```c
int * p = malloc(sizeof(int));

*p = 12;
printf("%d\n", *p);
```
`malloc()`函数返回一个无类型的 void 指针，有时候为了增加代码的可读性，可以对`malloc()`返回的指针进行一次强制类型转换。
```c
int * p = (int*) malloc(sizeof(int));
```

* `free()`函数用于释放 malloc() 函数分配的内存，将这块内存还给系统以便重新使用，否则这块内存会一直占用到程序运行结束。
```c
// 原型定义
void	 free(void *);
```
```c
int * p = (int*) malloc(sizeof(int));

*p = 12;
free(p);
```

* `calloc()`函数的作用与 malloc() 相似，也是分配内存块。
```c
// 原型定义
void	*calloc(size_t __count, size_t __size)
```
calloc() 与 malloc()的区别：
1. `calloc()`接受两个参数，第一个参数是某种数据类型的值的数量，第二个是该数据类型的单位字节长度。
2. `calloc()`会将所分配的内存全部初始化为`0`。`malloc()`不会对分配的内存进行初始化，如果要初始化，需要调用`memset()`函数。
```c
int * p = calloc(10, sizeof(int));

// 等同于
int * p = malloc(sizeof(int) * 10);
memset(p, 0, sizeof(int) * 10);
```

* `realloc()`函数用于修改已经分配的内存块的大小，返回一个指向新的内存块的指针。
```c
// 原型定义
void	*realloc(void *__ptr, size_t __size)
// 第一个参数是已经分配好的内存块指针。
// 第二个参数是该内存块的新大小，单位为字节。
```

`realloc()`可能返回一个全新的地址（数据也会自动复制过去），也可能返回原来的地址。
```c
int * p;
p = malloc(sizeof(int) * 10);       // 指向10个成员的整数数组。
p = realloc(sizeof(int) * 100);     // 调整为指向100个成员的整数数组。
```

`realloc()`的第一个参数可以是`NULL`，这时相当于新建一个指针。
```c
char * p = realloc(null, 3490);
// 等同于
char * p = malloc(3490);
```
`realloc()`第二个参数如果是`0`，就会释放掉内存块。
> 注意，`realloc()`有分配失败的可能（返回 NULl），并且不会对内存块进行初始化。

* `memcpy()`函数用于将一块内存拷贝到另一块内存。
```c
// 原型定义
void *memcpy(void *dst, const void *src, size_t n)
```
```c
char s[] = "Goats";
char t[100];

memcpy(t, s, sizeof(s));    // 拷贝6个字节，包括终止符\0。
printf("%s\n", t);          // Goats
```
`memcpy()`可以取代`strcpy()`进行字符串拷贝，更安全速度也更快。
```c
char * s = "hello world";
size_t len = sizeof(s);
char * c = malloc(len);

if(c) {
    // strcpy() 的写法
    strcpy(c, s);
    
    // memcpy() 的写法
    memcpy(c, s, len);
}
```

* `memmove()`函数用于将一段内存数据复制到另一段内存。它和`memcpy()`的区别是，memmove() 允许目标区域和源区域有重叠，如果发生重叠，源区域的内容会被更改；如果没有重叠，与 memcpy()行为相同。
```c
// 原型定义
void *memmove(void *dst, const void *src, size_t len)
```
```c
int a[100] = {1, 2, 3, [80] = 80, 4, 5, 6, [95] = 95};
memmove(&a[0], &a[1], 99 * sizeof(int));    // 从 a[1]开始的99个成员，都向前移动一个位置。

printf("%d\n", a[79]);      // 80
```

* `memcmp()`函数用来比较两个内存区域。返回值是一个整数。
```c
// 原型定义
int	 memcmp(const void *__s1, const void *__s2, size_t __n)
```
```c
char * s1 = "abc";
char * s2 = "xyz";

int r = memcmp(s1, s2, 3);      // s1 > s2，返回大于 0 的整数；s1 < s2，返回小于 0 的整数。
printf("%d\n", r);      // -23

// 'a' == 97
// 'x' == 120
```


## restrict 说明符
申明指针变量时，可以使用`restrict`说明符，告诉编译器，该块内存区域只有当前指针一种访问方式，其他指针不能读写这块内存。
```c
int * restrict p;
p = malloc(sizeof(int));
```

## 来源
* [https://wangdoc.com/clang/memory.html](https://wangdoc.com/clang/memory.html)

<div style="text-align: center;">[返回 C 语言学习](README.md)</div>