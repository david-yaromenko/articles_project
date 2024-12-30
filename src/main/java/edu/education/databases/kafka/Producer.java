package edu.education.databases.kafka;

import edu.education.databases.dto.ArticleCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMEssage(ArticleCommentDTO articleCommentDTO){
        kafkaTemplate.send("topic_one", String.valueOf(articleCommentDTO));
    }
}
