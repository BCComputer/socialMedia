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
    private String title;
    private String authorName;
    private String body;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
