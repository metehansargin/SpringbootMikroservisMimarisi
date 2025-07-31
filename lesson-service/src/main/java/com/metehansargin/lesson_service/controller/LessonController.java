package com.metehansargin.lesson_service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.metehansargin.lesson_service.client.StudentClient;
import com.metehansargin.lesson_service.model.Lesson;
import com.metehansargin.lesson_service.producer.LessonProducer;
import com.metehansargin.lesson_service.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    public LessonRepository lessonRepository;

    @Autowired
    public StudentClient studentClient;

    @Autowired
    public LessonProducer lessonProducer;
    @PostMapping
    public Lesson add(@RequestBody Lesson lesson) {
       return lessonRepository.addLesson(lesson);
    }

    @GetMapping("/{id}")
    public Lesson findById(@PathVariable Long id){
        return lessonRepository.findById(id);
    }
    @GetMapping
    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }
    @GetMapping("/with-students")
    public List<Lesson> findAllWithStudents(){
        List<Lesson> lessonList=lessonRepository.findAll();
        lessonList.forEach(c->c.setStudentList(studentClient.findByLessonId(c.getId())));
        return lessonList;
    }
    @PostMapping("/notification")
    public ResponseEntity<Lesson> postLessonEvent(@RequestBody Lesson lesson) throws JsonProcessingException {

        lessonProducer.sendLessonTopic(lesson);
        //kafka producer
        return ResponseEntity.status(HttpStatus.CREATED).body(lesson);
    }
}
