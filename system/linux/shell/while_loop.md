## while 循环
```shell
# 定义一个数组
fruits=(apple banana cherry)

i=0
while [ $i -lt ${#fruits[@]} ]
do
    echo ${fruits[i]}
    let i++
done
```
