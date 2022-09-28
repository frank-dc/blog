# 多文件项目
- [多文件项目](#多文件项目)
  - [简介](#简介)
  - [编译策略](#编译策略)
  - [make 命令](#make-命令)
  - [来源](#来源)

## 简介
一个软件项目往往包含多个源码文件，编译时需要将这些文件一起编译，生成一个可执行文件。

```c
// main.c
#include <stdio.h>

int main(void) {
    printf("%d\n", add(2, 3));
}
```
```c
// add.c
int add(int x, int y) {
    return x + y;
}
```
上述示例中，假设项目有两个源码文件`main.c`^[1]和`add.c`，主文件`main.c`调用了函数`add()`，此函数是在库文件`add.c`里面定义的。

[^1]: `main.c`是主文件，包含了`main()`函数的项目入口文件，里面会引用库文件定义的各种文件。

现在，将上述两个源码文件一起编译。
```shell
$ gcc -o main main.c add.c
# 或者
$ gcc -o main *.c
main.c:4:20: error: implicit declaration of function 'add' is invalid in C99 [-Werror,-Wimplicit-function-declaration]
    printf("%d\n", add(2, 3));
                   ^
1 error generated.
```
上述编译报错，因为编译器发现一个不认识的函数`add()`，`main.c`里面没有这个函数的原型或者定义。


```c
// main.c
#include <stdio.h>

int add(int, int);  // 在 main.c 里面添加 add() 的原型。

int main(void) {
    printf("%d\n", add(2, 3));
}
```

问题来了，如果有多个文件都使用`add()`函数的话，那么每个源文件里面都要添加函数原型。一旦修改函数`add()`（比如更改参数数量），就会非常麻烦，需要每个引用此函数的源文件逐一改动。

> 解决方案：通常的做法是新建一个专门的头文件`add.h`，放入所有在`add.c`里面定义的函数的原型。
```c
// add.h
int add(int, int);
```
然后使用`include`命令，在用到这个函数的源码文件里面加载这个头文件。
```c
#include <stdio.h>  // 尖括号表明此头文件是系统提供的。
#include "add.h"    // 双引号表明此头文件是用户提供的。没有写路径，就表示和当前源码文件在同一个目录。

int main(void) {
    printf("%d\n", add(2, 3));
}
```

最好也在`add.c`加载头文件`add.h`，让编译器验证函数原型和函数定义是否一致。
```c
#include "add.h"

int add(int x, int y) {
    return x + y;
}
```
[查看以上源码文件](src/multifile)

## 编译策略
多个源码文件的项目，编译时需要所有文件一起编译。因为编译的时间远远大于链接，所以在编译前可以先将所有源码文件编译为对象文件，再将所有对象文件链接在一起。
```shell
$ gcc -c *.c  // 生成后缀 .o 的文件
$ gcc -o main *.o
```

## make 命令
`make`是一个命令行工具，使用时会自动在当前目录下搜索配置文件`makefile`（或者`Makefile`），该文件定义了所有的编译规则，每个编译规则对应一个编译产物。
* 依赖项（生成该编译产物需要用到哪些文件）
* 生成命令（生成该编译产物的命令）

下列示例中，对象文件`add.o`是一个编译产物，它的依赖项是`add.c`，生成命令是`gcc -c add.c`
```c
add.o: add.c
    gcc -c add.c
```
编译规则由两行组成，第一行起首是编译产物，冒号后面是依赖项，第二行是生成命令。
> 注意，第二行的缩进必须使用`Tab`键，使用空格键会报错。

完整的配置文件`Makefile`由多个编译规则组成，类似下面的例子。
```text
main: main.o add.o
	gcc -o main main.o add.o

add.o: add.c
	gcc -c add.c

main.o: main.c
	gcc -c main.c

clean:
	rm -rf main *.o
```
`make`命令会根据不同的命令，生成不同的编译产物。
```shell
$ make main.o

# or
$ make add.o

# or
$ make main

# or 
$ make clean
```
如果省略了编译目标，`make`命令会执行第一条编译规则，构建相应的产物。
```shell
$ make
```
上面示例中，`make`后面没有编译目标，所以会执行 Makefile 第一条编译规则，即`make main`。

由于用户期望执行`make`后得到最终的可执行文件，所以建议总是把最终可执行文件的编译规则，放在 Makefile 文件的第一条。Makefile 本身对编译规则没有顺序要求。

`make`命令不是每次执行命令，都会进行编译，而是会检查是否有必要重新编译（只重新编译变动过的文件）。

## 来源
* [https://wangdoc.com/clang/multifile.html](https://wangdoc.com/clang/multifile.html)