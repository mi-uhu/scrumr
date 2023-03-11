package dev.grp4.scrumr.auth;

import dev.grp4.scrumr.http.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthResource {

  private final JwtEncoder encoder;

  @PostMapping("")
  public ResponseEntity<Response> auth(Authentication authentication) {
    Instant now = Instant.now();
    long expiry = 36000L;
    String scope = authentication.getAuthorities().stream()
      .map(GrantedAuthority::getAuthority)
      .collect(Collectors.joining(","));
    JwtClaimsSet claims = JwtClaimsSet.builder()
      .issuer("self")
      .issuedAt(now)
      .expiresAt(now.plusSeconds(expiry))
      .subject(authentication.getName())
      .claim("scope", scope)
      .build();

    return ResponseEntity.ok(
      Response.builder()
        .timeStamp(now())
        .data(Map.of("bearer-token", this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue()))
        .message("Login successful")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
  }
}
