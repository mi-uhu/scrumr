package dev.grp4.scrumr.userStory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepo extends JpaRepository<UserStory, Long> {
}
