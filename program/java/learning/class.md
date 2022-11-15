# 面向对象编程
- [面向对象编程](#面向对象编程)
  - [构造方法](#构造方法)
  - [方法重载](#方法重载)
  - [继承](#继承)
    - [super](#super)
    - [阻止继承](#阻止继承)
    - [向上转型和向下转型](#向上转型和向下转型)
    - [区分继承和组合](#区分继承和组合)
  - [多态](#多态)
  - [抽象类](#抽象类)
    - [面向抽象编程](#面向抽象编程)
  - [接口](#接口)
  - [静态属性（字段）和静态方法](#静态属性字段和静态方法)

## 构造方法
```java
public class Main {
    public static void main(String[] args) {
        Person alvin = new Person("Simon", 125);
        System.out.println(alvin.getName() + ", " + alvin.getAge());
    }
}

class Person {
    private String name;
    private int age;

    // 构造方法
    public Person(String name, int age) {
        this.name = name;
        if ( age < 0 || age > 100 ) {
            throw new IllegalArgumentException("invalid age value");
        } else {
            this.age = age;
        }
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
```

## 方法重载
一个类里面定义多个相同名称的方法，但是各自的参数不同。
> 注意，方法重载的返回类型通常是相同的。
```java
class Hello {
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}
```

## 继承
java 使用`extends`关键字来实现继承。
```java
// Person 继承 Object
class Person {
    private String name;
    private int age;

    public String getName() {...}
    public void setName(String name) {...}
    public int getAge() {...}
    public void setAge(int age) {...}
}

class Student extends Person {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:
    private int score;

    public int getScore() { … }
    public void setScore(int score) { … }
}
```
java 只允许一个 class 继承自一个类，因此，一个类有且只有一个父类（`Object` 除外，没有父类）。

子类无法访问父类的`private`属性或`private`方法，如果要允许子类访问父类的属性和方法，可以使用`protected`修饰符。

### super
子类不会继承任何父类的构造方法，子类默认的构造方法`super()`是编译器自动生成的。
```java
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 12, 89);
    }
}

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    protected int score;

    public Student(String name, int age, int score) {
        this.score = score;
    }
}
```
编译出错：
```text
java: 无法将类 Person中的构造器 Person应用到给定类型;
  需要: java.lang.String,int
  找到:    没有参数
  原因: 实际参数列表和形式参数列表长度不同
```
需要显式调用`super(name, age)`并指定参数。`super`表示超类、父类。
```java
class Student extends Person {
    protected int score;

    public Student(String name, int age, int score) {
        super(name, age);   // 调用父类的构造方法 Person(String, int)
        this.score = score;
    }
}
```

### 阻止继承
从 java 15 开始，允许使用修饰符`sealed`修饰 class, 并用`permits`列出被允许继承的子类名称。
```java
public sealed class Shape permits Rect, Circle, Triangle {
    // ...
}
```
以上`Shape`就是一个`sealed`类，并只允许指定的3个类继承它。
```java
public final class Rect extends Shape {...} // 正确
public final class Square extends Shape {...}   // 错误
```

### 向上转型和向下转型

### 区分继承和组合
继承是`is`关系，组合是`has`关系，比如`Student`可以继承`Person`，可以持有一个`Book`实例。
```java
class Student extends Person {
    protected Book book;
    protected int score;
}
```

## 多态
继承关系中，子类定义了一个与父类方法签名完全相同的方法，称为`覆写（override）`。

`final`修饰的类不能被继承。
`final`修饰的方法不能被覆写。
`final`修饰的属性一经初始化不能被修改。

## 抽象类
使用`abstract`修饰的类就是抽象类。
使用`abstract`修饰的方法就是抽象方法。

抽象类本身被设计成只能用于继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译出错。
说到底，抽象方法实际上定义了`规范`。
### 面向抽象编程

## 接口
如果一个抽象类没有属性，所有方法全部都是抽象方法。
```java
abstract class Person {
    public abstract void run();
    public abstract String getName();
}
```
就可以把抽象类改写为`接口`。

java 使用`interface`可以申明一个接口。
```java
interface Person {
    void run();
    String getName();
}
```
当一个`class`去实现`interface`，使用关键字`implements`，如下示例。

```java
class Student implements Person {
  private String name;

  public Student(String name) {
    this.name = name;
  }

  @Override
  public void run() {
      System.out.println(this.name + " run");
  }
  
  @Override
  public String getName() {
      return this.name;
  }
}
```
> java 语言中，一个类只能继承自另一个类，不能从多个类继承，但是一个类可以实现多个接口`interface`。
```java
class Student implements Person, Hello {
    // ...
}
```

> 同样，接口也可以继承自另一个接口，使用关键字`extends`。
```java
interface Hello {
    void hello();
}

interface Person extends Hello {
    void run;
    String getName();
}
```

接口中可以定义`default`方法。

## 静态属性（字段）和静态方法
静态属性和静态方法属于类，所有实例共享。区别实例属性，各个实例同名属性互不影响。

接口不能定义实例属性，但是可以定义静态属性，且必须是 final 类型。
```java
public interface Person {
    public static final int MALE = 1;
    public static final int FEMALE = 2;
}

// 等同于
public interface Person {
    int MALE = 1;   // 编译时会自动加上 public static final
    int FEMALE = 2;
}
```