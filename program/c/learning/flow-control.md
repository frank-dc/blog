# 流程控制

## if 语句

如果有多个 if 和 else，并且没有使用大括号`{}`，那么`else`总是跟最接近的`if`匹配。
```c
int number = 6;
if (number > 6)
    if (number < 12)        // 下面 else 是和此 if 匹配。
        printf("The number is more than 6, less than 12.\n");
else
    printf("It is wrong number.\n");
```
这样很容易出错，为了提供代码的可读性，建议使用大括号`{}`，明确`else`匹配哪一个`if`。

## 三元运算符
三元表达式`?:`
```c
<expression1> ? <expression2> : <expression3>

// 比如，返回两个值之中的较大值。
(i > j) ? i : j;
```

## switch 语句
`switch` 语句是一种特殊形式的`if...else`结构，用于判断条件有多个结果的情况。
```c
switch (expression) {
    case value1:
        statement1;
        break;
    case value2:
        statement2;
        break;
    default:
        statement;
}
```
每个 case 语句提的结尾，都应该有一个`break`语句，作用是跳出整个`switch`结构。如果缺少`break`，就会导致继续执行下一个`case`或`default`分支。


## while 语句
`while` 语句用于循环结构，满足条件时，不断执行循环体。


## do...while 结构
`do...while`结构是`while`的变体，它会先执行一次循环体，然后再判断是否满足条件。如果满足的话，就继续执行循环体，否则跳出循环。
```c
int i = 10;
do {
    printf("i is %d\n", i);
    i--;
} while (i > 0);
```


## for 语句
```c
for (initialization; continuation; action) {
    statement;
}
```


## break 语句
* 和 switch 语句搭配使用，用来中断某个分支的执行。
* 在循环体内部跳出循环，不再进行后面的循环。

> `break`命令只能跳出循环体和`switch`结构，不能跳出`if`结构。


## continue 语句
`continue`语句用于在循环体内部终止`本轮循环`，进入下一轮循环。只要遇到 continue 语句，循环体内部后面的语句就不执行了，回到循环体的头部，开始执行下一轮循环。


## goto 语句
`goto`语句用于跳到指定的标签名。
```c
char ch;
top: ch = getchar();

if (ch == 'q')
    goto top;
```

* 跳出多层循环。
* 提早结束多重判断。

> `goto`只能在同一个函数之中跳转，并不能跳转到其它函数。


## 来源
* [https://wangdoc.com/clang/flow-control.html](https://wangdoc.com/clang/flow-control.html)