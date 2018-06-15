package com.sturc.Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John", 25);
        Employee tim = new Employee("Tim", 26);
        Employee jack = new Employee("Jack", 30);
        Employee snow = new Employee("Snow", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);



        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

/*        for (Employee employee : employees) {
            System.out.print(employee.getName());
            System.out.println(" " + employee.getAge());

        }*/

        employees.forEach(employee -> {
            System.out.print(employee.getName());
            System.out.println(" " + employee.getAge());
        });

        UpperConcat uc = (String s1, String s2) -> {
            String res = s1.toUpperCase() + s2.toUpperCase();
            return res;
        };
        String res = doString(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(res);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println("AnotherClass " + s);

    }

    public final static String doString(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething() {

        int i = 0;

        UpperConcat uc = (String s1, String s2) -> {
            System.out.println("The lambda expression`s class is " + getClass().getSimpleName());
            System.out.println("i in the lambda = " + i);
            String res = s1.toUpperCase() + s2.toUpperCase();
            return res;
        };

/*
        UpperConcat uc = new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("i within anonymous class: " + i);
                return s1.toUpperCase() + s2.toUpperCase();
            }
        };
*/
//        printNumber();
        System.out.println("The AnotherClass class`s name: " + getClass().getSimpleName());
        return Main.doString(uc, "String1", "String2");

    }

    public void printNumber() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("The value is: " + number);
        };

        new Thread(r).start();
    }
}