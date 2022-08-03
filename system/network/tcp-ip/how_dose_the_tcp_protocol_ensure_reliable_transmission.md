# TCP 协议如何保证可靠传输？
- [TCP 协议如何保证可靠传输？](#tcp-协议如何保证可靠传输)
  - [TCP 协议保证可靠传输的措施](#tcp-协议保证可靠传输的措施)
  - [ARQ 协议（Automatic Repeat-reQuest)](#arq-协议automatic-repeat-request)
  - [拥塞控制协议](#拥塞控制协议)

## TCP 协议保证可靠传输的措施
* 发送数据报时，将数据报切割成适合大小
* 发送放给每一个数据报编号，接收方对数据报排序
* 检验和
* 丢弃重复数据报
* 流量控制
* 拥塞控制
* ARQ 协议
* 超时重传

## ARQ 协议（Automatic Repeat-reQuest)
* 停止等待 ARQ 协议
* 连续 ARQ 协议

## 拥塞控制协议
* 慢开始
* 拥塞避免
* 快重传与块恢复

> https://segmentfault.com/a/1190000022944999