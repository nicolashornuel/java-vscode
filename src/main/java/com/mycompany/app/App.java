package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Person p1 = new Person(20, "jean-paul");
        Person p2 = p1;
        p1.setName("alphonse");

        System.out.println(p1.getName());
        System.out.println(p2.getName());
    }
}

