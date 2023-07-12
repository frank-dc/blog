package org.frank.reference.thinking.permission_modifier.other_package;

import org.frank.reference.thinking.permission_modifier.Father;

public class Son extends Father {
    public static void main(String[] args) {
        Father f = new Father();
//        f.show();   // 'show()' has private access in 'org.frank.reference.thinking.permission_modifier.Father'
//        f.show2();  // 'show2()' is not public in 'org.frank.reference.thinking.permission_modifier.Father'. Cannot be accessed from outside package
//        f.show3();  // 'show3()' has protected access in 'org.frank.reference.thinking.permission_modifier.Father'
        f.show4();

        Son s = new Son();
        s.show3();
        s.show4();
    }
}
