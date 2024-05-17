package com.binary.socialmediaapp.controller;

import com.binary.socialmediaapp.models.Comment;
import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.services.CommentService;
import com.binary.socialmediaapp.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
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
    private final CommentService commentService;

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
            //System.out.println(errors.getAllErrors());
            return "posts/updatePostPage";
        }
      //  System.out.println(updatedPost);
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

    //////////////////////////////////////Comment Section /////////////////////////////////////

    @PostMapping("/{id}/addComment")
    public String createComment(@ModelAttribute("newPost") Comment comment, @PathVariable ("id") int id) {
        commentService.addComment(id, comment);
        return "redirect:/posts/list";
    }
    @GetMapping("/{id}/addComment")
    public String createComment(Model model) {
        model.addAttribute("newComment", new Comment());
        return "posts/createComment";
    }
    @GetMapping("/deleteComment/{id}")
    public String deleteCommentPage(@PathVariable("id") int id){
        return "posts/deleteCommentPage";
    }

    @PostMapping("/deleteComment/{id}")
    public String deleteCommentById(@PathVariable("id") int id) {
        commentService.deleteCommentById(id);
        return "redirect:/posts/list";
    }

    @GetMapping("/updateComment/{id}")
    public String updateCommentPage(@PathVariable("id") int id, Model model) {
        Optional<Comment> optionalComment = commentService.findById(id);
        Comment updatedComment = null;
        if (optionalComment.isPresent()) {
            updatedComment = optionalComment.get();
        } else {
            return "redirect:/posts/List";
        }
        model.addAttribute("commentNeedToUpdate", updatedComment);
        //System.out.println(updatedComment);
        return "posts/updateCommentPage";
    }

    @PostMapping("/updateComment/{id}")
    public String updateComment(@PathVariable("id") int id, @ModelAttribute("postNeedToUpdate") @Valid Comment updatedComment, Errors errors) {
        if (errors.hasErrors()) {
            //System.out.println(errors.getAllErrors());
            return "posts/updateCommentPage";
        }
        //  System.out.println(updatedPost);
        commentService.updateComment(updatedComment);
        return "redirect:/posts/list";
    }

}