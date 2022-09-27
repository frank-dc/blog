# 多文件项目

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