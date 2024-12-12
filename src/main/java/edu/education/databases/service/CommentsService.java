package edu.education.databases.service;

import edu.education.databases.dto.CommentsDTO;
import edu.education.databases.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final MapperService mapperService;

    public List<CommentsDTO> findAllCommentByArticle(Integer id){
        return commentsRepository.findAllByArticleId(id).stream()
                .map(mapperService::commentToDto)
                .toList();
    }

    public CommentsDTO createComment(CommentsDTO commentsDTO){
        var create = commentsRepository.save(mapperService.commentToEntity(commentsDTO));
        return mapperService.commentToDto(create);
    }

    public void deleteComment(Integer id){
        commentsRepository.deleteById(id);
    }
}
