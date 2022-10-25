# 命令行环境
- [命令行环境](#命令行环境)
  - [命令行参数](#命令行参数)
  - [退出状态](#退出状态)
  - [环境变量](#环境变量)
  - [来源](#来源)

## 命令行参数
C 语言可以从命令行接收参数。
```c
#include <stdio.h>

int main(int argc, char* argv[]){
    for (int i = 0; i < argc; i++) {
        printf("arg %d: %s\n", i, argv[i]);
    }
}
```
```shell
$ gcc -o main main.c
$ ./main Simon 25
arg 0: ./main
arg 1: Simon
arg 2: 25
```
上述示例中，main 有两个参数`argc`（argument count）和`argv`（argument variable）。两个参数可以取其它的名字。

第一个参数`argc`是命令行参数的数量，应为程序名也包括在内，argc = 参数数量 + 1。

第二个参数`argv`是一个数组，保存了所有的命令行输入，每个成员都是一个字符串指针。

`./main Simon 25`，`argc`是3，`argv`是["./main", "Simon", "25"]，其实命令行参数就是`argv[1]`到`argv[argc - 1]`，`argv[argc]`则是一个空指针。

由于字符串指针可以看成是字符数组，下面几种写法是等价的。
```c
// 写法一
int main(int argc, char* argv[])

// 写法二
int main(int argc, char** argv)

// 写法三
int main(int argc, char argv[][])
```
另外，每个命令行参数可以写成数组形式`argv[i]`，也可以写成指针形式`*(argv + i)`。
所以参数遍历也可写成如下形式：
```c
for (char** p = argv; *p != NULL; p++){
    printf("arg: %s\n", *p);
}
```

## 退出状态
C 语言规定，如果`main()`函数没有`return`语句，则会在结束运行的时候，默认添加`return 0`，即返回整数`0`。
返回整数 0 表示程序运行成功；返回非零值，表示程序运行出了问题。

Bash的环境变量`$?`可以用来读取上一个命令的返回值。
```shell
$ ./main Simon 25
arg 0: ./main
arg 1: Simon
arg 2: 25
$ echo $?
0
```
> 注意，只有`main()`函数会默认添加`return 0`，其它函数都没有这个机制。

## 环境变量
C 语言提供了`getenv()`函数（原型定义在`stdlib.h`）用来读取命令行环境变量。
```c
int main(void){
    char* val = getenv("HOME");

    if(val == NULL){
        printf("Cannot find the HOME environment variable\n");
        return 1;
    }
    printf("HOME: %s\n", val);
    return 0;
}
```
```shell
HOME: /Users/frank-dc
```

## 来源
* [https://wangdoc.com/clang/cli.html](https://wangdoc.com/clang/cli.html)