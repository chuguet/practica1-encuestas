package com.movember.quizz.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.movember.quizz.controller" })
// @Import(value = { SpringModelConfiguration.class })
public class SpringControllerConfiguration {

}
