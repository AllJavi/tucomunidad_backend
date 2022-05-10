package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Post;
import com.ISST18.tucomunidad.tucomunidad.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @CrossOrigin
    @GetMapping("api/v1/post")
    public ArrayList<Post> getAllPost() {
        return postService.getAllPost();
    }
    @CrossOrigin
    @GetMapping("api/v1/post({id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
    @CrossOrigin
    @PostMapping("api/v1/post/")
    public void newPost(@RequestBody Post post) {
        postService.newPost(post);
    }

    @CrossOrigin
    @GetMapping("api/v1/post/delete/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/post")
    public int upVotedPost(@RequestParam Long postId) {
        return postService.upVotedPost(postId);
    }
    @CrossOrigin
    @PostMapping(path = "api/v1/post/{id}/")
    public boolean newSubPost(@PathVariable Long parentPostId, @RequestBody Post post) {
        return postService.newSubPost(parentPostId, post);
    }
    @CrossOrigin
    @GetMapping(path = "api/v1/comunidad/{id}/post")
    public ArrayList<Post> getPostBycomunityCode(String comunityCode){
        return postService.getPostBycomunityCode(comunityCode); 
    }
}