package com.itranswarp.sample;

import com.itranswarp.world.Person;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Simon");
        System.out.println(p1.hello());
    }
}