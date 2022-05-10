package com.ISST18.tucomunidad.tucomunidad.controller;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Post;
import com.ISST18.tucomunidad.tucomunidad.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok().body(post.toString());
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
    public ResponseEntity<Integer> upVotedPost(@RequestParam Long postId) {
        return ResponseEntity.ok().body(postService.upVotedPost(postId));
        
    }

    @CrossOrigin
    @PostMapping(path = "api/v1/post/{id}/")
    public boolean newSubPost(@PathVariable Long parentPostId, @RequestBody Post post) {
        return postService.newSubPost(parentPostId, post);
    }

    @CrossOrigin
    @GetMapping(path = "api/v1/comunidad/{id}/post")
    public ResponseEntity<ArrayList<String>> getPostBycomunityCode(String comunityCode){
        ArrayList<String> postsStr = new ArrayList<String>();
        for (Post post : postService.getPostBycomunityCode(comunityCode)){
            postsStr.add(post.toString());
        }
        return ResponseEntity.ok().body(postsStr); 
    }
}