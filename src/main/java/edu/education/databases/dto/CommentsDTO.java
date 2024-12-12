package edu.education.databases.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public record CommentsDTO(

        Integer id,

        int articleId,

        String textComment,

        LocalDate addDate,

        LocalTime addTime

) {
}
