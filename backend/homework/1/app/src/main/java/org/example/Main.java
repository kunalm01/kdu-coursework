package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LoggingUtil logger = new LoggingUtil();
        Scanner scanner = new Scanner(System.in);
        StudentRepository repository = new StudentRepository();

        System.out.println("Welcome! Enter the corresponding number for the action:");

        boolean running = true;
        while (running) {
            System.out.println("1. Add Student         2. Retrieve by ID");
            System.out.println("3. Retrieve by Name    4. Update Student");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID:");
                    int id = scanner.nextInt();

                    System.out.println("Enter student name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.println("Enter student age:");
                    int age = scanner.nextInt();

                    System.out.println("Enter student grade:");
                    String grade = scanner.next();

                    Student student = new Student(id, name, age, grade);
                    repository.addStudent(student);
                    logger.addLog(student);
                    break;
                case 2:
                    System.out.println("Enter student ID to retrieve:");
                    int idt = scanner.nextInt();

                    Student retrievedStudent = repository.getStudent(idt);
                    logger.getstuid(retrievedStudent);
                    break;
                case 3:
                    System.out.println("Enter student name to retrieve:");
                    String names = scanner.nextLine().toLowerCase();

                    Student retrievedStudent1 = repository.getStudent(names);
                    logger.getstuname(retrievedStudent1);
                    break;
                case 4:
                    System.out.println("Enter student ID to update:");
                    int ida = scanner.nextInt();

                    Student existingStudent = repository.getStudent(ida);
                    if (existingStudent != null) {
                        System.out.println("Enter updated student name:");
                        scanner.nextLine();
                        String name1 = scanner.nextLine();

                        System.out.println("Enter updated student age:");
                        int age1 = scanner.nextInt();

                        System.out.println("Enter updated student grade:");
                        String grade1 = scanner.next();

                        Student updatedStudent = new Student(ida, name1, age1, grade1);
                        if (repository.update(updatedStudent)) {
                            System.out.println("Student information updated: " + updatedStudent);
                            logger.updlog(updatedStudent);
                        } else {
                            System.out.println("Failed to update student information.");
                        }

                    } else {
                        System.out.println("Student not found for ID: " + ida);
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number (1, 2, 3, 4, 5).");
            }
        }
    }
}