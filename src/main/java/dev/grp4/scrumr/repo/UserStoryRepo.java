package dev.grp4.scrumr.repo;

import dev.grp4.scrumr.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepo extends JpaRepository<UserStory, Long> {
}
