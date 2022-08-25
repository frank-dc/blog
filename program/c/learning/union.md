# Union 结构
- [Union 结构](#union-结构)
  - [简介](#简介)
  - [总结](#总结)
  - [来源](#来源)

## 简介
C 语言提供`union`结构，用来自定义可以灵活变更的数据结构。

它内部可以定义各种属性，但是同一时间只能有一个属性，因为所有属性都保存在同一个内存地址，后面写入的属性会覆盖前面的属性。

```c
union quantity {
    short count;
    float weight;
    float volume;
};

// 赋值写法一
union quantity q;
q.count = 5;

// 赋值写法二
union quantity q = {.count=5};

// 赋值写法三
union quantity q = {5};
```
赋值写法三不指定属性名，会赋值给第一个属性。

## 总结
* `union`结构只能取一个值，即最后赋值的属性。
* `union`结构占用的内存长度，等于内部占用内存最长的属性的长度。
* 所以，`union`结构主要就是节省空间。

## 来源
* [https://wangdoc.com/clang/union.html](https://wangdoc.com/clang/union.html)