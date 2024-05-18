/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author shin
 */
public class Course {

    public enum CourseType {
        JAVA("java"), DOT_NET(".NET"), C_CPP("C/C++");

        private String courseName;

        CourseType(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseName() {
            return courseName;
        }

        public static String getCourseNameByInt(int type) {
            switch (type) {
                case 1 -> {
                    return JAVA.getCourseName();
                }
                case 2 -> {
                    return DOT_NET.getCourseName();
                }
                case 3 -> {
                    return C_CPP.getCourseName();
                }
                default ->
                    throw new AssertionError();
            }
        }
    }

    private String courseName;
    private int semester;

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" + "courseName=" + courseName + ", semester=" + semester + '}';
    }

}
