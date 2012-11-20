package quizz.movember.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import quizz.movember.model.config.SpringModelConfiguration;

@Configuration
@ComponentScan({ "quizz.movember" })
@Import(value = { SpringModelConfiguration.class })
public class SpringControllerConfiguration {

}
