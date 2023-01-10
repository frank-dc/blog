# 包
- [包](#包)
  - [简介](#简介)
  - [package 结构](#package-结构)

## 简介
java 语言中使用`package`解决命名冲突。一个类总是属于某个包，类名（比如`person`）只是一个简写，真正的完整的类名应该是`包名`.`类名`。

包可以是多层的，用`.`隔开，比如`java.util`。

> 注意，包没有父子关系，`java.util`和`java.util.zip`是不同的包，两者没有任何继承关系。

## package 结构

参考 [package](../src/package)