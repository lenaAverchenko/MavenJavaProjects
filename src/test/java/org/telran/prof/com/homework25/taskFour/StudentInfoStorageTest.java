package org.telran.prof.com.homework25.taskFour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class StudentInfoStorageTest {
    private StudentInfoStorage studentInfoStorage = new StudentInfoStorage();
    private Student student1 = new Student("Ivan", 29, Degree.MASTER);
    private Student student2 = new Student("Kostya", 19, Degree.BACHELOR);
    private Student student3 = new Student("Aleksandra", 25, Degree.BACHELOR);
    private Student student4 = new Student("Olha", 35, Degree.MASTER);
    private Student student5 = new Student("Petya", 26, Degree.MASTER);
    private Student student6 = new Student("Diana", 22, Degree.BACHELOR);

    @BeforeEach
    private void init() {
        studentInfoStorage.addStudentToInfoStorage(student1);
        studentInfoStorage.addStudentToInfoStorage(student2);
        studentInfoStorage.addStudentToInfoStorage(student3);
        studentInfoStorage.addStudentToInfoStorage(student4);
        studentInfoStorage.addStudentToInfoStorage(student5);
        studentInfoStorage.addStudentToInfoStorage(student6);
    }

    @Test
    void addStudentToInfoStorage() {
        long amountOfAddedStudents = studentInfoStorage.getAllStudents().values().size();
        Assertions.assertEquals(6, amountOfAddedStudents);
    }


    @Test
    void getListOfStudents() {
        int expectedStudentsAmount = 6;
        int studentsGotWithMethod = studentInfoStorage.getListOfStudents().size();
        Assertions.assertEquals(expectedStudentsAmount, studentsGotWithMethod);
    }

    @Test
    void testGetListOfBachelorStudents() {
        long amountOfExpectedStudents = Arrays.asList(student2, student3, student6).stream().count();
        long amountOfStudentsGotWithMethod = studentInfoStorage.getListOfStudents(Degree.BACHELOR).stream().count();
        Assertions.assertEquals(amountOfExpectedStudents, amountOfStudentsGotWithMethod);
    }

    @Test
    void testGetListOfMasterStudents() {
        List<Integer> expectedStudentsID = Arrays.asList(student1, student4, student5).stream()
                .map(st -> st.getId()).sorted().collect(Collectors.toList());
        List<Integer> studentsGotWithMethodID = studentInfoStorage.getListOfStudents(Degree.MASTER).stream()
                .map(st -> st.getId()).sorted().collect(Collectors.toList());
        Assertions.assertEquals(expectedStudentsID, studentsGotWithMethodID);
    }

    @Test
    void averageStudentsAge() {
        Assertions.assertEquals(26, studentInfoStorage.averageStudentsAge());
    }

    @Test
    void summaryStudentsAge() {
        Assertions.assertEquals(156, studentInfoStorage.summaryStudentsAge());
    }

    @Test
    void testSummaryBachelorsAge() {
        Assertions.assertEquals(66, studentInfoStorage.summaryStudentsAge(Degree.BACHELOR));
    }

    @Test
    void testSummaryMastersAge() {
        Assertions.assertEquals(90, studentInfoStorage.summaryStudentsAge(Degree.MASTER));
    }

    @AfterEach
    void clear() {
        studentInfoStorage.setAllStudents(new HashMap<>());
    }
}