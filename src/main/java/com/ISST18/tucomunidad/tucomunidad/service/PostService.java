package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Post;
import com.ISST18.tucomunidad.tucomunidad.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public ArrayList<Post> getAllPost() {
        ArrayList<Post> posts = new ArrayList<Post>();
        postRepository.findAll().forEach(post -> posts.add(post));
        return posts;
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    public void newPost(Post post) {
        postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public int upVotedPost(Long postId) {
        Post post = getPostById(postId);
        delete(postId);
        post.setUpvoted(post.getUpvoted() + 1);
        newPost(post);
        return post.getUpvoted();
    }

    public boolean newSubPost(Long parentPostId, Post post) {
        Post aux = getPostById(parentPostId);
        aux.newSubPost(post);
        delete(aux.getId());
        newPost(aux);
        return true;
    }

    public ArrayList<Post> getPostByComunityId(long comunityId){
        ArrayList <Post> toShow = new ArrayList<Post>();
        ArrayList <Post> posts = getAllPost();
        posts.forEach(post -> { if(post.getComunidadId() == comunityId) toShow.add(post); });
        return toShow;
    }
}
