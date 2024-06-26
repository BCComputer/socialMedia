package com.binary.socialmediaapp.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    @NotNull(message = "the description is required")
    private String description;
    @NotNull(message = "the body is required")
    private String body;
    private String postStatus;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<Comment> comments;

}
