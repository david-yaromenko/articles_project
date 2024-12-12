package edu.education.databases.service;

import edu.education.databases.bean.Articles;
import edu.education.databases.bean.Comments;
import edu.education.databases.dto.ArticleCommentDTO;
import edu.education.databases.dto.ArticlesDTO;
import edu.education.databases.dto.CommentsDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class MapperService {

    //mapping article

    public static ArticlesDTO articleToDto(Articles articles) {
        return new ArticlesDTO(
                articles.getId(),
                articles.getTitle(),
                articles.getTextArticle(),
                articles.getAddDate(),
                articles.getAddTime());
    }
    public static Articles articleToEntity(ArticlesDTO articlesDTO) {
        var article = new Articles();
        article.setId(articlesDTO.id());
        article.setTitle(articlesDTO.title());
        article.setTextArticle(articlesDTO.textArticle());
        article.setAddDate(LocalDate.now());
        article.setAddTime(LocalTime.now());
        return article;
    }
    //для получения статьи и ее комментов
    public static ArticleCommentDTO articleCommentToDTO(Articles articles, List<CommentsDTO> comments){
        return new ArticleCommentDTO(
                articles.getId(),
                articles.getTitle(),
                articles.getTextArticle(),
                articles.getAddDate(),
                articles.getAddTime(),
                comments);
    }

    //mapping comment
    public CommentsDTO commentToDto(Comments comments){
        return new CommentsDTO(
                comments.getId(),
                comments.getArticleId(),
                comments.getTextComment(),
                comments.getAddDate(),
                comments.getAddTime());
    }

    public Comments commentToEntity(CommentsDTO commentsDTO){
        var entity = new Comments();
        entity.setId(commentsDTO.id());
        entity.setArticleId(commentsDTO.articleId());
        entity.setTextComment(commentsDTO.textComment());
        entity.setAddDate(LocalDate.now());
        entity.setAddTime(LocalTime.now());

        return entity;
    }
}
