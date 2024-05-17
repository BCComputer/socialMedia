package com.binary.socialmediaapp.services;

import com.binary.socialmediaapp.models.Comment;
import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.repositories.CommentRepo;
import com.binary.socialmediaapp.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo repo;
    public void addComment(int postId, Comment comment){
        commentRepo.addComment(postId, comment);
    }

    public List<Comment> getAllCommentsById(int postId){
        return commentRepo.getAllCommentsByPostId(postId);
    }

    public Optional<Comment> findById(int id){
        return commentRepo.getCommentById(id);
    }

    public void deleteCommentById(int id){
        commentRepo.removeCommentById(id);
    }
    public void updateComment(Comment comment){
        commentRepo.updateComment(comment);

    }

}
