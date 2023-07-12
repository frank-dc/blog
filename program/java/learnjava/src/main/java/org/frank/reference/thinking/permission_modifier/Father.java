package org.frank.reference.thinking.permission_modifier;
/*
    权限修饰符       本类    同一个包下的子类或其他类    不同包下的子类    不同包下的其他类
    private         Y               N                   N               N
    无修饰符（默认）   Y               Y                   N               N
    protected       Y               Y                   Y               N
    public          Y               Y                   Y               Y
 */
public class Father {
    private void show() {
        System.out.println("private show() from Father");
    }

    void show2() {
        // 只能被同一个包中的类访问，其它包的类都是不可见的。
        System.out.println("show2() from Father");
    }

    protected void show3() {
        // 能被同一个包中的类访问，也能被其他包中的子类访问。
        System.out.println("protected show3() from Father");
    }

    public void show4() {
        System.out.println("public show4() from Father");
    }

    public static void main(String[] args) {
        Father f = new Father();
        f.show();
        f.show2();
        f.show3();
        f.show4();
    }
}
