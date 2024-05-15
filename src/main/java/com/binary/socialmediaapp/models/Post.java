package com.binary.socialmediaapp.models;

import com.binary.socialmediaapp.enums.PostStatus;
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
    private String description;
    private String body;
    private String postStatus;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<Comment> comments;

}
