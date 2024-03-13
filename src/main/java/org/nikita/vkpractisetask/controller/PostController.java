package org.nikita.vkpractisetask.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.nikita.vkpractisetask.models.Post;
import org.nikita.vkpractisetask.services.PostService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "posts", key = "#id")
    public Post findPost(@PathVariable("id") int id) {
        return postService.findPost(id);
    }

    @PostMapping
    @CachePut(cacheNames = "posts", key = "#post.id")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/{id}")
    @CachePut(cacheNames = "posts", key = "#post.id")
    public Post updatePost(@RequestBody Post post, @PathVariable("id") int id) {
        return postService.updatePost(post, id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames = "posts", key = "#id")
    public void deletePost(@PathVariable("id") int id) {
        postService.deletePost(id);
    }
}
