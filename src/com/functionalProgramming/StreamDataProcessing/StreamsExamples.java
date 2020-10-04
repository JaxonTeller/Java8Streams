package com.functionalProgramming.StreamDataProcessing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Dish
{
    private final String name;
    private final boolean vegeterian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegeterian, int calories, Type type) {
        this.name = name;
        this.vegeterian = vegeterian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegeterian=" + vegeterian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public enum  Type { MEAT, FISH,OTHER}
}
public class StreamsExamples {

    public static void main(String[] args) {

        List<Dish> menu= Arrays.asList(new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("frenchfries",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("seasonfruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH));

        /*Top 3 names of dishes having calories > 300 */
        List<String> highCalorieDishes =
                menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());
        highCalorieDishes.forEach(System.out::println);

        /*Vegetarian Dishes*/
        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegeterian).collect(Collectors.toList());
        System.out.println(vegetarianDishes);

        /*In above two examples filer map limit this operations returns Stream so that the next operation can be
        * Chained to them, this are called as Intermediate operation
        * While other are terminal operation as they don't return stream , and they are responsible for starting the
        * execution of Streams, as Streams are lazy there execution doesn't start until there is an terminal operation
        * to Stream.*/

        /*Non-Vegetarian Dishes*/
        List<Dish> nonVegetarianDishes = menu.stream().filter(dish -> !dish.isVegeterian()).collect(Collectors.toList());
        System.out.println(nonVegetarianDishes);

        List<Integer> numbers=new ArrayList<>();
        /*Even numbers which are not duplicate*/
        numbers.add(2);
        numbers.add(2);
        numbers.add(6);
        numbers.add(7);

        List<Integer> distinctEvenNumbers =
                numbers.stream().filter(integer -> integer % 2 == 0).distinct().collect(Collectors.toList());
        System.out.println(distinctEvenNumbers);


        /*First two meat dishes*/
        List<Dish> firstTwoMeatDishes =
                menu.stream().filter(dish -> dish.getType().equals(Dish.Type.MEAT)).limit(2).collect(Collectors.toList());
        System.out.println(firstTwoMeatDishes);

        /*Length of name of each dish*/
        List<Integer> nameLengthForEachDish =
                menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(nameLengthForEachDish);

        /*List of square of each number*/
        List<Integer> squareNumber =
                numbers.stream().map(integer -> integer * integer).collect(Collectors.toList());
        System.out.println(squareNumber);

        /*MATCHING OPERATIONS*/
        /*Find out whether is there any vegetarian dish exists*/
        if(menu.stream().anyMatch(Dish::isVegeterian))
        {
            System.out.println("We have vegetarian menu :))");
        }

        /*Check if menu is healthy i.e all the dishes should be < 1000 calories*/
        if(menu.stream().allMatch(dish -> dish.getCalories() < 1000))
        {
            System.out.println("We have healthy menu");
        }

        /*FINDING OPERATIONS*/
        /*Find any vegetarian dish*/
        Optional<Dish> optionalDish = menu.stream().filter(Dish::isVegeterian).findAny();
        optionalDish.ifPresentOrElse(dish -> System.out.println("Special Veg Dish "+dish.getName()),
                ()-> System.out.println("No Dish is present"));

        /*Find the first even number from list of numbers*/
        Optional<Integer> optionalInteger = numbers.stream().filter(integer -> integer % 2 == 0).findFirst();
        optionalInteger.ifPresentOrElse(System.out::println,()-> System.out.println("No even number present"));

        /*Calculate the sum of all the calories in the menu*/
        System.out.println("Sum of all the calories "+menu.stream().mapToInt(Dish::getCalories).sum());

        /*Find out the highest calorie dish in the menu*/
        Optional<Dish> highestCalorieDish = menu.stream().max((Comparator.comparing(Dish::getCalories)));
        highestCalorieDish.ifPresentOrElse(System.out::println,()-> System.out.println("No Dish Present"));

        /*Reduce operation*/
        /*While performing reduction we need to take care of two things
        * 1.The initial value
        * 2.Operation to be applied on each element*/
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        Integer maxValue = numbers.stream().reduce(0, (a, b) -> {
            if (a > b)
                return a;
            return b;
        });
        System.out.println(maxValue);
        //or
        numbers.stream().reduce(Integer::max);

        /*Count the # of dishes in the stream using map and reduce*/
        Optional<Integer> numberOfDishes = menu.stream().map(d -> 1).reduce(Integer::sum);
        numberOfDishes.ifPresentOrElse(System.out::println,()-> System.out.println("No dish present"));

        /*find out all the even # between 1 to 100*/
        List<Integer> evenNumbersBetween1to100 =
                IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println(evenNumbersBetween1to100);
    }
}
