package com.functionalProgramming;

import java.util.ArrayList;
import java.util.List;

interface AppleFilterPredicate
{
    public boolean test(Apple apple);
}
class GreenApples implements AppleFilterPredicate
{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("Green");
    }
}
class HeavyApples implements AppleFilterPredicate
{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 10;
    }
}
public class InterfaceBasedAppleFilter {

    public static void main(String[] args) {
        List<Apple> apples=List.of(new Apple("Red",10),new Apple("Green",12),new Apple("Orange",14));

        //Green Apples
        filterApplesForGreenApples(apples,new GreenApples());

        //Heavy Apples
        filterApplesForGreenApples(apples,new HeavyApples());

        /*Problem with this approach is that for each of the selection criteria a new class is needed to be made
        * Instead of that we can use anonymous class like for green and heavy apples*/
        filterApplesForGreenApples(apples, new AppleFilterPredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("Green") && apple.getWeight() > 10;
            }
        });

    }

    public static void filterApplesForGreenApples(List<Apple> apples,AppleFilterPredicate predicate)
    {
        List<Apple> filterdAppleList=new ArrayList<>();
        for (Apple apple:apples) {
            if(predicate.test(apple))
            {
                filterdAppleList.add(apple);
            }
        }
        filterdAppleList.forEach(System.out::println);
    }

}
