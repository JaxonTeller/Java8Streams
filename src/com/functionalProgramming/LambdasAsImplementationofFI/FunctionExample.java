package com.functionalProgramming.LambdasAsImplementationofFI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee
{
    private String name;
    private int salaray;

    public Employee(String name, int salaray) {
        this.name = name;
        this.salaray = salaray;
    }

    public String getName() {
        return name;
    }

    public int getSalaray() {
        return salaray;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalaray(int salaray) {
        this.salaray = salaray;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salaray=" + salaray +
                '}';
    }
}
public class FunctionExample {

    public static void main(String[] args) {

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee("Nishu",17000));
        employeeList.add(new Employee("Mishu",18000));
        employeeList.add(new Employee("Hishu",170900));
        employeeList.add(new Employee("Iishu",170800));

        /*Show the list of names of employees*/
        //lambda in form of method reference
        Function<Employee,String> function=(Employee::getName);
        showingFunctionFI(employeeList,function);

        /*Show the list of names of employees, with Uppercase*/
        showingFunctionFI(employeeList,function.andThen(String::toUpperCase));


    }

    /*Function is a FI which takes an arg of type T and transforms/maps it to arg of type R, we can use lambda here*/
    public static void showingFunctionFI(List<Employee> employees, Function<Employee,String> function)
    {
        List<String> employeeNamesList=new ArrayList<>();
        for (Employee employee :
                employees) {
            employeeNamesList.add(function.apply(employee));
        }

        employeeNamesList.forEach(System.out::println);
    }
}
