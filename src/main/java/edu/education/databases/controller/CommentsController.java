package edu.education.databases.controller;

import edu.education.databases.dto.CommentsDTO;
import edu.education.databases.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @GetMapping("/comment/article/{id}")
    public List<CommentsDTO> getAllComments(@PathVariable Integer id){
        return commentsService.findAllCommentByArticle(id);
    }

    @PostMapping("/comment")
    public CommentsDTO createComment(@RequestBody CommentsDTO commentsDTO){
        return commentsService.createComment(commentsDTO);
    }

    @DeleteMapping("/delete/comment/{id}")
    public void deleteComment(@PathVariable Integer id){
        commentsService.deleteComment(id);
    }
}
