package com.example.springboot;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * This method runs once when the application starts up
	 *
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner runAtStartOfApplicationContext(UserRepository repository) {
		return (args) -> {
			Iterable<User> iter = repository.findAll();

			if (!iter.iterator().hasNext()) {
				User user = new User();
				user.setName("Jaron");
				repository.save(user);
			}
		};
	}
}
