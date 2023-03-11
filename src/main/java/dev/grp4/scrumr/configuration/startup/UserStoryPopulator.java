package dev.grp4.scrumr.configuration.startup;

import dev.grp4.scrumr.userStory.UserStory;
import dev.grp4.scrumr.userStory.UserStoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStoryPopulator implements CommandLineRunner {

  private final UserStoryRepo userStoryRepo;

  @Override
  public void run(String... args) throws Exception {
    userStoryRepo.save(new UserStory(null, "Test", "Desc", "Criteria", 5, 1, 0 ));
    userStoryRepo.save(new UserStory(null, "Test2", "ancuancsa", "nfanwnoia", 3, 2, 1 ));
  }
}
