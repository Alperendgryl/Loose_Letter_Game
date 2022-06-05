package pkg2102_project_q1;

import java.util.LinkedList;
import java.util.Random;

public class CircularLinkedList {

    private Student currentStudent;
    private int sizeOfLinkedList = 0;
    private final Random randomNumber = new Random();
    private final LinkedList savedName = new LinkedList();
    private int totalPlayer = 0;

    public void display() {
        int KthStudent = randomNumber.nextInt(totalPlayer) + 1;
        System.out.println("\nStudent {" + savedName.get(KthStudent - 1) + "}" + "{NUMBER " + KthStudent + "} will lost a letter\n");
        Student tempStudent = currentStudent;
        for (int i = 0; i < sizeOfLinkedList; i++) {
            System.out.println(tempStudent);
            tempStudent = tempStudent.previousStudent;
        }
        deleteStringOf(KthStudent);
    }

    private void deleteStringOf(int KthStudent) {
        int count = 0;
        while (true) {
            count++;
            if (count <= sizeOfLinkedList) {
                if (currentStudent.getStudentID() == KthStudent) {
                    if (!currentStudent.getStudentName().equals("")) {
                        currentStudent.setStudentName(currentStudent.getStudentName().substring(0, currentStudent.getStudentName().length() - 1));
                        if (currentStudent.getStudentName().equals("")) {
                            removeStudent();
                        }
                        break;
                    }
                } else {
                    currentStudent = currentStudent.nextStudent;
                }
            } else {
                break;
            }
        }
        IsWin();
    }

    private void removeStudent() {
        if (currentStudent.getStudentName().equals("")) {
            Student backStudent = currentStudent.previousStudent;
            Student frontStudent = currentStudent.nextStudent;
            backStudent.nextStudent = frontStudent;
            frontStudent.previousStudent = backStudent;
            System.out.println("\nStudent {" + savedName.get(currentStudent.getStudentID() - 1) + "}" + "{NUMBER " + currentStudent.getStudentID() + "} ELIMINATED!");
            currentStudent = currentStudent.nextStudent;
            sizeOfLinkedList--;
        }
    }

    private void IsWin() {
        if (currentStudent == currentStudent.nextStudent) {
            System.out.println("\n----- END OF THE GAME -----");
            System.out.println("\n" + currentStudent.getStudentID() + " " + currentStudent.getStudentName());
            System.out.println("\nStudent {" + savedName.get(currentStudent.getStudentID() - 1) + "}" + "{NUMBER " + currentStudent.getStudentID() + "} WON!\n");
            currentStudent = null;
            System.exit(0);
        }
    }

    public void addStudent(String studentName, int studentID) {
        sizeOfLinkedList++;
        Student newStudent = new Student(studentName, studentID);
        savedName.add(studentName);
        if (currentStudent == null) {
            currentStudent = newStudent;
            currentStudent.nextStudent = currentStudent;
            currentStudent.previousStudent = currentStudent;
        } else {
            newStudent.previousStudent = currentStudent;
            newStudent.nextStudent = currentStudent.nextStudent;
            currentStudent.nextStudent.previousStudent = newStudent;
            currentStudent.nextStudent = newStudent;
        }
        totalPlayer++;
    }
}
