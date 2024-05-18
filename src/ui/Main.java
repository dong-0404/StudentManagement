/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import controller.StudentControllers;
import entity.Course;
import entity.Student;
import java.util.ArrayList;
import java.util.Hashtable;
import utils.ValidAndNormalText;

/**
 *
 * @author shin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentControllers studentController = new StudentControllers();

        String data = "";
        String menu = """

                STUDENT MANAGEMENT SYSTEM
                      1. Create
                      2. Find and Sort
                      3. Update/Delete
                      4. Add course for student
                      5. Get list courses by student
                      6. Report
                      0. Exit

                      (Please choose 1 to Create Student, 2 to Find and Sort Student by name, 3 to Update or Delete Student, 4 to Report, 5 to Get list student and 0 to Exit program).
                      Your choice: """;

        while (true) {
            int choice = ValidAndNormalText.getInt(menu, "Must input an integer number!", "Must input an integer in range [0,5]", 0, 6);

            switch (choice) {
                case 1:
                    ArrayList<Student> studentList = studentController.createStudent();
                    if (studentList != null) {
                        data = "";
                        for (Student std : studentList) {
                            for (Course course : std.getCourse()) {
                                data += String.format("%-5s | %-15s | %-15s | %-10s", std.getId(), std.getStudentName(), course.getCourseName(), course.getSemester()) + "\n";
                            }
                        }
                        System.out.println(data);
                    }
                    break;
                case 2:
                    ArrayList<Student> student = studentController.findAndSort();
                    if (student.isEmpty()) {
                        System.err.println("student not exist!!!");
                    } else {
                        data = "";
                        for (Student std : student) {
                            for (Course course : std.getCourse()) {
                                data += String.format("%-5s | %-15s | %-15s | %-10s", std.getId(), std.getStudentName(), course.getCourseName(), course.getSemester()) + "\n";
                            }
                        }
                        System.out.println(data);
                    }
                    break;
                case 3:
                    try {
                    studentController.updateOrDeleteStudent();
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
                break;
                case 4:
                    try {
                    studentController.addCouse();
                } catch (Exception e) {
                    System.err.println(e);
                }
                break;
                case 5:
                    ArrayList<Student> allStudents = studentController.getAllStudent();
                    data = "";
                    for (Student std : allStudents) {
                        for (Course course : std.getCourse()) {
                            data += String.format("%-5s | %-15s | %-15s | %-10s", std.getId(), std.getStudentName(), course.getCourseName(), course.getSemester()) + "\n";
                        }
                    }
                    System.out.println(data);
                    break;
                case 6:
                    Hashtable<String, Integer> listReport = studentController.report();
                    data = "";
                    for (String key : listReport.keySet()) {
                        data += key + " | " + listReport.get(key) + "\n";
                    }
                    System.out.println(data);
                    break;
                case 0:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

}
