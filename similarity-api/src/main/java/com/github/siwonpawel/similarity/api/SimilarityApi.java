package com.github.siwonpawel.similarity.api;

import com.github.siwonpawel.similarity.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        ServiceConfiguration.class,
})
public class SimilarityApi {

    public static void main(String[] args) {
        SpringApplication.run(SimilarityApi.class, args);
    }

}