package org;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommandUtils {
    public static void showAll(HashMap<String, ?> map){
        map.forEach((id, obj) -> {
            if (obj instanceof Teacher) {
                System.out.println(((Teacher)obj).getInfo());
            } else if (obj instanceof Course) {
                System.out.println(((Course)obj).getInfo());
            } else if (obj instanceof Student) {
                System.out.println(((Student)obj).getInfo());
            }
        });
    }

    public static void showStudentCourses(String studentId, School school){
        Student student = lookUpStudent(school.getStudentMap(), studentId);
        //excepcion en lookUpStudent???
        if(student == null){
            throw new IllegalArgumentException("Student doesn't exist!");
        }
        List<Course> courses = student.getCourse();
        for(Course course : courses){
            System.out.println(course.getInfo());
        }
    }


//TODO - lanzar una exception - Julia
    public static Teacher lookUpTeacher(HashMap<String, Teacher> map, String targetId){
       Teacher teacher = map.get(targetId);
       if (teacher != null){
           return teacher;
       } else {
           System.out.println("Invalid ID.");
           return null;
       }
    }

    public static Student lookUpStudent(HashMap<String, Student> map, String targetId){
        Student student = map.get(targetId);
        if (student != null){
            return student;
        } else {
            System.out.println("Invalid ID.");
            return null;
        }
    }

    public static Course lookUpCourse(HashMap<String, Course> map, String targetId){
        Course course = map.get(targetId);
        if (course != null){
            return course;
        } else {
            System.out.println("Invalid ID.");
            return null;
        }
    }

}
