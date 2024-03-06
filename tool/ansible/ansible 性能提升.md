# ansible 性能提升
- [ansible 性能提升](#ansible-性能提升)
  - [关闭 fact](#关闭-fact)
  - [开启 SSH pipelining](#开启-ssh-pipelining)
  - [开启 SSH 长链接](#开启-ssh-长链接)
  - [设置 fact 缓存](#设置-fact-缓存)
  - [禁用 SSH 主机秘钥检测](#禁用-ssh-主机秘钥检测)

## 关闭 fact
如果不需要获取主机的 fact 数据的话，可以关闭获取 fact 数据功能，在 playbook 文件中配置`gather_facts: False`。
```yaml
- name: test play
  hosts: webservers
  gather_facts: False
  tasks:
  # ...
```

## 开启 SSH pipelining
开启 pipelining 可以减少在远程主机上执行模块所需的 SSH 操作数。如果使用 sudo 的话，要在 /etc/sudoers 禁用`requiretty`。

`vim /etc/ansible/ansible.cfg`
```bash
pipelining = True
```

## 开启 SSH 长链接
开启此参数的ssh长连接功能后，在会话过期前会一直建立连接，且通过SSH连接过的设备都会在"~/.ansible/cp"目录下生成一个socket文件，每个会话对应生成一个socket文件。

`vim /etc/ansible/ansible.cfg`
```bash
ssh_args = -C -o ControlMaster=auto -o ControlPersist=600s
```
ControlPersist 设置长链接保持时间为600s。

## 设置 fact 缓存
* json 文件缓存
```bash
gathering = smart
fact_caching = json
fact_caching_connection = /tmp/ansible_fact_cache
```
* redis 缓存
```bash
gathering = smart
fact_caching = redis
fact_caching_connection = localhost:6379:0
```

## 禁用 SSH 主机秘钥检测
`vim /etc/ansible/ansible.cfg`
```
host_key_checking = False
```

