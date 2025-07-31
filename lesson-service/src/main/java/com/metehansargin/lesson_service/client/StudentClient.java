package com.metehansargin.lesson_service.client;

import com.metehansargin.lesson_service.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface StudentClient {

    @GetExchange("/student/lesson/{lessonId}")
    public List<Student> findByLessonId(@PathVariable("lessonId") Long lessonId);


    /*
    * Aslında burada bizim yaptığımız şey şu direk student ile lesson sınıfı bağlantılı değil araya bir client koyarak
    * istekleri ona belirtiyoruz ordan bize dönüş sağlanıyor. Bunun kullanılma amacı ise tekrar tekrar yazmamıza gerek kalmıyor ve
    * büyük projelerde bu daha çok kullanılıyor.
    * */
}
