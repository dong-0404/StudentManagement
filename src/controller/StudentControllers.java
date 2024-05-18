/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.StudentInputer;
import bo.StudentManagement;
import entity.Course;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import utils.ValidAndNormalText;

/**
 *
 * @author shin
 */
public class StudentControllers {

    private StudentManagement studentManagement;
    private StudentInputer studentInputer;

    public StudentControllers() {
        this.studentManagement = new StudentManagement();
        this.studentInputer = new StudentInputer();
    }

    private Student inputStudentInfo() {
        Student student = studentInputer.inputStudent();
        return student;
    }

    public ArrayList<Student> createStudent() {
        ArrayList<Student> listStudents = new ArrayList<>();
        Student student = inputStudentInfo();
        if (!checkExitStudent(student)) {
            if (studentManagement.addStudent(student)) {
                listStudents.add(student);
                return listStudents;
            }
        }
        return null;
    }

    private boolean checkExitStudent(Student student) {
        ArrayList<Student> studentList = studentManagement.getAllStudent();
        for (Student std : studentList) {
            if (std.toString().equals(student.toString())) {
                System.err.println("exist!!!!");
                return true;
            }
//            for (Course course : std.getCourse()) {
//                if (std.getStudentName().toLowerCase().equals(student.getStudentName().toLowerCase())) {
//                    for (Course c : student.getCourse()) {
//                        if (course.getCourseName().equals(c.getCourseName()) && course.getSemester() == c.getSemester()) {
//                            return false;
//                        }
//                    }
//                }
//            }
        }
        return false;
    }

    private Student addCourseforStudentById() throws Exception {
        int id = ValidAndNormalText.getInt("Please enter id: ", "Enter number only!!!", "range of [1," + Integer.MAX_VALUE + "]", 1, Integer.MAX_VALUE);
        Student student = studentManagement.getStudentById(id);
        Course newCourse = studentInputer.addCourse();
        if (!checkDuplicateCourse(student, newCourse)) {
            student = studentManagement.addCourseForStudentById(id, newCourse, student);
            return student;
        }
        return null;
    }

    public Student addCouse() throws Exception {
        Student student = this.addCourseforStudentById();
        return student;
    }

    private boolean checkDuplicateCourse(Student student, Course course) throws Exception {
        for (Course c : student.getCourse()) {
            if (c.getCourseName().contains(course.getCourseName()) && c.getSemester() == course.getSemester()) {
                System.err.println("Course is duplicate!!!");
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> studentList = studentManagement.getAllStudent();
        if (studentList.isEmpty()) {
            return null;
        }
        return studentList;
    }

    private Student updateStudentById(int id, Student student) throws Exception {
        student = studentInputer.inputInfoUpdate(student);
        return studentManagement.updateStudentById(id, student);
    }

    private Student deletedStudentById(int id) throws Exception {
        return studentManagement.deleteStudentById(id);
    }

    public Student updateOrDeleteStudent() throws Exception {
        int id = ValidAndNormalText.getInt("Please enter id: ", "Enter number only!!!", "range of [1," + Integer.MAX_VALUE + "]", 1, Integer.MAX_VALUE);
        if (ValidAndNormalText.pressUDtoContinue("Please enter U to update or D to delete!!!!")) {
            Student student = studentManagement.getStudentById(id);
            return this.updateStudentById(id, student);
        } else {
            return this.deletedStudentById(id);
        }
    }

    private ArrayList<Student> getListStudentByName() {
        String name = ValidAndNormalText.getStringByRegex("Please enter student name: ", "Enter string only!!!", "[A-Za-z ]+");
        ArrayList<Student> studentList = studentManagement.searchByName(name);
        return studentList;
    }

    public ArrayList<Student> findAndSort() {
        ArrayList<Student> listStudent = this.getListStudentByName();

        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().toLowerCase().compareTo(o2.getStudentName().toLowerCase());
            }
        });
        return listStudent;
    }

    public Hashtable<String, Integer> report() {
        Hashtable<String, Integer> listReport = new Hashtable<>();
        ArrayList<Student> listStudent = studentManagement.getAllStudent();
        for (Student student : listStudent) {
            for (Course course : student.getCourse()) {
                String key = String.format("%15s | %10s", student.getStudentName(), course.getCourseName());
                if (listReport.containsKey(key)) {
                    int total = listReport.get(key);
                    listReport.put(key, ++total);
                } else {
                    listReport.put(key, 1);
                }
            }
        }
        return listReport;
    }

}
