package dev.grp4.scrumr.configuration.startup;

import dev.grp4.scrumr.auth.Roles;
import dev.grp4.scrumr.user.User;
import dev.grp4.scrumr.user.UserGrantedAuthority;
import dev.grp4.scrumr.user.UserGrantedAuthorityRepo;
import dev.grp4.scrumr.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class UserPopulator implements CommandLineRunner {

  private final UserRepo userRepo;
  private final UserGrantedAuthorityRepo userGrantedAuthorityRepo;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    populate("username", "password", Roles.USER);
    populate("user2", "pass123!", Roles.USER);
  }

  private void populate(String username, String password, String roles) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(password));
    user.setEnabled(true);
    user.setCredentialsNonExpired(true);
    user.setAccountNonExpired(true);
    user.setAccountNonLocked(true);

    UserGrantedAuthority grantedAuthority = new UserGrantedAuthority();
    grantedAuthority.setAuthority(roles);
    grantedAuthority.setUser(user);
    userRepo.save(user);
    userGrantedAuthorityRepo.save(grantedAuthority);
    user.setAuthorities(Collections.singleton(grantedAuthority));

  }
}
