package edu.education.databases.service;

import edu.education.databases.bean.ArticleTitleDate;
import edu.education.databases.dto.ArticleCommentDTO;
import edu.education.databases.dto.ArticlesDTO;
import edu.education.databases.repository.ArticleTitleDateRepository;
import edu.education.databases.repository.ArticlesRepository;
import edu.education.databases.repository.CommentsRepository;
import edu.education.databases.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ArticlesService {

    private final ArticlesRepository articlesRepository;
    private final ArticleTitleDateRepository articleTitleDateRepository;
    private final CommentsRepository commentsRepository;
    private final MapperService mapperService;

    public List<ArticlesDTO> getAllArticle() { //только для статей
        return articlesRepository.findAll()
                .stream()
                .map(MapperService::articleToDto).toList();
    }

    public ArticleCommentDTO getFullArticle(Integer id) { //статья и ее комментарии
        var article = articlesRepository.findById(id) //получаем статьию по йди
                .orElseThrow(() -> new NotFoundException("Article not found"));

        var comments = commentsRepository.findAllByArticleId(id)//получаем коммент по айди статьи
                .stream()
                .map(mapperService::commentToDto)
                .toList();

        return MapperService.articleCommentToDTO(article, comments);
    }

    public ArticleCommentDTO getFullArticle_V2(Integer id) {
        var article = articlesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Article not found"));

        var comments = article.getComments().stream()
                .map(mapperService::commentToDto)
                .toList();
        return MapperService.articleCommentToDTO(article, comments);
    }

    public Optional<ArticlesDTO> getArticle(Integer id) {

        var article = articlesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Article not found"));
        return Optional.of(MapperService.articleToDto(article));
    }

    public List<ArticleTitleDate> getAllArticleQuery() {
        return articleTitleDateRepository.findAll();
    }

    public ArticlesDTO createArticle(ArticlesDTO articlesDTO) {
        var entity = MapperService.articleToEntity(articlesDTO);
        entity.setId(null);
        var article = articlesRepository.save(entity);
        return MapperService.articleToDto(article);
    }

    public ArticlesDTO updateArticle(ArticlesDTO articlesDTO) {
        var entity = articlesRepository.findById(articlesDTO.id())
                .orElseThrow(() -> new NotFoundException("Article not found"));

        entity.setTitle(articlesDTO.title());
        entity.setTextArticle(articlesDTO.textArticle());
        entity.setAddDate(articlesDTO.addDate());

        return MapperService.articleToDto(articlesRepository.save(entity));
    }

    public void deleteArticle(Integer id) {
        articlesRepository.deleteById(id);
    }

}
