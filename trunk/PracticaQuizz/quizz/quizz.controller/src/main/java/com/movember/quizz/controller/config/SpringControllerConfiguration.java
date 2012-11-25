package com.movember.quizz.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.movember.quizz.model.config.SpringModelConfiguration;

@Configuration
@ComponentScan({ "com.movember.quizz.controller" })
@Import(value = { SpringModelConfiguration.class })
public class SpringControllerConfiguration {

}
