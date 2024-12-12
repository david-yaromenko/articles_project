package edu.education.databases.repository;

import edu.education.databases.bean.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

//    @Query(value = """
//            SELECT * FROM Comments WHERE article_id = :id""", nativeQuery = true)
//    List<Comments> findAllComment(Integer id);

    List<Comments> findAllByArticleId(Integer articleId);

}
