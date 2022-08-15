# Docker 容器网络配置
- [Docker 容器网络配置](#docker-容器网络配置)
  - [Docker 四种网络模式](#docker-四种网络模式)
    - [bridge 模式](#bridge-模式)
    - [container 模式](#container-模式)
    - [host 模式](#host-模式)
    - [none 模式](#none-模式)
  - [Docker 容器网络配置](#docker-容器网络配置-1)
  - [创建一个额外的自定义网桥，区别于 docker0](#创建一个额外的自定义网桥区别于-docker0)
  - [来源](#来源)

## Docker 四种网络模式
| 模式        | 配置                             | 说明                                                                      |
|:----------|:-------------------------------|:------------------------------------------------------------------------|
| host      | --network host                 | 容器和宿主机共享 Network namespace。                                             |
| container | --network container:NAME_OR_ID | 容器和另外一个容器共享 Network namespace。                                          |
| none      | --network none                 | 容器有独立的 Network namespace，但并没有对其进行任何网络配置。                                |
| bridge    | --network                      | 默认模式，主机上创建一个虚拟网桥 docker0，从 docker0 子网中分配 IP 给容器使用，同一宿主机之间通过容器的 IP 直接通信。 |

```shell
# docker network ls
NETWORK ID     NAME              DRIVER    SCOPE
c3c4e74aab0a   bridge            bridge    local
70fbb34728da   host              host      local
75e144e57a58   none              null      local
```

### bridge 模式
主机创建一个 `docker0` 虚拟网桥，启动容器时会连接到 `docker0` 虚拟网桥上，`docker0` 在子网中分配 IP 给容器使用，并设置 `docker0` 的 IP 地址为容器的默认网关。

在主机上创建一对虚拟网卡 veth pair 设备，一端放在容器中（命名为 eth0），另一端放在主机中（命名类似 vethxxx）。

![bridge](https://github.com/frank-dc/drawpics/blob/main/docker_network_bridge_mode.png?raw=true)

Docker 网桥是宿主机虚拟出来的，并不是真实存在的网络设备，外部网络是无法寻址到的，即外部网络无法通过 container-ip 访问到容器。

如果容器希望被外部访问到，可以通过映射容器端口到宿主机（端口映射），启动容器时通过`-p`或`-P`参数来启用。


### container 模式
新创建的容器和已经存在的一个容器共享一个 Network Namespace（共享 IP 和端口），而不是和宿主机共享。

![container](https://github.com/frank-dc/drawpics/blob/main/docker_network_container_mode.png?raw=true)

### host 模式
区别 container 模式，新创建的容器和宿主机共享一个 Network Namespace(共享 IP 和端口)，不会虚拟出自己的网卡和 IP。

使用 host 模式的容器可以直接使用宿主机的 IP 地址与外界通信，容器内部的服务端口也是使用宿主机的端口，不需要进行 NAT。host 模式的优势是网络性能较好，但是网络的隔离性不好。

![host](https://github.com/frank-dc/drawpics/blob/main/docker_network_host_mode.png?raw=true)

### none 模式
使用 none 模式，容器拥有自己的 Network Namespace，但是不会为 Docker 容器进行任何网络配置（即没有网卡、IP和路由等信息）。

![none](https://github.com/frank-dc/drawpics/blob/main/docker_network_none_mode.png?raw=true)

应用场景：
* 启动一个容器处理数据，比如转换数据格式。
* 一些后台的计算和处理任务。

## Docker 容器网络配置
可以借助 ip netns 命令来完成对 Network Namespace 的各种操作。
> 创建 Network Namespace 并查看。
```shell
# 创建
$ ip netns add ns0
# 查看
$ ip netns list
ns0
```
> 操作 Network Namespace。
```shell
# 查看新创建 Network Namespace 的网卡信息。
$ ip netns exec ns0 ip addr
1: lo: <LOOPBACK> mtu 65536 qdisc noop state DOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00

# 启用 lo 回环网卡。
$ ip netns exec ns0 ip link set lo up
# 或者
$ ip netns exec ns0 ifcofnig lo up
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host 
       valid_lft forever preferred_lft forever
$ ip netns exec ns0 ping 127.0.0.1
PING 127.0.0.1 (127.0.0.1) 56(84) bytes of data.
64 bytes from 127.0.0.1: icmp_seq=1 ttl=64 time=0.048 ms
64 bytes from 127.0.0.1: icmp_seq=2 ttl=64 time=0.065 ms
64 bytes from 127.0.0.1: icmp_seq=3 ttl=64 time=0.059 ms
^C
--- 127.0.0.1 ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 1999ms
rtt min/avg/max/mdev = 0.048/0.057/0.065/0.009 ms
```

> 引入 veth pair（Virtual Ethernet Pair）是为了在不同的 Network Namespace 直接进行通信。
```shell
# 创建 veth pair。
$ ip link add type veth
48: veth0@veth1: <BROADCAST,MULTICAST,M-DOWN> mtu 1500 qdisc noop state DOWN group default qlen 1000
    link/ether 96:d1:c6:2d:e2:50 brd ff:ff:ff:ff:ff:ff
49: veth1@veth0: <BROADCAST,MULTICAST,M-DOWN> mtu 1500 qdisc noop state DOWN group default qlen 1000
    link/ether ca:54:5c:58:08:dc brd ff:ff:ff:ff:ff:ff

# 将 veth0 加入到 ns0，veth1 加入到 ns1。(ns0、ns1 通过 ip netns add NAME 创建）
$ ip link set veth0 netns ns0
$ ip link set veth1 netns ns1

# 查看 ns0、ns1 IP 信息。
$ ip netns exec ns0 ip a
1: lo: <LOOPBACK> mtu 65536 qdisc noop state DOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
48: veth0@if49: <BROADCAST,MULTICAST> mtu 1500 qdisc noop state DOWN group default qlen 1000
    link/ether 96:d1:c6:2d:e2:50 brd ff:ff:ff:ff:ff:ff link-netnsid 1
$ ip netns exec ns1 ip a
1: lo: <LOOPBACK> mtu 65536 qdisc noop state DOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
49: veth1@if48: <BROADCAST,MULTICAST> mtu 1500 qdisc noop state DOWN group default qlen 1000
    link/ether ca:54:5c:58:08:dc brd ff:ff:ff:ff:ff:ff link-netnsid 0

# 启用 veth pair 并配置上 IP 地址。
$ ip netns exec ns0 ip link set veth0 up
$ ip netns exec ns0 ip addr add 172.17.0.10/24 dev veth0

$ ip netns exec ns1 ip link set veth1 up
$ ip netns exec ns1 ip addr add 172.17.0.11/24 dev veth1

# 查看 ns0、ns1 IP 信息。
$ ip netns exec ns0 ip a
1: lo: <LOOPBACK> mtu 65536 qdisc noop state DOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
48: veth0@if49: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default qlen 1000
    link/ether 96:d1:c6:2d:e2:50 brd ff:ff:ff:ff:ff:ff link-netnsid 1
    inet 172.17.0.10/24 scope global veth0
       valid_lft forever preferred_lft forever
    inet6 fe80::94d1:c6ff:fe2d:e250/64 scope link 
       valid_lft forever preferred_lft forever
$ ip netns exec ns1 ip a
1: lo: <LOOPBACK> mtu 65536 qdisc noop state DOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
49: veth1@if48: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default qlen 1000
    link/ether ca:54:5c:58:08:dc brd ff:ff:ff:ff:ff:ff link-netnsid 0
    inet 172.17.0.11/24 scope global veth1
       valid_lft forever preferred_lft forever
    inet6 fe80::c854:5cff:fe58:8dc/64 scope link 
       valid_lft forever preferred_lft forever
```

## 创建一个额外的自定义网桥，区别于 docker0
```shell
$ docker network create -d bridge --subnet "172.18.0.0/16" --gateway "172.18.0.1" mybr 
8fdd4ac33131fd890552462db08fb71d772c82d15b44e23e4a2fb1fb7199ee1e

$ docker network ls
NETWORK ID     NAME       DRIVER    SCOPE
c3c4e74aab0a   bridge     bridge    local
70fbb34728da   host       host      local
649ccc59b59e   minikube   bridge    local
8fdd4ac33131   mybr       bridge    local
75e144e57a58   none       null      local

$ docker run -it --name b1 --network mybr busybox
/ # ip a
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
62: eth0@if63: <BROADCAST,MULTICAST,UP,LOWER_UP,M-DOWN> mtu 1500 qdisc noqueue 
    link/ether 02:42:ac:12:00:02 brd ff:ff:ff:ff:ff:ff
    inet 172.18.0.2/16 brd 172.18.255.255 scope global eth0
       valid_lft forever preferred_lft forever
       
$ ip a
# ...
57: br-8fdd4ac33131: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default 
    link/ether 02:42:25:86:15:47 brd ff:ff:ff:ff:ff:ff
    inet 172.18.0.1/16 brd 172.18.255.255 scope global br-8fdd4ac33131
       valid_lft forever preferred_lft forever
63: veth1e16841@if62: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue master br-8fdd4ac33131 state UP group default 
    link/ether 06:e1:e0:32:93:63 brd ff:ff:ff:ff:ff:ff link-netnsid 3
```

## 来源
* [https://mp.weixin.qq.com/s/saivLvkF0watg2nHxrO5-Q](https://mp.weixin.qq.com/s/saivLvkF0watg2nHxrO5-Q)