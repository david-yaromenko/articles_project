package edu.education.databases.controller;

import edu.education.databases.dto.ArticleCommentDTO;
import edu.education.databases.kafka.Producer;
import edu.education.databases.repository.ArticlesRepository;
import edu.education.databases.service.ArticlesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class KafkaController {

    private final Producer producer;
    private final ArticlesRepository articlesRepository;
    private final ArticlesService articlesService;


    @PostMapping("/kafka/send")
    public ArticleCommentDTO send(@RequestParam(value = "id") Integer id){
        var article = articlesService.getFullArticle(id);
        producer.sendMEssage(article);
        return null;
    }
}
