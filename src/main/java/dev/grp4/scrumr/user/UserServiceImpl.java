package dev.grp4.scrumr.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

//  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info( "Fetching user by username='{}'", username);
    return userRepo.findByUsername(username)
      .orElseThrow( () -> new UsernameNotFoundException("Username '" + username + "' not found.") );
  }

  @Override
  public User get(long userId) {
    log.info("Fetching user by id='{}'", userId);
    return userRepo.findById(userId).orElseThrow();
  }

  @Override
  public void create(User user) {
    log.info("Create user username='{}'", user.getUsername());
    userRepo.save(user);
  }

  @Override
  public void update(User user) {
    log.info("Update user id='{}' username='{}'", user.getUserId(), user.getUsername());
    userRepo.save(user);

  }

  @Override
  public boolean delete(long userId) {
    log.info("Delete user id='{}'", userId);
    userRepo.deleteById(userId);
    return true;
  }
}
