/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Course;
import entity.Student;
import java.util.ArrayList;
import utils.ValidAndNormalText;

/**
 *
 * @author shin
 */
public class StudentInputer {

    private Student std;
    private Course course;

    public Student inputStudent() {
        std = new Student();
        std.setStudentName(ValidAndNormalText.getStringByRegex("Please enter name: ", "Enter character only!!!", "[A-Za-z ]+"));
        std.setCourse(addCourses());
        return std;
    }

    private ArrayList<Course> addCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        Course course = addCourse();
        courses.add(course);
        return courses;
    }

    public Course addCourse() {
        course = new Course();
        int courseType = ValidAndNormalText.getInt("Please enter course number: (1-java, 2-.Net, 3-C/C++)  ", "Enter number only!!!", "range of [1,3]", 1, 3);
        course.setCourseName(Course.CourseType.getCourseNameByInt(courseType));
        course.setSemester(ValidAndNormalText.getInt("Please enter semester number: ", "Enter number only!!!", "range of [1,9]", 1, 9));
        return course;
    }

    public Student inputInfoUpdate(Student student) {
        std = new Student();
        std.setStudentName(ValidAndNormalText.getStringByRegex("Please enter name: ", "Enter character only!!!", "[A-Za-z ]+"));
        if (ValidAndNormalText.pressYNtoContinue("Do you want to update course(Y/N)??")) {
            std.setCourse(addCourses());
        } else {
            std.setCourse(student.getCourse());
        }
        return std;
    }
}
