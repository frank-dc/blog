## 问题1：出现 00~ 和 1~ 一般是由于 终端误解释了按键/粘贴事件为“功能键”操作

1. 在 shell 启动脚本中禁用 Bracketed Paste

在 ~/.bashrc 或 ~/.zshrc 添加：
```
bind 'set enable-bracketed-paste off'
```
然后执行：
```
source ~/.bashrc   # 或 ~/.zshrc
```

2. iTerm2 设置中关闭 bracketed paste
iTerm2 默认启用了 bracketed paste 支持：
* 打开 iTerm2 > Preferences > Profiles > Terminal
* 找到 "Terminal may enable paste bracketing"
* 取消勾选
