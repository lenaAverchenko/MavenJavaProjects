package org.telran.prof.com.homework25.taskFour;

public class StudentStorageApp {

    public static void main(String[] args) {
        StudentInfoStorage studentInfoStorage = new StudentInfoStorage();
        studentInfoStorage.addStudentToInfoStorage(new Student("Ivan", 29,Degree.MASTER));
        studentInfoStorage.addStudentToInfoStorage(new Student("Kostya", 19,Degree.BACHELOR));
        studentInfoStorage.addStudentToInfoStorage(new Student("Aleksandra", 25,Degree.BACHELOR));
        studentInfoStorage.addStudentToInfoStorage(new Student("Olha", 35,Degree.MASTER));
        studentInfoStorage.addStudentToInfoStorage(new Student("Petya", 26,Degree.MASTER));
        studentInfoStorage.addStudentToInfoStorage(new Student("Diana", 22,Degree.BACHELOR));

        System.out.println("The list of Students: " + studentInfoStorage.getListOfStudents());
        System.out.println("_______________________");
        System.out.println("The list of Masters: " + studentInfoStorage.getListOfStudents(Degree.MASTER));
        System.out.println("_______________________");
        System.out.println("The list of Bachelors: " + studentInfoStorage.getListOfStudents(Degree.BACHELOR));
        System.out.println("_______________________");

        System.out.println("The average age of students: " + studentInfoStorage.averageStudentsAge());
        System.out.println("_______________________");

        System.out.println("The summary students' age: " + studentInfoStorage.summaryStudentsAge());
        System.out.println("_______________________");
        System.out.println("The summary Masters' age: " + studentInfoStorage.summaryStudentsAge(Degree.MASTER));
        System.out.println("_______________________");
        System.out.println("The summary Bachelors' age: " + studentInfoStorage.summaryStudentsAge(Degree. BACHELOR));





    }
}
