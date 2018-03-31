package com.sturc.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

/*
        List<String> gNumbers = new ArrayList<>();

        bingoNumbers.forEach(number -> {
            if (number.startsWith("G")) {
                gNumbers.add(number);
            }
        });

        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));

        gNumbers.forEach((String s) -> System.out.println(s));
*/

        bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");

        Stream<String> concat = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("--------------");
        System.out.println(concat
                .distinct()
                .peek(System.out::println)
                .count());

    }
}
