package com.metehansargin.student_service.repository;

import com.metehansargin.student_service.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    public List<Student> studentlist=new ArrayList<>();

    public Student addStudent(Student student){
        studentlist.add(student);
        return student;
    }
    public Student getById(Long id){
        return studentlist.stream().filter(c->c.id().equals(id)).findFirst().orElseThrow();
    }
    public List<Student> getAllStudents(){
        return studentlist;
    }
    public List<Student> getByLessonID(Long lessonID){
        return studentlist.stream().filter(c->c.lessonId().equals(lessonID)).toList();
    }

}
