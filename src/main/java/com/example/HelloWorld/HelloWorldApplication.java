package com.example.HelloWorld;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="Hello World Project",
				 version="1.0.0",
				description = "this project is only for learning",
				termsOfService="runcode",
				contact = @Contact(
						name="Mr Rutvik",
						email = "runcodenow@gmail.com"

				),
				license=@License(
						name="licence",
						url="runcodenow"
				)



		)
)
@ComponentScan
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
		System.out.println("it works");

	}}

