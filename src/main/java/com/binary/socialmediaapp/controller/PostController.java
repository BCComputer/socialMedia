package com.binary.socialmediaapp.controller;

import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;

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

    /*@PostMapping("/create")
    public String createPost(@ModelAttribute Post newPost) {
        postService.addPost(newPost);

        return "redirect:/posts/list";
    }*/
    @PostMapping("/create")
    public String createPost(@ModelAttribute Post newPost) {
        postService.addPost(newPost);
        return "redirect:/posts/list";
    }
}
