package edu.education.databases.kafka;

import edu.education.databases.dto.ArticleCommentDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "topic_one", groupId = "first")
    public void listener(String message){
        System.out.println("Recieved message: " + message);
    }

}
