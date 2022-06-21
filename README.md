# 选择策略
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

# 控制并行进程数
* 你可以在配置文件ansible.cfg设置数字。
```
[defaults]
forks = 30
```
* 或者通过命令行`-f 30`传递。
```
  -f FORKS, --forks=FORKS
                        specify number of parallel processes to use
                        (default=5)
```

# 使用关键字控制执行
* `serial` 可以设置每一次管理的主机数量。

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
- command: /opt/application/upgrade_db.py
  delegate_to: web01.example.org
```

* 影响剧本执行的[其他一些关键字](https://docs.ansible.com/ansible/latest/reference_appendices/playbooks_keywords.html)`ignore_errors`、`ignore_unreachable`、`any_errors_fatal`、`max_fail_percentage（适用于linear strategy）`

# 关键字timeout
ansible版本2.10及以上支持`timeout`关键字，设置任务执行超时时间，可以解决playbook执行过程中hang住无返回的问题。

# 条件判断 when

# 模块wait_for、关键字action、local_action

# 性能优化（单独写还是放在此处）
