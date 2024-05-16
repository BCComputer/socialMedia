package com.binary.socialmediaapp.controller;

import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping({"", "/list", "/postlist"})
    public String postPage(Model m) {
        m.addAttribute("posts", postService.findAllPosts());
        return "posts/postIndex";
    }

    @GetMapping("/create")
    public String createPostPage(Model model) {
        model.addAttribute("newPost", new Post());
        return "posts/createPostPage";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("newPost") Post newPost) {
        postService.addPost(newPost);
        // postService.savePost(newPost);

        return "redirect:/posts/list";
    }

    @GetMapping("/update/{id}")
    public String updatePostPage(@PathVariable("id") int id, Model model) {
        Optional<Post> optionalPost = postService.findById(id);
        Post updatedpost = null;
        if (optionalPost.isPresent()) {
            updatedpost = optionalPost.get();
        } else {
            return "redirect:/posts/List";
        }
        model.addAttribute("postNeedToUpdate", updatedpost);
        System.out.println(updatedpost);
        return "posts/updatePostPage";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") int id, @ModelAttribute("postNeedToUpdate") @Valid Post updatedPost, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors());
            return "posts/updatePostPage";
        }
        System.out.println(updatedPost);
        postService.updatePost(updatedPost);
        return "redirect:/posts/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePostPage(@PathVariable("id") int id){
        return "posts/deletePostPage";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") int id) {
        postService.deletePostById(id);
        return "redirect:/posts/list";
    }


}