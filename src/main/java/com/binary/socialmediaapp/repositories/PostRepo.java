package com.binary.socialmediaapp.repositories;

import com.binary.socialmediaapp.models.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepo {
    private final List<Post> posts = new ArrayList<>();

    public PostRepo(){
        Post post = new Post();
        post.setTitle("Hello Spring MVC");
        post.setDescription("Starting Spring MVC");
        post.setBody("SpringBoot is fun");
        post.setCreatedOn(LocalDateTime.now());

        Post post1 = new Post();
        post1.setTitle("Hello Lets go for movie");
        post1.setDescription("lord of the rings");
        post1.setBody("Good movie");
        post1.setCreatedOn(LocalDateTime.now());

        Post post2 = new Post();
        post2.setTitle("Lets Party");
        post2.setDescription("Do on long weekend");
        post2.setBody("Plain it");
        post2.setCreatedOn(LocalDateTime.now());

        posts.add(post);
        posts.add(post1);
        posts.add(post2);

    }
    public void addPost(Post post){

        posts.add(post);

    }

    public List<Post> getAllPosts(){
        return posts;
    }

}
