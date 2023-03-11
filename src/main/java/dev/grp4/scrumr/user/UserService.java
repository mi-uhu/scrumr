package dev.grp4.scrumr.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService { //extends UserDetailsService {
  void create(User user);
  void update(User user);
  boolean delete(long userId);
  User get(long userId);
}
