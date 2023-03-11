//package dev.grp4.scrumr.user;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Collection;
//import java.util.Set;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class User implements org.springframework.security.core.userdetails.UserDetails {
//
//  @Id
//  @GeneratedValue
//  private Long userId;
//  @NotEmpty(message = "The username cannot be empty")
//  private String username;
//  @NotEmpty(message = "The password cannot be empty")
//  private String password;
//  private boolean accountNonExpired;
//  private boolean accountNonLocked;
//  private boolean credentialsNonExpired;
//  private boolean enabled;
//
//  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//  private Set<UserGrantedAuthority> authorities;
//
//  @Override
//  public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
//    return this.authorities;
//  }
//
//  @Override
//  public String getPassword() {
//    return this.password;
//  }
//
//  @Override
//  public String getUsername() {
//    return this.username;
//  }
//
//  @Override
//  public boolean isAccountNonExpired() {
//    return this.accountNonExpired;
//  }
//
//  @Override
//  public boolean isAccountNonLocked() {
//    return this.accountNonLocked;
//  }
//
//  @Override
//  public boolean isCredentialsNonExpired() {
//    return this.credentialsNonExpired;
//  }
//
//  @Override
//  public boolean isEnabled() {
//    return this.enabled;
//  }
//}
