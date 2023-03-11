package dev.grp4.scrumr.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGrantedAuthority implements org.springframework.security.core.GrantedAuthority {

  @Id
  @GeneratedValue
  private Long id;
  private String authority;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Override
  public String getAuthority() {
    return authority;
  }
}
