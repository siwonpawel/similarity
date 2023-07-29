package com.github.siwonpawel.similarity;

import com.github.siwonpawel.similarity.data.DataConfiguration;
import com.github.siwonpawel.similarity.mappers.TaskMapper;
import com.github.siwonpawel.similarity.services.TaskService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        DataConfiguration.class
})
@ComponentScan(basePackageClasses = {
        TaskMapper.class,
        TaskService.class
})
public class ServiceConfiguration {
}
