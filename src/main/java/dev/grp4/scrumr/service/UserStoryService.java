package dev.grp4.scrumr.service;

import dev.grp4.scrumr.model.UserStory;

import java.util.Collection;

public interface UserStoryService {
    UserStory create(UserStory userStory);
    UserStory update(UserStory userStory);
    Collection<UserStory> list(int limit);
    UserStory get(long userStoryId);
    boolean delete(long userStoryId);
}
