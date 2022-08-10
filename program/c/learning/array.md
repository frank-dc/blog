# 数组

## 简介
1. 数组的成员从`0`开始编号。
2. 越界访问数组并不会报错，但是会更改其他变量的值（因为赋值的内存区域是其他变量的）。
3. 使用大括号赋值时，必须在数组声明时赋值，否则编译报错。
```c
int a[5] = {21, 83, 73, 28, 95};    // 正确

int a[5];
a = {21, 83, 73, 28, 95};    // 报错
```
4. 数组赋值后，再用大括号重新赋值也是不允许的。
```c
int a[5] = {1, 2, 3, 4, 5};
a = {21, 83, 73, 28, 95};    // 报错
```
5. 使用大括号赋值时，大括号里面的值的个数不能多余数组的长度。若是少数数组长度，为赋值的成员自动初始化为`0`。
6. 数组初始化时，可以给指定位置的成员赋值。
```c
int a[15] = {[2] = 29, [9] = 7, [13] = 48};
// 数组的第2号、第9号、第13号位置被赋值，其他位置自动初始化为 0。

// 等同于
int a[15] = {[9] = 7, [2] = 29, [13] = 48};
// 给指定位置的成员赋值可以不按照顺序。
```
7. 指定位置的赋值和顺序赋值，可以结合使用。
```c
int a[15] = {1, [5] = 10, 11, [10] = 20, 25};
```
8. C 语言允许省略方括号里面的数组成员数量，将会根据大括号里面的值的数量，自动确定数组的长度。
9. 省略方括号里面的数组成员数量时，如果采取指定位置赋值，那么数组长度将是最大的指定位置再加`1`。
```c
int a[] = {2, 8 ,3};
// 等同于
int a[3] = {2, 8, 3};

int a[] = {[2] = 6, [9] = 12};  // 数组最大指定位置是 9，所以数组的长度是 10。
```

## 数组长度
`sizeof`运算符会返回整个数组的字节长度，由于数组成员都是同一个类型，每个成员的字节长度都是一样的，所以数组整体的字节长度除以某个数组成员的字节长度，就可以得到数组的成员数量。
```c
int a[] = {22, 37, 3490};
// sizeof(a) -> 12
// sizeof(a[0]) -> 4
int arrayNumbers = sizeof(a) / sizeof(a[0]);    // 3
```
> 注意，sizeof 返回值的数据类型是`size_t`，占位符要用`%zd`或`%zu`。

## 变长数组
数组声明的时候，数组长度除了使用常量，也可以使用变量，叫做变长数组（variable-length array）。
```c
int n = x + y;
int arr[n];
```

## 数组地址
数组名等同于起始地址，也就是说，数组名就是指向第一个成员的指针。
```c
int a[] = {1, 2, 3, 4, 5};

printf("%p\n%p\n%p\n%p\n", &a, &a[0], &a[1], &a[2]);

// 0x16f7b33d0
// 0x16f7b33d0
// 0x16f7b33d4
// 0x16f7b33d8
```

## 数组指针的加减法
C 语言中数组名可以进行加减运算，等同于在数组成员之间前后移动，即从一个成员的内存地址移动到另一个成员的内存地址。
```c
int a[5] = {11, 22, 33, 44, 55};
```
比如，`a + 1`返回下一个成员的内存地址，`a - 1`返回上一个成员的内存地址。

由于数组名与指针是等价的，所以下面的等式总是成立。
```text
a[i] == *(a + i)
```
上面示例也就是数组成员的两种访问方式，一种是使用方括号`a[i]`，另一种是使用指针`*(a + i)`。

同一个数组的两个成员的指针相减时，返回它们之间的距离。
```c
int * p = &a[1];
int * q = &a[2];

printf("%i\n", p);          // 1862939604
printf("%i\n", q);          // 1862939608
printf("%i\n", q - p);      // 1
```

## 数组的复制
1. 使用循环，将数组元素逐个进行复制。
```c
int a[3];
int b[3] = {11, 22, 33};

for (int i = 0; i < 3; i++) {
    a[i] = b[i];
}
```
2. 使用`memcpy()`函数，直接把数组所在的那一段内存复制一份。
```c
int a[3];
int b[3] = {11, 22, 33};

memcpy(a, b, sizeof(b));
```

```c
int * a;
int b[3] = {11, 22, 33};

a = b;  // 由于数组名是指针，直接复制数组名，会让 a 和 b 指向同一个数组。
```

## 数组作为函数的参数
1. 定长数组作为参数
```c
// 函数原型（参数名可以省略）
int sum_array(int [], int);
int sum_two_dimensional_array([][4], int);
// 或者
int sum_array(int [*], int);
int sum_two_dimensional_array(int [*][4], int);

int sum_array(int a[], int n) {
    // 数组长度作为第二个参数传入。
    // ...
}

int sum_two_dimensional_array(int a[][4], int n) {
    // 二维数组第一维的长度作为第二个参数传入，第二维长度写入数组。
    // ...
}
```
[具体源代码参考](https://github.com/frank-dc/blog/blob/main/program/c/learning/immutable_length_array.c)


2. 变长数组作为参数
```c
int sum_array(int, int []);
int sum_two_dimensional_array(int, int, int [][*]);     // 第二维必须带 *，否则error: array has incomplete element type 'int []'

int sum_array(int n, int a[n]) {
    // ...
}

int sum_two_dimensional_array(int n, int m, int b[n][m]) {
    // ...
}
```
[具体源代码参考](https://github.com/frank-dc/blog/blob/main/program/c/learning/variable_length_array.c)

3. 数组字面量作为参数
```c
// 数组变量作为参数
int a[] = {11, 22, 33, 44, 55};
int sum = sum_array(a, 5);

// 数组字面量作为参数
int sum = sum_array((int []){11, 22, 33, 44, 55}, 5);
```

## 来源
* [https://wangdoc.com/clang/array.html](https://wangdoc.com/clang/array.html)