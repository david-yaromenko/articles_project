package edu.education.databases.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public NewTopic newTopic(){
        return new NewTopic(
                "topic_one",
                1,
                (short)1
        );
    }

}
