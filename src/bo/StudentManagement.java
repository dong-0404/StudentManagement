/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Course;
import entity.Student;
import java.util.ArrayList;


/**
 *
 * @author shin
 */
public class StudentManagement {

    private ArrayList<Student> student;
    private int lastId;

    public StudentManagement() {
        student = new ArrayList<>();
        lastId = 0;
    }

    public boolean addStudent(Student std) {
        std.setId(++lastId);
        return student.add(std);
    }

    public ArrayList<Student> getAllStudent() {
        return student;
    }

    public int searchByid(int id) {
        for (int index = 0; index < student.size(); index++) {
            if (student.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public Student getStudentById(int id) throws Exception {
        int index = this.searchByid(id);
        if (index != -1) {
            return student.get(index);
        }
        throw new Exception("id is invalid!!!");
    }

    public Student updateStudentById(int id, Student student) throws Exception {
        int index = this.searchByid(id);
        if (index != -1) {
            student.setId(id);
            this.student.set(index, student);
            return student;
        }
        throw new Exception("Student not found!!!");
    }

    public Student deleteStudentById(int id) throws Exception {
        int index = this.searchByid(id);
        if (index != -1) {
            return student.remove(index);
        }
        throw new Exception("Student not found!!!");
    }

    public Student addCourseForStudentById(int id, Course course, Student student) throws Exception {
        ArrayList<Course> listCourse = student.getCourse();
        listCourse.add(course);
        return student;
    }

    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> ret = new ArrayList<>();
        for (Student student : student) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                ret.add(student);
            }
        }
        return ret;
    }

}
