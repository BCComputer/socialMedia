package com.binary.socialmediaapp.services;

import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
