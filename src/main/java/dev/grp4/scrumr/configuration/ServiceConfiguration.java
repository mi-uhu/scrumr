package dev.grp4.scrumr.configuration;

import dev.grp4.scrumr.user.UserRepo;
import dev.grp4.scrumr.user.UserService;
import dev.grp4.scrumr.user.UserServiceImpl;
import dev.grp4.scrumr.userStory.UserStoryRepo;
import dev.grp4.scrumr.userStory.UserStoryService;
import dev.grp4.scrumr.userStory.UserStoryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

  @Bean
  public UserService userService(UserRepo userRepo) {
    return new UserServiceImpl(userRepo);
  }

  @Bean
  public UserStoryService userStoryService(UserStoryRepo userStoryRepo) {
    return new UserStoryServiceImpl(userStoryRepo);
  }
}
