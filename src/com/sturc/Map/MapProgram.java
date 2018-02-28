package com.sturc.Map;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compile high level, object-oriented, platform independant language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        if (languages.containsKey("Java")) {
            System.out.println("Key 'Java' is already in the map.");
        } else {
            System.out.println(languages.put("Java", "new value"));
        }

        System.out.println("=============");

//        languages.remove("Lisp");

        if (languages.remove("Algol", "an algorithmic language")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Key/value pair not found.");
        }

        System.out.println(languages.replace("Lisp", "a functional language."));

        for (String key : languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }

    }

}
