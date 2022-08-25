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
