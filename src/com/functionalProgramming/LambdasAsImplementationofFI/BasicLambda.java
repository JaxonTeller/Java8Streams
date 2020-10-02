package com.functionalProgramming.LambdasAsImplementationofFI;
class TestingLambda
{
    /*Runnable is an Functional Interface,i.e a interface with only one abstract method*/
    public static void testMethod(Runnable runnable)
    {
        runnable.run();
    }
}
public class BasicLambda {
    public static void main(String[] args) {
        /*Lambdas can be considered as instance of concrete implementation of Functional Interface,
        * We can loosely say that the type of lambda expr is Functional Interface*/
        Runnable runnable=
                ()-> System.out.println("Lambda as a implementation of Functional Interface");

        /*The above lambda is same as this anonymous class*/
        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                System.out.println("This is an anonymous class");
            }
        };

        TestingLambda.testMethod(runnable);
        TestingLambda.testMethod(runnable1);

        /*Inline lambda*/
        TestingLambda.testMethod(()-> System.out.println("This is an inline lambda"));


    }
}
