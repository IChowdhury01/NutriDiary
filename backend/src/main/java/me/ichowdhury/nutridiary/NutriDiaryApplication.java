package me.ichowdhury.nutridiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController		// Establish endpoint URLs on the web, in the URLs mentioned below.
public class NutriDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutriDiaryApplication.class, args);	// Initialize web app.
	}

	// Routing

	// Test route: http://localhost:8080/test?name=
	@GetMapping("/test")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		// RequestParam: allow user to assign a value to the variable "name"
		// in the request sent to this URL. If no name value, use name="World".

		return String.format("Hello %s!", name);
	}
}
