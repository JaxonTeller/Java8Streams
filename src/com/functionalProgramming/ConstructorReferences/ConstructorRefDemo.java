package com.functionalProgramming.ConstructorReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Mangoes
{
    private int weight;

    public Mangoes(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Mangoes{" +
                "weight=" + weight +
                '}';
    }

}
public class ConstructorRefDemo {

    public static void main(String[] args) {

        /*Create a list of mangoes from given weights, so that further op can be performed*/
        List<Integer> weights=new ArrayList<>();
        weights.add(12);
        weights.add(15);
        weights.add(17);
        weights.add(19);

        mangoesOfGivenWeights(weights);
    }

    public static void mangoesOfGivenWeights(List<Integer> weights)
    {
        List<Mangoes> mangoesWithGivenWeights=new ArrayList<>();
        for (Integer weight :
                weights) {
            /*This is constructor reference,which is acts as a Supplier FI ()->new Mangoes(int weight)*/
            Function<Integer, Mangoes> function = Mangoes::new;
            mangoesWithGivenWeights.add(function.apply(weight));
        }

        mangoesWithGivenWeights.forEach(System.out::println);
    }

}
