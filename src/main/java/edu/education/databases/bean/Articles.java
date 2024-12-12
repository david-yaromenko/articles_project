package edu.education.databases.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//1
@Getter
@Setter
@Entity
@Table(name = "Articles")
@NoArgsConstructor
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "text_article")
    private String textArticle;
    @Column(name = "add_date")
    private LocalDate addDate;
    @Column(name = "add_time")
    private LocalTime addTime;




    @OneToMany(mappedBy = "articleId", fetch = FetchType.LAZY)//lazy - по запросу, eager - сразу все
    private List<Comments> comments;

}
