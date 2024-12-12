package edu.education.databases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//класс по запуску аппки и работы с бинами
@SpringBootApplication
public class DatabasesApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(DatabasesApplication.class, args);
    }
}
