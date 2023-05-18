package org.telran.prof.com.homework25.taskFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class StudentInfoStorageTest {
    private StudentInfoStorage studentInfoStorage = new StudentInfoStorage();
    private Student student1 = new Student("Ivan", 29,Degree.MASTER);
    private Student student2 = new Student("Kostya", 19,Degree.BACHELOR);
    private Student student3 = new Student("Aleksandra", 25,Degree.BACHELOR);
    private Student student4 = new Student("Olha", 35,Degree.MASTER);
    private Student student5 = new Student("Petya", 26,Degree.MASTER);
    private Student student6 = new Student("Diana", 22,Degree.BACHELOR);

    @Test
    void addStudentToInfoStorage() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        long amountOfAddedStudents = studentInfoStorage.getAllStudents().values().size();
        Assertions.assertEquals(2,amountOfAddedStudents);
        studentInfoStorage.setAllStudents(new HashMap<>());
    }


    @Test
    void getListOfStudents() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        studentInfoStorage.addStudentToInfoStorage(student3);
        studentInfoStorage.addStudentToInfoStorage(student4);
        studentInfoStorage.addStudentToInfoStorage(student5);
        studentInfoStorage.addStudentToInfoStorage(student6);

        List<Student> expectedStudents = Arrays.asList(student1, student2, student3, student4, student5, student6);
        List<Student> studentsGotWithMethod = studentInfoStorage.getListOfStudents();
        Assertions.assertEquals(expectedStudents, studentsGotWithMethod);
    }

    @Test
    void testGetListOfBachelorStudents() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        studentInfoStorage.addStudentToInfoStorage(student3);
        studentInfoStorage.addStudentToInfoStorage(student4);
        studentInfoStorage.addStudentToInfoStorage(student5);
        studentInfoStorage.addStudentToInfoStorage(student6);

        List<Student> expectedStudents = Arrays.asList(student2, student3, student6);
        List<Student> studentsGotWithMethod = studentInfoStorage.getListOfStudents(Degree.BACHELOR);
        Assertions.assertEquals(expectedStudents, studentsGotWithMethod);
        studentInfoStorage.setAllStudents(new HashMap<>());
    }
    @Test
    void testGetListOfMasterStudents() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        studentInfoStorage.addStudentToInfoStorage(student3);
        studentInfoStorage.addStudentToInfoStorage(student4);
        studentInfoStorage.addStudentToInfoStorage(student5);
        studentInfoStorage.addStudentToInfoStorage(student6);

        List<Student> expectedStudents = Arrays.asList(student1, student4, student5);
        List<Student> studentsGotWithMethod = studentInfoStorage.getListOfStudents(Degree.MASTER);
        Assertions.assertEquals(expectedStudents, studentsGotWithMethod);
        studentInfoStorage.setAllStudents(new HashMap<>());
    }

    @Test
    void averageStudentsAge() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        studentInfoStorage.addStudentToInfoStorage(student3);
        studentInfoStorage.addStudentToInfoStorage(student4);
        studentInfoStorage.addStudentToInfoStorage(student5);
        studentInfoStorage.addStudentToInfoStorage(student6);

        Assertions.assertEquals(26,studentInfoStorage.averageStudentsAge());
        studentInfoStorage.setAllStudents(new HashMap<>());
    }

    @Test
    void summaryStudentsAge() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        studentInfoStorage.addStudentToInfoStorage(student3);
        studentInfoStorage.addStudentToInfoStorage(student4);
        studentInfoStorage.addStudentToInfoStorage(student5);
        studentInfoStorage.addStudentToInfoStorage(student6);

        Assertions.assertEquals(156,studentInfoStorage.summaryStudentsAge());
        studentInfoStorage.setAllStudents(new HashMap<>());
    }

    @Test
    void testSummaryBachelorsAge() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        studentInfoStorage.addStudentToInfoStorage(student3);
        studentInfoStorage.addStudentToInfoStorage(student4);
        studentInfoStorage.addStudentToInfoStorage(student5);
        studentInfoStorage.addStudentToInfoStorage(student6);

        Assertions.assertEquals(66,studentInfoStorage.summaryStudentsAge(Degree.BACHELOR));
        studentInfoStorage.setAllStudents(new HashMap<>());
    }

    @Test
    void testSummaryMastersAge() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        studentInfoStorage.addStudentToInfoStorage(student3);
        studentInfoStorage.addStudentToInfoStorage(student4);
        studentInfoStorage.addStudentToInfoStorage(student5);
        studentInfoStorage.addStudentToInfoStorage(student6);

        Assertions.assertEquals(90,studentInfoStorage.summaryStudentsAge(Degree.MASTER));
        studentInfoStorage.setAllStudents(new HashMap<>());
    }
}