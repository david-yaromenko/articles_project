package edu.education.databases.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record ArticleCommentDTO(
        Integer id,

        String title,

        String textArticle,

        LocalDate addDate,

        LocalTime addTime,

        List<CommentsDTO> comments
) {
}
