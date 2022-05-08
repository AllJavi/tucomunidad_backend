package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Post;
import com.ISST18.tucomunidad.tucomunidad.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    PostService votacionService;

    public ArrayList<Post> getAllPost() {
        return votacionService.getAllPost();
    }

    public Post getPostById(Long id) {
        return votacionService.getPostById(id);
    }

    public void newPost(Post post) {
        votacionService.newPost(post);
    }

    public void delete(Long id) {
        votacionService.delete(id);
    }
    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/post")
    public int upVotedPost(Long postId) {
        return votacionService.upVotedPost(postId);
    }
    @CrossOrigin
    @PostMapping(path = "api/v1/comunidad/post/")
    public boolean newSubPost(Long parentPostId, Post post) {
        return votacionService.newSubPost(parentPostId, post);
    }
}