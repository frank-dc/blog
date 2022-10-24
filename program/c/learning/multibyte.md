# 多字节字符
- [多字节字符](#多字节字符)
  - [Unicode 简介](#unicode-简介)
  - [字符的表示方法](#字符的表示方法)
  - [多字节字符的表示方法](#多字节字符的表示方法)
  - [宽字符](#宽字符)
  - [多字节字符处理函数](#多字节字符处理函数)
  - [来源](#来源)

## Unicode 简介
Unicode 对所有符号编码，包含100多万个字符，为每个字符提供一个号码，称为码点（code point），其中0到127的部分，跟 ASCII 码重合。

通常使用`U+十六进制码点`表示一个字符，比如`U+41`（十进制是`65`）表示字母`A`。码点范围是`U+0000`到`U+10FFFF`（二进制表示`10000 11111111 11111111`）（十进制表示`1 114 111`）。[进制转换](https://baseconvert.com/)

完整表达整个 Unicode 字符集，至少需要三个字节。如果统一使用三个字节，对于存储来说是极大的浪费，为了适应不同的使用需求，提供了三种不同的实现方式，分别为`UTF-8`、`UTF-16`、`UTF-32`。
* UTF-8: 使用1个到4个字节，表示一个码点（变长的编码方式），即不同的字符占用的字节数不一样。
* UTF-16: 对于U+0000 到 U+FFFF 的字符（称为基本平面），使用2个字节表示一个码点。其他字符使用4个字节。
* UTF-32: 统一使用4个字节，表示一个码点。

下文记录一下`UTF-8`的编码规则：
1. 对于单字节的字符，字节的第一位设为`0`，后面7位为这个符号的 Unicode 码，因此 U+0000 到 U+007F 的 UTF-8 编码和 ASCII 码是相同的。
2. 对于`n`字节的字符（1 < n < 4），第一个字节的前`n`为都设为`1`，第`n+1`位设为`0`，后面字节的前两位一律设为`10`。剩下的没有提及的二进制位，全部为这个符号的 Unicode 码。

下表总结了编码规则，字母`x`表示可用于编码的位。

| Unicode符号范围（十六进制）     | UTF-8编码方式（二进制）                      |
|:----------------------|:------------------------------------|
| 0000 0000 - 0000 007F | 0xxxxxxx                            |
| 0000 0080 - 0000 07FF | 110xxxxx 10xxxxxx                   |
| 0000 0800 - 0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx          |
| 0001 0000 - 0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx |

如果一个字节的第一位是`0`，表示占用一个字节；第一位是`1`，则连续有多少个`1`，就表示当前字符占用多少个字节。

>下面已汉字`超`为例，演示如何实现 UTF-8 编码。

`超`的 Unicode 码是`8d85`（10001101 10000101），根据上表，可以发现`8d85`处在第三行的范围内（0000 0800 - 0000 FFFF），因此`超`的 UTF-8 编码需要三个字节，即格式为`1110xxxx 10xxxxxx 10xxxxxx`。然后，从`超`的最后一个二进制位开始，依次从后向前填入格式中的`x`，多出来的位补`0`，这样就得到了`超`的 UTF-8 的编码是`11101000 10110110 10000101`，转换成十六进制就是`E8B685`。

对应的python编程实现。
```python
ord('超')    # 获取'超'的 Unicode code point（十进制）
# 36229
hex(36229)  # 转换成十六进制
# '0x8d85'
bin(36229)  # 转换成二进制
# '0b1000110110000101'
'超'.encode('utf-8') # '超'的 UTF-8 编码
# b'\xe8\xb6\x85'
```

## 字符的表示方法
字符表示法的本质，是将每个字符映射为一个整数，然后从编码表获得该整数对应的字符。

C 语言提供了不同的写法（其实采用不同进制），用来表示字符的整数号码。
* `\101`: 以八进制值表示一个字符，斜杠后面需要三个数字。
* `\x41`: 以十六进制值表示一个字符，`\x`后面是十六进制整数。
* `\u00A0`: 以 Unicode 码点表示一个字符（不适用于 ASCII 字符，能够表示的范围是`00A0 ~ FFFF`），码点以十六进制表示，`\u`后面需要`四个字符`。
* `\U00010000`: 以 Unicode 码点表示一个字符（不适用于 ASCII 字符，能够表示的范围是`00010000 ~ 0010FFFF`），码点以十六进制表示，`\U`后面需要`八个字符`。
```c
int main(void) {
    printf("AB\n");         // AB
    printf("\101\102\n");   // AB
    printf("\x41\x42\n");   // AB
    printf("\u8D85\n");     // 超
    printf("\U00100000\n"); // 􀀀
}
```

## 多字节字符的表示方法
C 语言预设只有基本字符才能使用字面量表示，其它字符都应该使用码点表示，并且当前系统必须支持该码点的编码方式。

基本字符，指的是所有可打印的 ASCII 码字符，但是`@`、`$`、<code>`</code>这三个字符可以使用码点表示。
```c
int main(void) {
    printf("\u0024\u0040\u0060\n");
}
// $@`
```
其它 ASCII 字符不能使用码点表示，上文有说到码点小于`A0`的字符。

C 语言允许使用`u8`前缀，对多字节字符串指定编码方式为 UTF-8。
```c
int main(void) {
    setlocale(LC_ALL, "");  // 切换执行环境到系统的本地化语言。
    char* s = u8"春天";
    printf("%s\n", s);
}
// 春天
```

一旦字符串里面包含多字节字符，那字符串字节数与字符数不再一一对应。
```c
int main(void) {
    setlocale(LC_ALL, "");
    char* s = "春天";
    printf("%d\n", strlen(s));
}

// 6
```
上面示例中，字符串`s`只包含两个字符，但是`strlen()`返回`6`，表示这两个字符占用 6 个字节。

C 语言一些字符串函数只对单字节字符有效，对于多字节字符都会失效。比如`strtok()`、`strchr()`、`strspn()`、`toupper()`、`tolower()`、`isalpha()`。

## 宽字符
多字节字符，每个字符的字节宽度是可变的。

C 语言还提供了确定宽度的多字节字符存储方式，称为宽字符。即每个字符占用的字节数是固定的，要么是 2 个字节，要么是 4 个字节。

宽字符的数据类型定义为`wchar_t`，属于整数类型的别名。

宽字符的字面量必须加上前缀“L”，否则 C 语言会把字面量当作窄字符类型处理。
```c
int main(void) {
    setlocale(LC_ALL, "");

    wchar_t c = L'牛';   // 单引号表示宽字符。
    printf("%lc\n", c);
    wchar_t* s = L"春天"; // 双引号表示宽字符串。
    printf("%ls\n", s);
}
```
宽字符相关的函数定义在头文件`wchar.h`里面。

## 多字节字符处理函数
1. `mblen()`
返回一个多字节字符第一个字符占用的字节数，原型定义在`stdlib.h`里面。
```c
int mblen(const char* mbstr, size_t n);
```
第一个参数就是多字节字符指针；
第二个参数是需要检查的字节数，不能大于当前系统单个字符占用的最大字节。
```c
int main(void) {
    setlocale(LC_ALL, "");

    char* mbs1 = "abc";
    printf("%d\n", mblen(mbs1, MB_CUR_MAX));    // 1
    char* mbs2 = "春天";
    printf("%d\n", mblen(mbs2, MB_CUR_MAX));    // 3
}
```
2. `wctomb()`
作用是将宽字符转为多字节字符，原型定义在`stdlib.h`里面。
```c
int wctomb(char* s, wchar_t, wc);
```
第一个参数是作为目标的多字节字符数组；
第二个参数是需要转换的一个宽字符。
返回值是多字节字符串占用的字节数，失败返回 -1。
```c
int main(void) {
    setlocale(LC_ALL, "");

    wchar_t wc = L'牛';
    char mbStr[10] = "";

    int nBytes = 0;
    nBytes = wctomb(mbStr, wc);
    printf("%d\n", nBytes);     // 3
    printf("%s\n", mbStr);      // 牛
}
```
3. `mbtowc()`
作用是将多字节转换为宽字符，原型定义在`stdlib.h`里面。
```c
int mbtowc(wchar_t, wchar, const char* mbchar, size_t count);
```
4. `wcstombs()`
作用是将宽字符串转换位多字节字符串。原型定义在`stdlib.h`里面。
```c
int wcstombs(char* mbstr, const wchar_t* wcstr, size_t count);
```

5. `mbstowcs()`
作用是将多字节字符串转换为宽字符串。原型定义在`stdlib.h`里面。
```c
int mbstowcs(wchar_t*, wcstr, char* mbstr, size_t count);
```

## 来源
* [https://wangdoc.com/clang/multibyte.html](https://wangdoc.com/clang/multibyte.html)
* [https://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html](https://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html)
