package pkg2102_project_q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CircularLinkedList table = new CircularLinkedList();
        File file = new File("C:\\Users\\alper\\Desktop\\class.txt");
        Scanner scanner = new Scanner(file);

        int studentID = 0;
        String studentName;

        System.out.println("----- PLAYERS -----\n");
        while (scanner.hasNext()) {
            studentName = scanner.nextLine();
            studentID++;
            table.addStudent(studentName, studentID);
            System.out.println(studentName);
        }
        
        int roundCount = 1;
        while (true) {
            System.out.println("\n----- ROUND " + roundCount + " -----");
            table.display();
            roundCount++;
        }
    }
}
