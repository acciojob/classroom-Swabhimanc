package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, String> pairDB = new HashMap<>(); //student,teacher
    List<Student> studentDB = new ArrayList<>();
    List<Teacher> teacherDB = new ArrayList<>();

    public String addStudent(Student student)
    {
        studentDB.add(student);
        return "Student added successfully";
    }

    public String addTeacher(Teacher teacher)
    {
        teacherDB.add(teacher);
        return "Teacher added successfully";
    }

    public String addStudentTeacherPair(String student, String teacher)
    {
        pairDB.put(student,teacher);
        return "Student Teacher Pair added Successfully";
    }

    public Student getStudentByName(String name)
    {
        for(Student x : studentDB)
        {
            if(x.getName().equals(name))
            {
                return x;
            }
        }
        return null;
    }

    public Teacher getTeacherByName(String name)
    {
        for(Teacher x : teacherDB)
        {
            if(x.getName().equals(name))
            {
                return x;
            }
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String name)
    {
        List<String> ans = new ArrayList<>();

        for(String student : pairDB.keySet())
        {
            if(pairDB.get(student).equals(name))
            {
                ans.add(student);
            }
        }
        return ans;
    }

    public List<String> getAllStudents()
    {
        List<String>ans = new ArrayList<>();

        for(Student x : studentDB)
        {
            ans.add(x.getName());
        }
        return ans;
    }

    public void deleteTeacherByName(String teacher)
    {
        for(Teacher x : teacherDB)
        {
            if(x.getName().equals(teacher))
            {
                teacherDB.remove(teacher);
            }
        }

        for(String student : pairDB.keySet())
        {
            if(pairDB.get(student).equals(teacher))
            {
                pairDB.remove(student);
            }
        }

    }

    public void deleteAllTeachers()
    {
        teacherDB.clear();

        for(String x : pairDB.keySet())
        {
            studentDB.remove(x);
        }
        pairDB.clear();
    }
}
