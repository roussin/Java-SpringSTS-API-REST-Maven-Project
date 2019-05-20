package io.christopheroussin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * L'annotation  @SpringBootApplication équivaut à utiliser  
 * @Configuration, 
 * @EnableAutoConfiguration et  
 * @ComponentScan avec ses attributs par défaut.
 * Donc @SpringBootApplication aide à configurer automatiquement Spring, 
 * et automatiquement scanner (Scan) le projet intégral afin de découvrir des composants de  Spring (Controller, Bean, Service,...)
 */

@SpringBootApplication
public class CourseApiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
	}

}
