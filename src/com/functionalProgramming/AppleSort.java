package com.functionalProgramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppleSort {

    public static void main(String[] args) {
        List<Apple> apples=new ArrayList<>();
        apples.add(new Apple("Red",10));
        apples.add(new Apple("Green",12));
        apples.add(new Apple("Orange",14));

        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple apple, Apple t1) {
                return Integer.compare(apple.getWeight(),t1.getWeight());
            }
        });

        apples.forEach(System.out::println);

        //With help of lambda expression
        apples.sort(Comparator.comparingInt(Apple::getWeight));
        apples.forEach(System.out::println);

    }
}
