package org.nikita.vkpractisetask.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.nikita.vkpractisetask.client.TypiCodeClient;
import org.nikita.vkpractisetask.models.Post;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final TypiCodeClient client;

    public List<Post> findAllPosts() {
        return client.fetchAllPosts();
    }

    public Post addPost(Post post) {
        return client.addPost(post);
    }

    public Post updatePost(Post post, int id) {
        return client.updatePost(post, id);
    }

    public void deletePost(int id) {
        client.deletePost(id);
    }

    public Post findPost(int id) {
        return client.findPost(id);
    }
}
