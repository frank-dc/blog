package org.frank.reference.thinking.permission_modifier;

public class Son extends Father {
    public static void main(String[] args) {
        Father f = new Father();
//        f.show();   // 'show()' has private access in 'org.frank.reference.thinking.permission_modifier.Father'
        f.show2();
        f.show3();
        f.show4();

        Son s = new Son();
        s.show2();
        s.show3();
        s.show4();
    }
}
