# ansible tags 的使用
- [ansible tags 的使用](#ansible-tags-的使用)
  - [常规使用](#常规使用)
  - [内置的几个 tags](#内置的几个-tags)
  - [特殊使用](#特殊使用)

## 常规使用
参考 [https://docs.ansible.com/ansible/latest/user_guide/playbooks_tags.html#tag-inheritance-for-includes-blocks-and-the-apply-keyword](https://docs.ansible.com/ansible/latest/user_guide/playbooks_tags.html#tag-inheritance-for-includes-blocks-and-the-apply-keyword)

## 内置的几个 tags
* `--tags: all` - 执行所有任务，忽略 tags（默认行为）。
* `--tags: tagged` - 只执行有标签的任务。
* `--tags: untagged` - 只执行未打标签的任务。
* `--tags: always`、`--tags: never` - 给task、play打上`always`或`never`标签，always 表示会始终运行，除非使用`--skip-tags always`；never 表示会忽略该任务，除非特别请求`--tags never`。
```yml
tasks:
  - name: Run the rarely-used debug task
    ansible.builtin.debug:
     msg: '{{ showmevar }}'
    tags: [ never, debug ]
 ```

## 特殊使用
* 对`include_tasks`打 tag 只会对`include_tasks`任务本身生效，并不会对其包含的任务生效。
```yaml
---
- name: Test
  include_tasks: test.yml
  tags:
    - test
```
上面示例中，只会执行 include_tasks 这一任务，并不会执行 test.yml 里面的任务。
```text
TASK [include_tasks] *********************************************************************************************************************************
included: ./main.yml for XXX
```
要想对 test.yml 里面的任务也生效，需要使用`apply`参数。
```yaml
---
- name: Test
  include_tasks: 
    file: test.yml
    apply:
      tags:
        - test
  tags:
    - test
# 或者
- name: Test
  include_tasks: 
    file: test.yml
    apply:
      tags:
        - test
  tags:
    - always
```


如果要对include_tasks里面的任务也使用tag，那么include_tasks任务本身必须打上`always` tag。
```shell
$ cat main.yml
---
- hosts: localhost,10.129.120.2
  serial: 2
  gather_facts: false
  tasks:
    - debug:
        msg: task 1
      tags: t1                      # @1

    - include_tasks:
        file: install.yml
        apply:
          tags: install             # @2
      tags: [install]               # @3
      
$ cat install.yml
---
- debug:
    msg: task 2
  tags: t2                          # @4

- debug:
    msg: task 3
  tags: t3                          # @5
  
$ cat hosts
[test]
localhost
10.129.120.2
```

> story 1: 如果`@3`没有标签`always`。
```shell
$ ansible-playbook main.yml -i hosts --tags t3

PLAY [localhost,10.129.120.2] ************************************************************************************************************************

PLAY RECAP *******************************************************************************************************************************************
```

> story2: `@3`标签`always`。
```shell
$ cat main.yml
---
- hosts: localhost,10.129.120.2
  serial: 2
  gather_facts: false
  tasks:
    - debug:
        msg: task 1
      tags: t1

    - include_tasks:
        file: install.yml
        apply:
          tags: install
      tags: [install,always]

$ ansible-playbook main.yml -i hosts --tags t3

PLAY [localhost,10.129.120.2] ************************************************************************************************************************

TASK [include_tasks] *********************************************************************************************************************************
included: /home/ansible_user/frank.deng/ansible-test/install.yml for localhost, 10.129.120.2

TASK [debug] *****************************************************************************************************************************************
ok: [localhost] => {
    "msg": "task 3"
}
ok: [10.129.120.2] => {
    "msg": "task 3"
}

PLAY RECAP *******************************************************************************************************************************************
10.129.120.2               : ok=2    changed=0    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0
localhost                  : ok=2    changed=0    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0
```
