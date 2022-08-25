# struct 结构
- [struct 结构](#struct-结构)
  - [简介](#简介)
  - [声明和初始化](#声明和初始化)
  - [struct 结构占用空间](#struct-结构占用空间)
  - [struct 的复制](#struct-的复制)
  - [struct 指针](#struct-指针)
  - [struct 的嵌套](#struct-的嵌套)
  - [位字段](#位字段)
  - [弹性数组成员](#弹性数组成员)
  - [来源](#来源)

## 简介
C 语言内置的数据类型，除了最基本的几种[原始类型](type.md)，只有[数组](array.md)属于复合类型，可以同时包含多个值（但是类型必须相同）。

但是实际使用中，需要更灵活更强大的复合类型。
* 复杂的物体需要使用多个变量描述，这些变量都是相关的，最好有某种机制将它们联系起来。
* 某些函数需要传入多个参数，如果一个个按照顺序传入，非常麻烦，最好能组合成一个复合结构传入。

为了解决上述需求，C 语言提供了`struct`关键字，允许自定义复合数据类型，将不同类型的值组合在一起。

C 语言没有其他语言对象（object）和类（class）的概念，`struct`结构很大程度上提供了对象和类的功能。

## 声明和初始化
* struct 数据类型常规自定义、变量声明和属性赋值。
```c
// 常规自定义 struct。
struct turtle {
    char * name;
    int age;
};

// 常规声明自定义类型变量，不要忘记在类型前面加上 struct 关键字。不能写成 turtle t1
struct turtle t1;

// 赋值写法一
t1.name = "Alvin";
t1.age = 8;

// 赋值写法二，注意大括号里值的顺序必须与 struct 类型声明时属性的顺序一致，否则要指定属性名。
struct turtle t2 = {"Simon", 10};

// 赋值写法三
struct turtle t3 = {.name="Theadore", .age=5};
```

* struct 数据类型定义和变量的声明语句，可以合并为一个语句。
```c
struct book {
    char title[500];
    char author[100];
    float value;
} b1;

// 如果类型标识符 book 后面不再用到，可以省略，声明一个匿名数据类型。
struct {
    char title[500];
    char author[100];
    float value;
} b1;

// 在声明变量的同时，可以对变量赋值。
struct {
    char title[500];
    char author[100];
    float value;
} b1 = {"Harry Potter", "J. K. Rowling", 10.0},
  b2 = {"Cancer Ward", "Aleksandr Solzhenitsyn", 8.85};
```

* 使用`typedef`命令可以为 struct 结构指定一个别名。
```c
typedef struct cell_phone {
    int cell_no;
    float minutes_of_charge;
} phone;

phone p = {55551234, 5.0};
```
`phone`就是`struct cell_phone`的别名。

* 指针变量也可以指向`struct`结构。
```c
struct book {
    char title[500];
    char author[100];
    float value;
}* b1;

// 等同于
struct book {
    char title[500];
    char author[100];
    float value;
};
struct book* b1;
```

* `struct`结构可以作为数组成员。
```c
struct cell_phone phones[100];
phones[0].cell_no = 23984285;
phones[0].minutes_of_charge = 10.0;
```
上面示例声明了一个有100个成员的数组`phones`，每个成员都是自定义类型`cell_phone`的实例。

## struct 结构占用空间
`struct`结构占用的存储空间，不是各个属性存储空间的总和，而是最大内存占用属性的存储空间的背书，其它属性会添加空位与之对齐。
```c
struct foo {
    int a;          // 占 4 个字节
    char* b;        // 占 8 个字节
    char c;         // 占 1 个字节
};

printf("%d\n", sizeof(struct foo));     // 24   (8 * 3 = 24)
```
多出来的存储空间，都采用空位填充，所以上面的`struct foo`真实的结构是下面这样。
```c
struct foo {
    int a;          // 占 4 个字节
    char pad1[4];   // 填充 4 个字节
    char* b;        // 占 8 个字节
    char c;         // 占 1 个字节
    char pad2[7];   // 填充 7 个字节
};
```
为什么浪费这么多空间进行内存对齐呢？为了加快读写速度，把内存占用划分成等长的区块，就可以快速在 struct 结构体中定位到每个属性的起始位置。

由于这个特性，在有必要的情况下，定义 struct 结构体时，可以采用存储空间提增的顺序定义每个属性，这样能节省一些空间。
```c
// 写法一
struct foo {
    int a;
    char* b;
    char c;
};
printf("%d\n", sizeof(struct foo));     // 24

// 写法二
struct foo {
    char c;
    int a;
    char* b;
};
printf("%d\n", sizeof(struct foo));     // 16

// 写法三，占用空间最大的放在最后
struct foo {
    int a;
    char c;
    char* b;
};
printf("%d\n", sizeof(struct foo));     // 16
```

## struct 的复制
赋值运算符（`=`）可以将`struct`结构每个属性的值，一模一样复制一份，拷贝给另一个`struct`变量（必须是同一个struct变量类型）。

注意跟数组类型区分开来，使用赋值运算运算符复制数组，不会复制数据，只会共享地址。
```c
struct cat {
    char name[30];  // 必须定义成字符数组，不能定义成字符指针。
//        char* name;
    short age;
} a, b;

strcpy(a.name, "Hula");
a.age = 5;

b = a;      // 此处复制，分配新的内存空间给 b 。
b.name[0] = 'M';

printf("%s\t%d\n", a.name, a.age);      // Hula	5
printf("%s\t%d\n", b.name, b.age);      // Mula	5
```

## struct 指针
如果将 struct 变量传入函数，函数内部得到的是一个原始值的副本，函数内部改变副本不会影响原始数据。
```c
struct cat {
    char name[30];
    short age;
};

void happy(struct cat t) {
    t.age = t.age + 1;
};

int main() {
    struct cat myCat = {"Alvin", 9};
    happy(myCat);
    printf("%d\n", myCat.age);  // 9
}
```
如果要改变 struct 变量的原始数据，可以将 struct 变量的指针传入函数，通过指针来修改 struct 属性。
```c
// 上述改变成如下
void happy(struct cat* t) {
    (*t).age = (*t).age + 1;
}

happy(&myCat);
```
上述示例中，`(*t).age`不能写成`*t.age`，因为`.`优先级高于`*`。

C 语言引入了一个新的箭头运算符`->`，可以从 struct 变量指针上直接获取属性，增强了代码可读性。
```c
void happy(struct cat* t) {
    t->age = t->age + 1;
}
```

## struct 的嵌套
`struct`结构的成员可以是另一个`struct`结构。
```c
struct species {
    char* name;
    int kinds;
};

struct fish {
    char* name;
    int age;
    struct species breed;
};
```
上面示例中，`fish`的属性`bread`是另一个 struct 结构`species`。

赋值的时候有多种写法。
```c
// 写法一
struct fish shark = {"shark", 8, {"Selachimorpha", 500}};

// 写法二
struct species myBread = {"Selachimorpha", 500};
struct fish shark = {"shark", 8, myBread};

// 写法三
struct fish shark = {
    .name="shark",
    .age=8,
    .bread={"Selachimorpha", 500}
};

// 写法四
struct fish shark = {
    .name="shark",
    .age=8,
    .bread.name="Selachimorpha",
    .bread.kind=500
};
```

对字符数组赋值要使用`strcpy()`函数，不能是用赋值运算符`=`。
```c
struct name {
    char first[50];
    char last[50];
};

struct student {
    struct name name;
    short age;
    char sex;
} stu1;

strcpy(stu1.name.first, "Harry");
strcpy(stu1.name.last, "Potter");

// 等同于
struct name myName = {"Harry", "Potter"};
stu1.name = myName;
```

`struct`结构内部不仅可以引用其他结构，还可以自我引用，即结构内部引用当前结构。
```c
struct node {
    int data;
    struct node* next;
};
```
上面示例中的`node`结构的`next`属性，就是指向另一个`node`实例的指针。可以使用这个结构自定义一个数据链表。
```c
struct node* head;

// 生成一个三个节点的链表
head = malloc(sizeof(struct node));

head->data = 11;
head->next = malloc(sizeof(struct node));

head->next->data = 22;
head->next->next = malloc(sizeof(struct node));

head->next->next->data = 33;
head->next->next->next = NULL;

// 遍历这个链表
for (struct node* cur = head; cur != NULL; cur = cur->next) {
    printf("%d\n", cur->data);
}
```
## 位字段
`struct`还可以用来定义二进制位组成的数据结构，称为`位字段`（bit field）。对于操作底层的二进制数据非常有用。
```c
struct {
    unsigned int a:1;
    unsigned int b:1;
    unsigned int c:1;
    unsigned int d:1;
} synth;

synth.a = 0;
```
上面示例中，每个属性后面的`:1`，表示指定这些属性只占用一个二进制位，所以这个结构一共占用四个二进制位。

> 定义二进制位时，各个属性只能是整数类型。

## 弹性数组成员
很多时候，不能事先确定数组到底有多少个成员。如果声明数组的时候，事先给出一个很大的成员数，就会很浪费空间。C 语言提供了一个解决方法，叫做弹性数组成员（flexible array member）。

弹性数组成员有一些专门的规则。首先，弹性成员的数组，必须是 struct 结构的最后一个属性。另外，除了弹性数组成员，struct 结构必须至少还有一个其他属性。
```c
struct vstring {
  int len;
  char chars[];
};

struct vstring vstr = malloc(sizeof(struct vstring) + n * sizeof(char));
str->len = n;
```

## 来源
* [https://wangdoc.com/clang/struct.html](https://wangdoc.com/clang/struct.html)
