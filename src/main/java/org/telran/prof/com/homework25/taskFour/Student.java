package org.telran.prof.com.homework25.taskFour;

public class Student {
    private int id;
    private String name;
    private int age;
    private Degree degree;
    private static int countId = 1;

    public Student(String name, int age, Degree degree) {
        this.id = countId;
        this.name = name;
        this.age = age;
        this.degree = degree;
        countId += 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Degree getDegree() {
        return degree;
    }

    public static int getCountId() {
        return countId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", degree=" + degree +
                '}';
    }


}
