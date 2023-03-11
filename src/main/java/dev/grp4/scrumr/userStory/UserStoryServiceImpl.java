package dev.grp4.scrumr.userStory;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserStoryServiceImpl implements UserStoryService {
    private final UserStoryRepo userStoryRepo;

    @Override
    public UserStory create(UserStory userStory) {
        log.info( "Saving user story id='{}' name='{}'", userStory.getUserStoryId(), userStory.getName());
        return userStoryRepo.save(userStory);
    }

    @Override
    public UserStory update(UserStory userStory) {
        log.info( "Updating user story id='{}' name='{}'", userStory.getUserStoryId(), userStory.getName());
        return userStoryRepo.save(userStory);
    }

    @Override
    public Collection<UserStory> list(int limit) {
        log.info( "Fetching '{}' user stories", limit);
        return userStoryRepo.findAll(Pageable.ofSize(limit)).toList();
    }

    @Override
    public UserStory get(long userStoryId) {
        log.info( "Fetching user story by id='{}'", userStoryId);
        return userStoryRepo.findById(userStoryId).get();
    }

    @Override
    public boolean delete(long userStoryId) {
        log.info( "Deleting user story by id='{}'", userStoryId);
        userStoryRepo.deleteById(userStoryId);
        return true;
    }
}
