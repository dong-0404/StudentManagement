/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author shin
 */
public class Student {

    private int id;
    private String studentName;
    private ArrayList<Course> course;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<Course> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" + ", studentName=" + studentName + ", course=" + course + '}';
    }

}
