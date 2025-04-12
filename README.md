# technical summary docs
- [technical summary docs](#technical-summary-docs)
  - [Linux](#linux)
    - [1. Shell](#1-shell)
    - [2. CPU](#2-cpu)
    - [3. Memory](#3-memory)
    - [4. Network](#4-network)
      - [TCP/IP](#tcpip)
    - [5. Store](#5-store)
      - [Redis](#redis)
    - [6. IO](#6-io)
    - [7. Package](#7-package)
  - [Virtualization](#virtualization)
    - [Docker](#docker)
    - [K8S](#k8s)
  - [Tools](#tools)
    - [1. Ansible](#1-ansible)
    - [2. CI/CD](#2-cicd)
  - [Program](#program)
    - [1. 基础](#1-基础)
    - [2. Python](#2-python)
      - [算法](#算法)
      - [闭包](#闭包)
      - [爬虫](#爬虫)
    - [3. C/C++](#3-cc)
    - [4. Java](#4-java)


## Linux
### 1. Shell
* [set 命令](program/shell/set%20%E5%91%BD%E4%BB%A4%E7%9A%84%E4%BD%BF%E7%94%A8.md)

### 2. CPU
* [如何排查CPU持续飙高？](linux/cpu/%E5%A6%82%E4%BD%95%E6%8E%92%E6%9F%A5CPU%E6%8C%81%E7%BB%AD%E9%A3%99%E9%AB%98.md)

### 3. Memory

### 4. Network
#### TCP/IP
* [TCP 协议如何保证可靠传输？](linux/network/TCP%20协议如何保证可靠传输.md)
* [TCP 和 UDP 的比较](linux/network/TCP%20和%20UDP%20的比较.md)

### 5. Store
#### Redis
* [Redis 为什么这么快？](linux/store/redis/Redis%20%E4%B8%BA%E4%BB%80%E4%B9%88%E8%BF%99%E4%B9%88%E5%BF%AB.md)

### 6. IO
* [socket 网络模型的 I/O 多路复用](linux/io/socket%20%E7%BD%91%E7%BB%9C%E6%A8%A1%E5%9E%8B%E7%9A%84%20IO%20%E5%A4%9A%E8%B7%AF%E5%A4%8D%E7%94%A8.md)
* [DMA拷贝](linux/io/DMA拷贝.md)
* [零拷贝技术](linux/io/零拷贝技术.md)

### 7. Package
* [如何创建一个 rpm 包？](linux/package/%E5%A6%82%E4%BD%95%E5%88%9B%E5%BB%BA%20RPM%20%E5%8C%85.md)


## Virtualization
### Docker
* [Docker 容器网络配置](virtualization/docker/Docker%20%E5%AE%B9%E5%99%A8%E7%BD%91%E7%BB%9C%E9%85%8D%E7%BD%AE.md)

### K8S

## Tools
### 1. Ansible
* [Ansible 控制剧本执行的一些策略以及关键词](tool/ansible/%E6%8E%A7%E5%88%B6%20ansible%20playbook%20%E6%89%A7%E8%A1%8C.md)
* [Ansible 常见性能优化](tool/ansible/ansible%20%E6%80%A7%E8%83%BD%E6%8F%90%E5%8D%87.md)
* [Ansible tags 使用](tool/ansible/ansible%20tags%20%E7%9A%84%E4%BD%BF%E7%94%A8.md)

### 2. CI/CD
* [Gitlab 升级](tool/cicd/gitlab%20%E5%8D%87%E7%BA%A7.md)
* [Jenkins 环境变量](tool/cicd/Jenkins%20%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F.md)


## Program
### 1. 基础
* [计算机对浮点数的表示](program/%E7%90%86%E8%A7%A3%E6%B5%AE%E7%82%B9%E6%95%B0.md)
* [原码、反码和补码](program/%E5%8E%9F%E7%A0%81%E3%80%81%E5%8F%8D%E7%A0%81%E5%92%8C%E8%A1%A5%E7%A0%81.md)
* [进程间通信](program/%E8%BF%9B%E7%A8%8B%E9%97%B4%E9%80%9A%E4%BF%A1.md)
* [Buffer和Cache的区别](program/Buffer和Cache的区别.md)

### 2. Python
#### 算法
> 排序
* [快速排序](program/python/algorithm/sort/quick_sort)
* [冒泡排序](program/python/algorithm/sort/bubble_sort)
* [选择排序](program/python/algorithm/sort/selection_sort)
* [插入排序](program/python/algorithm/sort/insertion_sort)

> 斐波拉契
* [斐波拉契](program/python/algorithm/fibonacci.py)

#### 闭包
* [装饰器](program/python/closure/decorator.py)

#### 爬虫
* [爬电影top250](program/python/crawler/static_web/movies_top_250.py)

### 3. C/C++
* [C 语言学习](program/c/learning/README.md)

### 4. Java
* [Java 学习](program/java/learning/README.md)
* [learnjava](program/java/learnjava)
