# 基础
- [基础](#基础)
  - [环境变量设置](#环境变量设置)
  - [常用的二进制文件介绍](#常用的二进制文件介绍)
  - [引用](#引用)

## 环境变量设置
从[官网](https://www.oracle.com/java/technologies/downloads/)上下载较新的稳定的版本。

以Mac/Linux为例
```shell
$ vim /etc/profile
# java
export JAVA_HOME=`/usr/libexec/java_home -v 18`
export PATH=$JAVA_HOME/bin:$PATH
$ java -version
openjdk version "18.0.2" 2022-07-19
OpenJDK Runtime Environment Homebrew (build 18.0.2+0)
OpenJDK 64-Bit Server VM Homebrew (build 18.0.2+0, mixed mode, sharing)
```

## 常用的二进制文件介绍
* `java` - 运行 java 程序，就是启动 JVM，JVM 执行编译后的代码。
* `javac` - 读取 java 声明（源码文件）并将它们编译成 class 文件（字节码文件）。
* `jar` - 为 class 文件和其资源文件创建归档，
* `javadoc` - 从 java 源码文件提取 API 文档生成 HTML 格式。
* `javap` - 反汇编一个或多个 class 文件。
* `jdb` - java 调试器，发现和修复 java 平台语言的bug。
* `jstack` - 打印指定 java 进程的线程的堆跟踪。
* `jps` - 列出系统上运行的 JVM。
* `jstat` - 显示 JVM 的性能统计信息。
* `jstatd` - 是一个 RMI 服务器应用程序，用来检测 JVM 的创建和终止。
* `jwebserver` - 启动 java 简单的 web 服务器。
* `jshell` - 交互的 java 编译器。


## 引用
* [https://docs.oracle.com/en/java/javase/19/docs/specs/man/jshell.html](https://docs.oracle.com/en/java/javase/19/docs/specs/man/jshell.html)
* [https://www.liaoxuefeng.com/wiki/1252599548343744/1280507291631649](https://www.liaoxuefeng.com/wiki/1252599548343744/1280507291631649)
