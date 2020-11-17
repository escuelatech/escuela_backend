package com.escuela.api;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EscuelaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApiApplication.class, args);
	}
	
	@GetMapping("/hello")
	public Collection<String> sayHello() {
		return IntStream.range(0, 10)
				.mapToObj(i -> "Hello number " + i)
				.collect(Collectors.toList());
	}

}
