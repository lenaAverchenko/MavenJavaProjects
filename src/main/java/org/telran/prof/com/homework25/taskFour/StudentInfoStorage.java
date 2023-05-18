package org.telran.prof.com.homework25.taskFour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentInfoStorage {
    private Map <Integer, Student> allStudents = new HashMap<>();

    public StudentInfoStorage() {
    }

    public Map<Integer, Student> getAllStudents() {
        return allStudents;
    }

    @Override
    public String toString() {
        return "StudentInfoStorage{" +
                "allStudents=" + allStudents +
                '}';
    }


    public void addStudentToInfoStorage(Student student){
        allStudents.put(student.getId(), student);
    }

    public List<Student> getListOfStudents(){
        return allStudents.values().stream().toList();
    }

    public List<Student> getListOfStudents(Degree deg){
        return allStudents.values().stream()
                .filter(stud -> stud.getDegree().equals(deg))
                .collect(Collectors.toList());
    }

    public double averageStudentsAge(){
//        long amountOfStudents = allStudents.values().stream()
//                .map(Student::getAge)
//                .count();
//        AtomicInteger summaryAge = new AtomicInteger();
//        allStudents.values().stream()
//                .map(Student::getAge)
//                .forEach(age -> {
//                    summaryAge.set(summaryAge.get() + age);});
//        allStudents.values().stream()
//                .map(Student::getAge)
//                .mapToInt(a -> a).average().orElse(0);

        return allStudents.values().stream()
                .map(Student::getAge)
                .mapToInt(a -> a).average().orElse(0);
    }

    public double summaryStudentsAge(){
        return allStudents.values().stream()
                .map(Student::getAge)
                .mapToInt(a -> a).sum();
    }

    public double summaryStudentsAge(Degree deg){
        return allStudents.values().stream()
                .filter(stud -> stud.getDegree().equals(deg))
                .map(Student::getAge)
                .mapToInt(a -> a).sum();
    }

    public void setAllStudents(Map<Integer, Student> allStudents) {
        this.allStudents = allStudents;
    }
}
