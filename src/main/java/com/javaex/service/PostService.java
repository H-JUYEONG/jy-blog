package com.javaex.service;

import com.javaex.entity.Post;
import com.javaex.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Post> findAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional(readOnly = true)
    public List<Post> findPostsByAuthorId(Long authorId) {
        return postRepository.findByAuthorIdOrderByCreatedAtDesc(authorId);
    }

    @Transactional(readOnly = true)
    public List<Post> searchPosts(String keyword) {
        return postRepository.searchByKeyword(keyword);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}