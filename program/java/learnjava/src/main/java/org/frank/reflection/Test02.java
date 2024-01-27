package org.frank.reflection;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader = Class.forName("org.frank.reflection.Test02").getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        System.out.println(System.getProperty("java.class.path"));


    }
}
