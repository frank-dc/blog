# 文件操作
- [文件操作](#文件操作)
  - [文件指针](#文件指针)
  - [fopen()和fclose()](#fopen和fclose)
  - [标准流](#标准流)
  - [EOF](#eof)
  - [freopen()](#freopen)
  - [读 相关函数](#读-相关函数)
    - [fgetc()和getc()](#fgetc和getc)
    - [fscanf()](#fscanf)
    - [fgets()](#fgets)
    - [fread()](#fread)
  - [写 相关函数](#写-相关函数)
    - [fputc()和putc()](#fputc和putc)
    - [fprintf()](#fprintf)
    - [fputs()](#fputs)
    - [fwrite()](#fwrite)
  - [文件内部指针操作](#文件内部指针操作)
    - [feof()](#feof)
    - [fseek()](#fseek)
    - [ftell()](#ftell)
    - [rewind()](#rewind)
    - [fgetpos()和fsetpos()](#fgetpos和fsetpos)
    - [ferror()、clearerr()](#ferrorclearerr)
  - [remove()](#remove)
  - [rename()](#rename)
  - [来源](#来源)

C 语言如何操作文件。

## 文件指针
C 语言提供了一个`FILE`数据结构，记录了操作一个文件所需要的信息。该结构定义在头文件`_stdio.h`，所有文件操作都要通过这个数据结构，获取文件信息。

开始操作一个文件前，要先定义一个指向该文件的`FILE`指针，相当于获取一块内存区域，用来保存文件信息。
```c
FILE* fp;
```

下面是一个读取文件的完整示例。
```c
#include <stdio.h>

int main(void) {
    FILE* fp;
    char c;

    fp = fopen("/Users/frank-dc/program/CLionProjects/c-learning/hello.txt", "r");
//    fp = fopen("./hello.txt", "r");   // 读取不到
//    fp = fopen("hello.txt", "r");     // 读取不到
    if (fp == NULL) {
        return -1;
    }

    c = fgetc(fp);
    printf("%c\n", c);

    fclose(fp);

    return 0;
}
```

## fopen()和fclose()
`fopen()`打开指定文件，返回一个`File`指针，如果出错，返回`NULL`。
`fclose()`关闭`fopen()`打开的文件。关闭成功，返回`0`，否则返回一个特殊值`EOF`。

## 标准流
Linux 系统默认提供三个已经打开的文件，它们的文件指针如下：
* `stdin`（标准输入）：默认输入为键盘，文件指针编号为`0`。
* `stdout`（标准输出）：默认输出为显示器，文件指针编号为`1`。
* `stderr`（标准错误）：默认输出为显示器，文件指针编号为`2`。

Linux 系统的文件，不一定是数据文件，也可以是设备文件，即文件代表一个可以读或写的设备。

所以，上述三个`标准流`分别把键盘、显示器看做一个文件。

Linux 允许改变这三个文件指针指向的文件，称为`重定向`。
```shell
$ demo < in.dat       # 输入重定向
$ demo > out.dat      # 输出重定向（会清空）
$ demo >> out.dat     # 输出重定向（会追加）
$ demo > out.dat 2> err.dat   # > 标准输出  2> 标准错误
$ demo < in.dat > out.dat
$ demo > out.dat < in.dat
$ random | sum        # 一个程序的标准输出作为另一个程序的标准输入
```

## EOF
C 语言文件操作函数的设计是，如果遇到文件结尾，就返回一个特殊值。

头文件`stdio.h`为这个特殊值定义了一个宏`#define	EOF	(-1)`。因为从文件读取的二进制值，不可能为负值，所以不会跟文件本身的数据相冲突。

不像字符串结尾真的存储了`\0`，`EOF`并不存储在文件结尾，文件中并不存在这个值，是文件操作函数先发现到达了文件结尾，而返回这个值。

## freopen()
用于新打开一个文件，直接关联到某个已经打开的文件指针，复用文件指针。
```c
freopen("/tmp/hello.txt", "w", stdout);
printf("hello\n");
```
上述示例，将`/tmp/hello.txt`关联到`stdout`，向 stdout 写入的内容，都会写入 hello.txt 文件中。
```c
freopen("/tmp/hello.txt", "w", stdout);
printf("hello\n");

freopen(NULL, "a+", stdout);    // 改变文件的打开模式，第一个参数为 NULL
printf("c program\n");
```

## 读 相关函数
### fgetc()和getc()
用于从文件读取一个字符，它们的用法跟`getchar()`类似，区别是`getchar()`只用来从`stdin`读取，而这两个函数是从任意指定的文件读取。

`getc()`一般用宏实现，`fgetc()`一般用函数实现。
```c
FILE* fp;
int c;

fp = fopen("/tmp/hello.txt", "r");

while ((c = fgetc(fp)) != EOF) {
    printf("%c\n", c);
}

fclose(fp);
```

### fscanf()
用于从文件中读取内容，`scanf()`是从`stdin`读取数据。
```c
FILE* fp;
char words[10];     // 不能定义成指针数组。

fp = fopen("/tmp/hello.txt", "r");

while(fscanf(fp, "%s", words) == 1) {
    puts(words);
}
```

### fgets()
用于从文件读取指定长度的字符串。
```c
char* fgets(char* str, int strlen, FILE* fp);
```
`fgets()`读取`strlen - 1`个字符之后，或者遇到换行符与文件结尾，就会停止读取，然后在已经读取的内容后面添加一个空字符`\0`，并且会将换行符`\n`存储进字符串。
* 下面示例读取文件所有行。
```c

int main(void) {
    FILE* fp;
    char s[1024];   // 如果超过此长度，就会断行。
    int linenumber = 0;

    fp = fopen("/tmp/hello.txt", "r");

    while(fgets(s, sizeof(s), fp) != NULL) {
        printf("%d: %s", ++linenumber, s);
    }
}
```
* 下面示例循环读取用户输入。
```c
int main(void) {
    FILE* fp;
    char s[10];

    puts("Enter strings (q to quit): ");

    while(fgets(s, sizeof(s), stdin) != NULL) {
        if(s[0] == 'q' && s[1] == '\n'){
            break;
        }
        puts(s);
    }
    puts("Done.");
}
```

### fread()
用于一次性从文件读取较大的数据块。
```c
size_t fread(void* ptr, size_t size, size_t nmemb, FILE* fp);
```
* `ptr` - 数组指针。
* `size` - 每个数组成员的大小，单位字节。
* `nmemb` - 数组成员的数量。
* `fp` - 要写入的文件指针。
```c
FILE* fp;
unsigned char c;

fp = fopen("/tmp/output.bin", "rb");
while(fread(&c, sizeof(char), 1, fp) > 0) {
    printf("%d\n", c);
}
```

## 写 相关函数
### fputc()和putc()
用于向文件写入一个字符，它们的用法跟`putchar()`类似，区别是`putchar()`只向`stdout`写入，而这两个函数是向任意指定的文件写入。

写入成功时，返回写入的字符；写入失败时，返回`EOF`。

### fprintf()
用来向文件写入格式化字符串，`printf()`是向`stdout`写入。
```c
printf("hello world\n");
// 等同于
fprintf(stdout, "hello world\n");
```

### fputs()
用于向文件写入字符串。写入成功时，返回一个非负整数，否则返回`EOF`。
```c
int fputs(const char* str, FILE* stream);
```
`fputs()`不会在字符串末尾加上换行符，因为`fgets()`保留了换行符，所以`fputs()`通常和`fgets()`配合使用。

### fwrite()
用来一次性写入较大的数据块。
```c
size_t fwrite(const void* ptr, size_t size, size_t nmemb, FILE* fp);
```
* `ptr` - 数组指针。
* `size` - 每个数组成员的大小，单位字节。
* `nmemb` - 数组成员的数量。
* `fp` - 要写入的文件指针。
```c
FILE* fp;
unsigned char bytes[] = {11, 22, 33, 44, 55, 66};

fp = fopen("/tmp/output.bin", "w");
fwrite(bytes, sizeof(char), sizeof(bytes), fp);
fclose(fp);
```

## 文件内部指针操作
### feof()
用来判断文件的内部指针是否指向文件的结尾。
```c
int feof(FILE* fp);
```
如果到达文件结尾处，返回一个非零值（表示true），否则返回`0`（表示false）。

### fseek()
每个文件指针内部都有一个内部指针，记录当前打开的文件的读写位置。可以使用`fseek()`函数将这个内部指针，移动到文件的指定位置。
```c
int fseek(FILE* stream, long int offset, int whence);
```
* `stream` - 文件指针。
* `offset` - 距离基准（第三个参数）的字节数。可以为正值（向文件末尾移动）、负值（向文件开始处移动）、0（保持不动）。
* `whence` - 位置基准，用来确定计算起点。它的值是以下三个宏：`SEEK_SET`（文件开始处）、`SEEK_CUR`（内部指针当前位置）、`SEEK_END`（文件末尾）。
```c
// 定位到文件开始处。
fseek(fp, 0L, SEEK_SET);

// 定位到文件末尾处。
fseek(fp, 0L, SEEK_END);

// 从当前位置后移2个字节。
fseek(fp, 2L, SEEK_CUR);

// 定位到文件第10个字节。
fseek(fp, 10L, SEEK_SET);

// 定位到文件倒数第10个字节。
fseek(fp, -10L, SEEK_END);
```

### ftell()
返回文件内部指针当前所在位置。
```c
long int ftell(FILE* fp);
```
下面示例得到文件开始到末尾的字节数。
```c
fseek(fp, 0L, SEEK_SET);
int size = ftell(fp);
```

### rewind()
让文件的内部指示器（内部指针）回到文件开始处。
```c
void rewind(FILE* fp);
```
`rewind(fp)`等价于`fseek(fp, 0L, SEEK_SET)`，区别是`rewind()`没有返回值，而且会清除当前文件的错误指示器。

### fgetpos()和fsetpos()
`ftell()`和`fseek()`文件大小有限制，在32位的系统上，表示的最大范围为4GB。
鉴于此，C 语言新增了两个处理大文件的定位函数，`fgetpos()`和`fsetpos()`。
```c
int fgetpos(FILE* stream, fpos_t* pos);
int fsetpos(FILE* stream, const fpos_t* pos);
```
`fgetpos()`函数会将文件内部指示器的当前位置，存储在指针变量`pos`。
`fsetpos()`函数会将文件内部指示器的位置，移动到指针变量`pos`（变量 pos 必须是通过 fgetpos() 函数获得的）指定的位置。
执行成功时，都会返回`0`，否则返回非零值。
```c
fpos_t file_pos;
fgetpos(fp, &file_pos);     // 获取内部指针的位置。

fsetpos(fp, &file_pos);     // 恢复内部指针的位置。
```

### ferror()、clearerr()
`ferror()`用来返回错误指示器的状态。如果前面操作错误，返回非零值，否则返回`0`。
```c
int ferror(FILE* stream);
```
`clearerr()`用来重置出错指示器。
```c
void clearerr(FILE* stream);
```
示例
```c
if (fscanf(fp, "%d", &n) != 1) {
    if (ferror(fp)) {
        printf("io error\n");
    }
    if (feof(fp)) {
        printf("end of file\n");
    }

    clearerr(fp);

    fclose(fp);
}
```

## remove()
用于删除指定文件。
```c
int remove(const char* filename);
```
接受文件名作为参数，如果删除成功，返回`0`，否则返回非零值。
```c
remove("/tmp/hello.txt");
```
删除的文件必须是关闭的状态，如果是`fopen()`打开的文件，必须用`fclose()`关闭后再删除。

## rename()
用于文件重命名，也用于移动文件。
```c
int rename(const char* old_filename, const char* new_filename);
```
操作成功返回`0`，否则返回非零值。
重命名示例
```c
rename("foo.txt", "bar.txt");
```
移动文件示例
```c
rename("/tmp/foo.txt", "/home/bar.txt");
```

## 来源
* [https://wangdoc.com/clang/file.html](https://wangdoc.com/clang/file.html)