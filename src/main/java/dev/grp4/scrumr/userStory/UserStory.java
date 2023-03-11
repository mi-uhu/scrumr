package dev.grp4.scrumr.userStory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStory {
    @Id
    @GeneratedValue
    private Long userStoryId;
    @NotEmpty(message = "The User Story Name cannot be empty")
    private String name;
    private String description;
    private String acceptanceCriteria;
    private int storyPoints;
    private long stackRank;
    private long statusId;
}
