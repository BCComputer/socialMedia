package com.binary.socialmediaapp.services;

import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepo repo;
    public void addPost(Post post){
        repo.addPost(post);
    }
    public List<Post> findAllPosts(){
        return repo.getAllPosts();
    }
}
