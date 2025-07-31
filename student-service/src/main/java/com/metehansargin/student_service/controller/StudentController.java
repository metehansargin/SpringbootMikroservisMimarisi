package com.metehansargin.student_service.controller;

import com.metehansargin.student_service.model.Student;
import com.metehansargin.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentRepository studentRepository;

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentRepository.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id){
        return studentRepository.getById(id);
    }
    @GetMapping
    public List<Student> findAll(){
        return studentRepository.getAllStudents();
    }
    @GetMapping("/lesson/{lessonId}")
    public List<Student> findByLessonId(@PathVariable("lessonId") Long lessonId){
    return studentRepository.getByLessonID(lessonId);
    }

}
