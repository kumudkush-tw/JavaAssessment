package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;
import java.text.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();
    //new
    private final Map<String, List<Course>> enrolledToCourses = new HashMap<>();

    public StudentService() throws ParseException{
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        subscribeStudent(new Student("1", "s1", "s1@gmail.com", ft.parse("2001-11-11")));
        subscribeStudent(new Student("2", "s2", "s2@gmail.com", ft.parse("2000-12-11")));
        subscribeStudent(new Student("3", "s3", "s3@gmail.com", ft.parse("1998-11-01")));
        subscribeStudent(new Student("4", "s4", "s4@gmail.com", ft.parse("1999-09-11")));
    }

    public void subscribeStudent( Student student )
    {
        if(findStudent(student.getId()) == null) {
            students.put( student.getId(), student );
           // System.out.println( "Student Successfully Registered! " );
        }
        else {
            System.out.println("Student with " + student.getId() + " already exists");
            return;
            }
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId, String courseId )
    {
        //TODO implement this method
        boolean ret_val = false;

            List<Course> courses = enrolledToCourses.get(studentId);
            if (courses.isEmpty()){
                return false;}

            for (Course course : courses) {

                if (course.getCode().contains(courseId) ) {
                    ret_val = true;
                }

            }

            return ret_val;
    }

    public void showSummary()
    {
        //TODO implement
        if (students.size() == 0){
        System.out.println("No students enrolled yet!");
         }
        else{
            System.out.println("Students Enrolled: ");
            for (String key: students.keySet()){
                Student student = students.get(key);
                System.out.println(student);
            }
        }
        //new
        System.out.println( "Enrolled to Courses" );
        for ( String key : enrolledToCourses.keySet() )
        {
            List<Course> courses = enrolledToCourses.get( key );
            System.out.println( "Student with Student ID " + key + " Enrolled to Course(s): ");
            for(Course course : courses )
            {
                System.out.println(course);
            }
        }

    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            //25OctKK

            if (!enrolledToCourses.containsKey(studentId))
            {
                enrolledToCourses.put(studentId, new ArrayList<>());
            }

            students.get( studentId ).enrollToCourse( course );
            enrolledToCourses.get(studentId).add(course);
        }


    }
}
