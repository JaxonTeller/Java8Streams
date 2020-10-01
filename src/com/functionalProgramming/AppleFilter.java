package com.functionalProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AppleFilter {

    public static void main(String[] args) {

        /*Filters Green Apples
        * Imperative Style*/
        List<Apple> apples=List.of(new Apple("Red",10),new Apple("Green",12),new Apple("Orange",14));
        filterApplesForGreenApples(apples);

        /*What if we want red apples now, we will have to right a new method,
        * or we can add an argument to filterApple method to take a color and filer according to it
        * then what if we also want the weight to filer apples,
        * we can add another argument to method for weight and
        * check all the conditions
        * THIS CODE QUICKLY BECOMES VERBOSE, NOT READABLE*/



    }

    public static void filterApplesForGreenApples(List<Apple> apples)
    {
        List<Apple> filterdAppleList=new ArrayList<>();
        for (Apple apple:apples) {
            if(apple.getColor().equals("Green"))
            {
                filterdAppleList.add(apple);
            }
        }
        filterdAppleList.forEach(System.out::println);
    }


}
