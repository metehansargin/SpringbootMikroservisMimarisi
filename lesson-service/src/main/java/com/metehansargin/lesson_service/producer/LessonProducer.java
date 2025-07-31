package com.metehansargin.lesson_service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metehansargin.lesson_service.model.Lesson;
import org.springframework.kafka.support.SendResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class LessonProducer {
    @Autowired
    KafkaTemplate<Long,String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;
    public void sendLessonTopic(Lesson lesson) throws JsonProcessingException {

        Long id=lesson.getId();
        String value= objectMapper.writeValueAsString(lesson);
        CompletableFuture<SendResult<Long,String>>  completableFuture=kafkaTemplate.sendDefault(id, value);

        completableFuture.thenApply(result->{
            handleSuccess(id,value,result);
            return result;
        });
        completableFuture.exceptionally(throwable -> {
            handleFaily(throwable);
            return null;
        });

    }
    private void handleSuccess(Long id,String value,SendResult<Long,String> result){
        System.out.println("Mesaj gonderildi id :"+id+"value :"+value+" Partiton: "+result.getRecordMetadata().partition());
    }
    private void handleFaily(Throwable throwable){
        System.out.println("Mesaj gonderilirken hata alindi :"+throwable.getMessage());

        try {
            throw throwable;

        }catch (Throwable throwable1){
            System.out.println("Error in failure"+throwable1.getMessage());

        }
    }
}
