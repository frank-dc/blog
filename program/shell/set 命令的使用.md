# set 命令的使用
- [set 命令的使用](#set-命令的使用)
  - [设置shell的执行方式](#设置shell的执行方式)
  - [例外情况](#例外情况)
  - [小结](#小结)

## 设置shell的执行方式

* 遇到不存在的变量就会报错，并停止执行后面语句。
```shell
set -u
等价于
set -o nounset
```

* 在运行结果之前，先输出执行的命令。
```shell
set -x
等价于
set -o xtrace
```

* 只要脚本发生错误，就退出终止执行。
```shell
set -e
等价于
set -o errexit
```

* 只要一个命令失败，整个管道命令就失败，脚本终止执行。
```shell
set -o pipefail
```


## 例外情况
* 如果使用command || true， 使得该命令即使执行失败，脚本也不会终止执行。
* 不适用于管道命令（BASH会把最后一个子命令的返回值，作为整个命令的返回值。也就是说，只要最后一个子命令不失败，管道命令总是会执行成功）。


## 小结
建议放在所有BASH脚本的头部
```shell
set -eux
set -o pipefail
```