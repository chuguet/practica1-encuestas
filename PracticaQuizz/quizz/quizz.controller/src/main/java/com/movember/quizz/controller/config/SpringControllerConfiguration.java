package com.movember.quizz.controller.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import com.movember.quizz.model.config.SpringModelConfiguration;

@Configuration
@ComponentScan({ "com.movember.quizz.controller" })
@Import(value = { SpringModelConfiguration.class })
public class SpringControllerConfiguration {
	@Bean
	public MappingJacksonJsonView mappingJacksonJsonView() {
		return new MappingJacksonJsonView();
	}

	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		final ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		contentNegotiatingViewResolver.setDefaultContentType(MediaType.APPLICATION_JSON);
		final ArrayList defaultViews = new ArrayList();
		defaultViews.add(mappingJacksonJsonView());
		contentNegotiatingViewResolver.setDefaultViews(defaultViews);
		return contentNegotiatingViewResolver;
	}
}
