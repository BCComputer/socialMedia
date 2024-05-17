package com.binary.socialmediaapp.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private int postId;
    private String authorName;
    private String commentMessage;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
