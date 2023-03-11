package dev.grp4.scrumr;

import dev.grp4.scrumr.model.UserStory;
import dev.grp4.scrumr.repo.UserStoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Application {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
        .httpBasic()
      .and()
      .authorizeHttpRequests()
      .requestMatchers("/api/login").permitAll()
      .requestMatchers("/api/**").authenticated()
      .anyRequest().permitAll();

      return http.build();
  }


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
