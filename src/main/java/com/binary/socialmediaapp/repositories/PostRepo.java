package com.binary.socialmediaapp.repositories;

import com.binary.socialmediaapp.models.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepo {
    private final List<Post> posts = new ArrayList<>();
    private int id=0;
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

        this.addPost(post);
        this.addPost(post1);
        this.addPost(post2);
    }
    public void addPost(Post post){
        post.setId(id);
        posts.add(post);
        id++;
    }

    public List<Post> getAllPosts(){
        return posts;
    }

    public Optional<Post> getPostById(int id){
        return posts.stream().filter(post -> post.getId()==id).findFirst();
    }
    
    public void updatePost (Post updatedPost){
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId()==(updatedPost.getId())){
                posts.set(i, updatedPost);
                break;
            }
        }
    }
    public void removePostById(int id){
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId()==(id)){
                posts.remove(i);
                break;
            }
        }

    }
}
