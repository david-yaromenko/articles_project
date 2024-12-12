package edu.education.databases.controller;


import edu.education.databases.bean.ArticleTitleDate;
import edu.education.databases.dto.ArticleCommentDTO;
import edu.education.databases.dto.ArticlesDTO;
import edu.education.databases.service.ArticlesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ArticlesController {


    private final ArticlesService articlesService;


    // GET /article
    @GetMapping("/articles")
    public List<ArticlesDTO> getAll(){
        return articlesService.getAllArticle();
    }

    // GET /article/{id}
    @GetMapping("/article/{id}")
    public Optional<ArticlesDTO> getArticle(@PathVariable Integer id){
        return articlesService.getArticle(id);
    }

    @GetMapping("/article/query/all")
    public List<ArticleTitleDate> getQueryAllArticles(){
        return articlesService.getAllArticleQuery();
    }

    // POST /article
    @PostMapping("/article")
    public ArticlesDTO createArt(@RequestBody ArticlesDTO articlesDTO){
        return articlesService.createArticle(articlesDTO);
    }

    // PUT /article или /article/{id}
    @PutMapping("/article")
    public ArticlesDTO updateArt(@RequestBody ArticlesDTO articlesDTO){
        return articlesService.updateArticle(articlesDTO);
    }

    // збс
    @DeleteMapping("/delete/{id}")
    public void deleteArt(@PathVariable Integer id){
        articlesService.deleteArticle(id);
    }

    @GetMapping("/article/full/{id}")
    public ArticleCommentDTO getArticleById(@PathVariable Integer id){
        return articlesService.getFullArticle(id);
    }
}
