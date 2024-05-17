package com.binary.socialmediaapp.services;

import com.binary.socialmediaapp.models.Comment;
import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepo repo;
    private final CommentService commentService;
    public void addPost(Post post){
        repo.addPost(post);
    }
    public List<Post> findAllPosts(){
        List<Post> posts = repo.getAllPosts();
       /* posts.stream()
                .map(post -> {
          post.setComments(commentService.getAllCommentsById(post.getId()));
          return post;
        }).collect(Collectors.toList());*/

        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            List<Comment> comments = commentService.getAllCommentsById(post.getId());
            post.setComments(comments);
        }
        return repo.getAllPosts();
    }

    public Optional<Post> findById(int id){
        return repo.getPostById(id);
    }
    public void updatePost(Post post){
        repo.updatePost(post);

    }
    public void deletePostById(int id){
        repo.removePostById(id);

    }
}
