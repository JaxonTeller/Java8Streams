package com.functionalProgramming.LambdasAsImplementationofFI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Student
{
    private int marks;

    public Student(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "marks=" + marks +
                '}';
    }
}
public class PredicateExample {

    public static void main(String[] args) {

        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(50));
        studentList.add(new Student(60));
        studentList.add(new Student(55));
        studentList.add(new Student(40));

        /*Student with > 50 marks*/
        Predicate<Student> studentWithMarksGrThan50=(Student s)->s.getMarks()>50;
        selectStudentBasedOnCriteria(studentList,studentWithMarksGrThan50);

        /*Student with > 50 and < 60 marks*/
        selectStudentBasedOnCriteria(studentList,studentWithMarksGrThan50.and((Student s)->s.getMarks()<60));

        /*Student with > 50 or 60 marks*/
        selectStudentBasedOnCriteria(studentList,studentWithMarksGrThan50.or((Student s)->s.getMarks()==60));

    }

    /*As this method accepts Predicate FI which takes a arg of type T and returns Boolean, we can pass lambda here*/
    public static void selectStudentBasedOnCriteria(List<Student> students, Predicate<Student> predicate)
    {
        List<Student> selectedStudents=new ArrayList<>();
        for (Student student :
                students) {
            if (predicate.test(student)){
                selectedStudents.add(student);
            }
        }

        /*For each also accepts a Functional Interface called as Consumer which takes a argument of type T and returns void
        * hence we are passing lambda which gives student and returns void*/
        selectedStudents.forEach((Student s)-> System.out.println(s));
    }
}
