# 控制 ansible playbook 执行
- [控制 ansible playbook 执行](#控制-ansible-playbook-执行)
  - [选择策略](#选择策略)
  - [控制并行进程数](#控制并行进程数)
  - [使用关键字控制执行](#使用关键字控制执行)
  - [关键字 timeout](#关键字-timeout)
  - [条件判断 when](#条件判断-when)
  - [模块wait_for](#模块wait_for)

## 选择策略
有三种策略可供选择，分别是[linear strategy（默认策略）](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/linear_strategy.html#linear-strategy)、[debug strategy](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/debug_strategy.html#debug-strategy)、[free strategy](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/free_strategy.html#free-strategy)。
* playbook中指定。
```yaml
---
- hosts: all
  strategy: free
  tasks:
  # ...
```
* 配置文件中ansible.cfg设置。
```
[defaults]
strategy = free
```

## 控制并行进程数
在单次任务上，可以控制多少并行节点执行任务，注意和`serial`区分。简言之，就是对每一个任务所有节点都要跑完，才能继续下一个任务。

可以在配置文件ansible.cfg设置数字。
```
[defaults]
forks = 30
```
或者通过命令行`-f 30`传递。
```
  -f FORKS, --forks=FORKS
                        specify number of parallel processes to use
                        (default=5)
```

> Story 1: `2 Tasks`, `10 nodes` with `forks =5`.

> Run the playbook only once,

> 1st task on first 5 nodes = 5s (node1, node2, node3, node4, node5)

> 1st task on second 5 nodes = 5s (node6, node7, node8, node9, node10)

> 2nd task on first 5 nodes = 5s (node1, node2, node3, node4, node5)

> 2nd task on second 5 nodes = 5s (node6, node7, node8, node9, node10)

> Total time taken for playbook = 20s

---

> Story 2: `2 Tasks`, `10 nodes` with `forks=5` and `serial =4`

> Run the playbook twice(maybe more),

> First run, 1st task = 5s (node1, node2, node3, node4)

> First run, 2nd task = 5s (node1, node2, node3, node4)

> Second run, 1st task = 5s (node5, node6, node7, node8)

> Second run, 2nd task = 5s (node5, node6, node7, node8)

> Third run, 1st task = 5s (node9, node10)

> Third run, 2nd task = 5s (node9, node10)

> Total time taken for playbook = 30s



## 使用关键字控制执行
`serial`在一次剧本上（可能有多个任务），可以控制多少并行节点执行任务。简言之，就是这一批次主机要跑完所有任务，下一批次主机才能跑。
 
[`forks`和`serial`区别可以参考此文档](https://medium.com/devops-srilanka/difference-between-forks-and-serial-in-ansible-48677ebe3f36)

每批次3台主机。
```yaml
---
- name: test play
  hosts: webservers
  serial: 3
  tasks:
  # ...
```
每批次占总主机的30%。
```yaml
---
- name: test play
  hosts: webservers
  serial: "30%"
  tasks:
  # ...
```
每批次指定主机数量。
```yaml
---
- name: test play
  hosts: webservers
  serial:
    - 1
    - 3
    - 6
  tasks:
  # ...
```
每批次指定占总主机数量的百分比。
```yaml
---
- name: test play
  hosts: webservers
  serial:
    - "10%"
    - "50%"
    - "100%"
  tasks:
  # ...
```
混合指定每批次主机数量以及百分比。
```yaml
---
- name: test play
  hosts: webservers
  serial:
    - 1
    - 5
    - "20%"
  tasks:
  # ...
```
* `throttle` 在 task 和 block 级别设置线程数量。
```yaml
tasks:
- command: /path/to/cpu_intensive_command
  throttle: 1
```
* `order` 控制主机运行的顺序。

选择项有：
**inventory**（默认）、**reverse_inventory**、**sorted**、**reverse_sorted**、**shuffle**（每次都是随机排序）
```yaml
---
- name: test play
  hosts: webservers
  order: sorted
  tasks:
  # ...
```
* `run_once` 在每一批次中，任务只在一台主机上运行，并且在`free strategy`中不支持（版本号：ansible-playbook 2.10.17）。
```yaml
---
# ...
  tasks:
    # ...
    - command: /opt/application/upgrade_db.py
      run_once: true
    # ...
```
* `delegate_to` 指定特定的主机执行任务。
```yaml
---
# ...
  tasks:
    - command: rsync -a /path/to/source {{ inventory_hostname }}:/path/to/target
      delegate_to: 127.0.0.1
```
使用local_action可以达到delegate_to同样的效果
```yaml
---
# ...
  tasks:
    - name: Recursively copy files from management server to target
      local_action: ansible.builtin.command rsync -a /path/to/files {{ inventory_hostname }}:/path/to/target/
```

* 影响剧本执行的[其他一些关键字](https://docs.ansible.com/ansible/latest/reference_appendices/playbooks_keywords.html)`ignore_errors`、`ignore_unreachable`、`any_errors_fatal`、`max_fail_percentage（适用于linear strategy）`

## 关键字 timeout
ansible版本2.10及以上支持在[Play、Role、Block、Task]设置`timeout`关键字，设置任务执行超时时间，可以解决playbook执行过程中hang住无返回的问题。

## 条件判断 when
* 在 playbook 里，根据 fact 里面的值，变量，或先前任务的输出结果，你或许想要执行不同的任务，或者有不同的目标。
* 根据其它变量的值得到某些变量的值。
* 根据主机是否符合某些条件匹配出新的主机组。

使用样例
```yaml
tasks:
  - name: Shut down CentOS 6 and Debian 7 systems
    ansible.builtin.command: /sbin/shutdown -t now
    when: (ansible_facts['distribution'] == "CentOS" and ansible_facts['distribution_major_version'] == "6") or
          (ansible_facts['distribution'] == "Debian" and ansible_facts['distribution_major_version'] == "7")
```
详情见 -> [Conditionals](https://docs.ansible.com/ansible/latest/user_guide/playbooks_conditionals.html)

## 模块wait_for
* 轮训端口（host:port)。
* 查找文件是否存在（path)。
* 在文件或socket连接中匹配字符串是否存在（search_regex）。
* deplay: 在开始轮训之前等待的时间。
* timeout：整个过程等待的时间。
* state: 根据以下取值。
> 检查文件或搜索字符串：present、absent。
>
> 检查端口：started、stopped、drained。

使用样例
```yaml
- name: Wait for port 8000 to become open on the host, don't start checking for 10 seconds
  ansible.builtin.wait_for:
    port: 8000
    delay: 10
```

详情见 -> [ansible.builtin.wait_for module ](https://docs.ansible.com/ansible/latest/collections/ansible/builtin/wait_for_module.html#id1)

