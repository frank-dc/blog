# technical summary docs
- [technical summary docs](#technical-summary-docs)
  - [tool](#tool)
    - [1. ansible](#1-ansible)
    - [2. cicd](#2-cicd)
  - [OS](#os)
    - [1. linux](#1-linux)
    - [2. cpu（处理器）](#2-cpu处理器)
    - [3. mem（内存）](#3-mem内存)
    - [4. network（网络）](#4-network网络)
      - [TCP/IP](#tcpip)
    - [5. store（存储）](#5-store存储)
      - [Redis](#redis)
    - [6. IO](#6-io)
  - [Program](#program)
    - [1. shell](#1-shell)
    - [2. python](#2-python)
      - [算法](#算法)
      - [闭包](#闭包)
      - [爬虫](#爬虫)
    - [3. golang](#3-golang)
    - [4. c](#4-c)
    - [5. java](#5-java)

## tool 
### 1. ansible
* [ansible 控制剧本执行的一些策略以及关键词](tool/ansible/controlling_playbook_execution.md)
* [ansible 常见性能优化](tool/ansible/performance_improvement.md)
* [ansible tags 使用](tool/ansible/use_of_ansible_tags.md)

### 2. cicd
* [gitlab 升级](tool/cicd/gitlab_upgrade.md)
* [jenkins 环境变量](tool/cicd/jenkins_variables.md)


## OS or Virtualization
### 1. linux
* [如何创建一个 rpm 包？](system/linux/how_to_create_a_rpm_package.md)

### 2. cpu（处理器）

### 3. mem（内存）

### 4. network（网络）
* [Docker 容器网络配置](system/network/docker_network_configuration.md)

#### TCP/IP
* [TCP 协议如何保证可靠传输？](system/network/tcp-ip/how_dose_the_tcp_protocol_ensure_reliable_transmission.md)
* [TCP 和 UDP 的比较](system/network/tcp-ip/the_difference_of_tcp_and_udp.md)

### 5. store（存储）
#### Redis
* [Redis 为什么这么快？](system/store/redis/why_is_redis_so_fast.md)

### 6. IO
* [socket 网络模型的 I/O 多路复用](system/io/io_multiplexing_for_the_socket.md)

## Program
* [计算机对浮点数的表示](program/understanding_float_point.md)

### 1. shell
* [set 命令](program/shell/the_use_of_set_command.md)

### 2. python
#### 算法
> 排序
* [快速排序](program/python/algorithm/sort/quick_sort)
* [冒泡排序](program/python/algorithm/sort/dubble_sort)
* [选择排序](program/python/algorithm/sort/selection_sort)
* [插入排序](program/python/algorithm/sort/insertion_sort)

> 斐波拉契
* [斐波拉契](program/python/algorithm/fibonacci.py)

#### 闭包
* [装饰器](program/python/closure/decorator.py)

#### 爬虫
* [爬电影top250](program/python/crawler/static_web/movies_top_250.py)
### 3. golang

### 4. c
* [C 语言学习](program/c/learning/README.md)

### 5. java
* [java 学习](program/java/learning/README.md)
* [learnjava](program/java/learnjava)