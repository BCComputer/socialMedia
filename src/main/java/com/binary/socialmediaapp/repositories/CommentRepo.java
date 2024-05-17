package com.binary.socialmediaapp.repositories;

import com.binary.socialmediaapp.models.Comment;
import com.binary.socialmediaapp.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CommentRepo {

    List<Comment> comments = new ArrayList<>();
    private int id = 0;

    public CommentRepo() {
       /* Comment comment1 = new Comment();
        comment1.setCommentMessage("Hey its nice post!");
        comment1.setAuthorName("Bishnu");

        Comment comment2 = new Comment();
        comment2.setCommentMessage("Hey ok ok post!");
        comment2.setAuthorName("Ramesh");

        Comment comment3 = new Comment();
        comment3.setCommentMessage("Hey bad post!");
        comment3.setAuthorName("hemanth");

        this.addComment(id, comment1);
        this.addComment(id, comment2);
        this.addComment(id, comment3);
*/
    }


  /*  public void addComment(int postId, Comment comment) {
        comment.setId(postId);
        comments.add(comment);
        id++;
    }*/

    public void addComment(int postId, Comment comment) {
        comment.setPostId(postId);
        comments.add(comment);
        id++;
    }

    public List<Comment> getAllCommentsByPostId(int postId) {

        return comments.stream()
                .filter(post -> post.getPostId() == postId)
                .collect(Collectors.toList());
    }
    public void removeCommentById(int id){
        for (int i = 0; i < comments.size(); i++) {
            if(comments.get(i).getId()==(id)){
                comments.remove(i);
                break;
            }
        }

    }

    public Optional<Comment> getCommentById(int id){
        return comments.stream().filter(comment -> comment.getId()==id).findFirst();
    }

    public void updateComment (Comment updateComment){
        for (int i = 0; i < comments.size(); i++) {
            if(comments.get(i).getId()==(updateComment.getId())){
                comments.set(i, updateComment);
                break;
            }
        }
    }
}

