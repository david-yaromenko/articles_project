package edu.education.databases.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "Comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "article_id")
    private int articleId;
    @Column(name = "text_comment")
    private String textComment;
    @Column(name = "add_date")
    private LocalDate addDate;
    @Column(name = "add_time")
    private LocalTime addTime;

}
