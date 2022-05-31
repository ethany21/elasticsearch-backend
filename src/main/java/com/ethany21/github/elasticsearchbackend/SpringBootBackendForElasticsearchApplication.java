package com.ethany21.github.elasticsearchbackend;

import com.ethany21.github.elasticsearchbackend.configuration.ElasticsearchConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBackendForElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBackendForElasticsearchApplication.class, args);
    }

}
