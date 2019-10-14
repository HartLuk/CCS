package com.web.model.security.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
		return factory ->{
			ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400/" + HttpStatus.BAD_REQUEST);
			ErrorPage errorPage401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401/" + HttpStatus.UNAUTHORIZED);
			ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403/" + HttpStatus.FORBIDDEN);
			ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404/" + HttpStatus.NOT_FOUND);
			ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500/" + HttpStatus.INTERNAL_SERVER_ERROR);

			factory.addErrorPages(errorPage400, errorPage401, errorPage403, errorPage404, errorPage500);
		};
	}
}
