package edu.education.databases.repository;

import edu.education.databases.bean.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

//2
public interface ArticlesRepository extends JpaRepository<Articles, Integer> { //Articles - бин, Integer - тип айди

}
