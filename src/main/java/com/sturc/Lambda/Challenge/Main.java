package com.sturc.Lambda.Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let`s split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnable1 = () -> {
            String myString = "Let`s split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Function<String, String> lambdaFunction = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }

            return returnVal.toString();
        };

        String res = lambdaFunction.apply("1234567890");
        String res1 = everySecondCharacter(lambdaFunction, "1234567890");

        Supplier<String> stringSupplier = () -> "Java";
        String res2 = stringSupplier.get();

        List<String> names = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

/*        List<String> firstUpperCase = new ArrayList<>();
        names.forEach(name ->
                    firstUpperCase.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
//        firstUpperCase.sort((s1, s2) -> s1.compareTo(s2));
        firstUpperCase.sort(String::compareTo);
        firstUpperCase.forEach(System.out::println);

        System.out.println("----------------");
*/
        names.stream()
                .sorted(String::compareTo)
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .forEach(System.out::println);

        long nameStartsWithA = names.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();

    }

    private static String everySecondCharacter(Function<String, String> function, String source) {
        return function.apply(source);
    }
}

