package dev.grp4.scrumr.userStory;

import dev.grp4.scrumr.auth.Roles;
import dev.grp4.scrumr.general.Response;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.*;
import static org.springframework.http.HttpStatus.*;

@RolesAllowed(Roles.USER)
@RestController
@RequestMapping("/api/userStory")
@RequiredArgsConstructor
public class UserStoryResource {
    private final UserStoryServiceImpl userStoryService;

    @GetMapping("/list")
    public ResponseEntity<Response> getUserStories() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("userStories", userStoryService.list(100)))
                        .message("User Stories retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PutMapping("/save")
    public ResponseEntity<Response> save(@RequestBody @Valid UserStory userStory) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("userStory", userStoryService.create(userStory)))
                        .message("User Story saved")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getUserStory(@PathVariable("id") long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("userStory", userStoryService.get(id)))
                        .message("User Story retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUserStory(@PathVariable("id") long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", userStoryService.delete(id)))
                        .message("User Story deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
