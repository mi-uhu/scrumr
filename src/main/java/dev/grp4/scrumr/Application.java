package dev.grp4.scrumr;

import dev.grp4.scrumr.userStory.UserStory;
import dev.grp4.scrumr.userStory.UserStoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(UserStoryRepo userStoryRepo) {
		return args -> {
			userStoryRepo.save(new UserStory(null, "Test", "Desc", "Criteria", 5, 1, 0 ));
			userStoryRepo.save(new UserStory(null, "Test2", "ancuancsa", "nfanwnoia", 3, 2, 1 ));
		};
	}
}
