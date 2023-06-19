package org.frank.reference.lei_class.static_keyword;
/*
    public static void main(String[] args)

    public: 访问权限修饰符，表示最大的访问权限，被jvm调用，所以权限要够大。
    static: 被jvm调用，不用创建对象，直接类名访问。
    void: 被jvm调用，不需要给jvm返回值。
    main: 一个通用的名称，虽然不是关键字，但是被jvm识别。

    String[] args: 早期出现是为了接收键盘录入数据的。
 */
public class MainIsStatic {
    public static void main(String[] args) {
        for(int x = 0; x < args.length; x++) {
            System.out.println(args[x]);
        }
    }
}

/*
/Library/Java/JavaVirtualMachines/openjdk-11.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=65302:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/frank-dc/github/blog/program/java/learnjava/target/classes org.frank.reference.lei_class.static_keyword.MainIsStatic python java golang c/c++ groovy
 */
