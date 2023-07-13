package org.frank.reference.thinking.internal_class;

class Outer5 {
    public int num = 10;

    class Inner {
        public int num = 20;

        public void show() {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            // 通过对象访问成员变量
            System.out.println(new Outer5().num);
            // 通过类访问成员变量
            System.out.println(Outer5.this.num);
        }
    }
}
public class InternalClassDemo5 {
    public static void main(String[] args) {
        Outer5.Inner oi = new Outer5().new Inner();
        oi.show();
    }
}
