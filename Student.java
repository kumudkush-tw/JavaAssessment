package com.generation.model;

import com.generation.service.CourseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generation.service.StudentService;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO implement this method - 25Oct
//        System.out.println("at entry " + courses.size());
//       // System.out.println("get student id: " + Student.this.getId());
//        if (isAttendingCourse(course.getCode())){
//            System.out.println("already attending course: " + course.getCode());
//        }
//        else {
//            courses.add(course);
//            System.out.println(courses.size());
//        }
//       if (!isCourseApproved(course.getCode())) {
//           approvedCourses.put(Student.this.getId(), course);
//       }
//        if (!courses.contains(course.getCode())) {
//            courses.add(course);
//         }
       // System.out.println("course list: " + courses);
//        if (StudentService.isSubscribed(Student.this.getId())){
//            System.out.println("IS there");
//        } else {System.out.println("IS NOT there");}
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        //TODO implement this method
      //new

        return false;
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses( Course course )
    {
        //TODO implement this method
        return null;
    }

    public boolean isAttendingCourse( String courseCode )
    {   System.out.println("is attending " + courses);
        //TODO implement this method
//      for ( Course course : courses )
//        {
//            if (courses.contains(courseCode))
//                return true;
//
//            else {return false;}
//        }
//
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method
        return null;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
