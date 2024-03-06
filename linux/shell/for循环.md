# for循环
- [for循环](#for循环)
  - [定义一个数组](#定义一个数组)
  - [标准的for循环](#标准的for循环)
  - [for...in 格式](#forin-格式)
    - [获取元素](#获取元素)
    - [获取索引](#获取索引)

## 定义一个数组
fruits=(apple banana cherry)

## 标准的for循环
```
for(初始化语句;判断条件语句;控制条件语句) {
    循环体语句;
}
```
```shell
# ${#fruits[@]} 可以获取数组的长度

for((i=0; i<${#fruits[@]}; i++));
do 
    echo ${fruits[i]};
done
```

## for...in 格式
### 获取元素
```shell
# ${fruits[@]} 获取数组所有元素，等同于${fruits[*]}
for item in ${fruits[@]}
do
    echo $item
done
```

### 获取索引
```shell
# ${!fruits[@]} 获取数组所有索引
for i in ${!fruits[@]}
do
    echo ${fruits[i]}
done
```
