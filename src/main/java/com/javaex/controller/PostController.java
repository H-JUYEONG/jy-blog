package com.javaex.controller;

import com.javaex.entity.Post;
import com.javaex.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.findAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postService.findPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Post>> getPostsByAuthor(@PathVariable Long authorId) {
        List<Post> posts = postService.findPostsByAuthorId(authorId);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> searchPosts(@RequestParam String keyword) {
        List<Post> posts = postService.searchPosts(keyword);
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post created = postService.createPost(post);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        Post updated = postService.updatePost(post);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}