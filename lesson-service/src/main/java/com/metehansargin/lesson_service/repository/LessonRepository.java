package com.metehansargin.lesson_service.repository;

import com.metehansargin.lesson_service.model.Lesson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LessonRepository {
    public List<Lesson> lessonlist=new ArrayList<>();

    public Lesson addLesson(Lesson lesson){
        lessonlist.add(lesson);
        return lesson;
    }
    public Lesson findById(Long id){
        return lessonlist.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow();
    }
    public List<Lesson> findAll(){
        return lessonlist;
    }
}
