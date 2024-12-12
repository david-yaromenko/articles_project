package edu.education.databases.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ArticlesDTO(

        Integer id,

        String title,

        String textArticle,

        LocalDate addDate,

        LocalTime addTime

){}
