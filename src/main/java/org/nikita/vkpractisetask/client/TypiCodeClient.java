package org.nikita.vkpractisetask.client;

import java.util.List;
import java.util.Objects;
import org.nikita.vkpractisetask.models.Album;
import org.nikita.vkpractisetask.models.Post;
import org.nikita.vkpractisetask.models.User;
import org.springframework.web.reactive.function.client.WebClient;


public class TypiCodeClient {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private final WebClient webClient;

    public TypiCodeClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public List<Post> fetchAllPosts() {
        return List.of(Objects.requireNonNull(webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToMono(Post[].class)
                .block()));
    }

    public List<Album> findAllAlbums() {
        return List.of(Objects.requireNonNull(webClient.get()
                .uri("/albums")
                .retrieve()
                .bodyToMono(Album[].class)
                .block()));
    }

    public Post addPost(Post post) {
        return webClient.post()
                .uri("/posts")
                .bodyValue(post)
                .header("Content-type", "application/json; charset=UTF-8")
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }

    public Post updatePost(Post post, int id) {
        return webClient.put()
                .uri("/posts/{id}", id)
                .bodyValue(post)
                .header("Content-type", "application/json; charset=UTF-8")
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }

    public void deletePost(int id) {
        webClient.delete()
                .uri("/posts/{id}", id)
                .retrieve();
    }



    public Album addAlbum(Album album) {
        return webClient.post()
                .uri("/albums")
                .bodyValue(album)
                .header("Content-type", "application/json; charset=UTF-8")
                .retrieve()
                .bodyToMono(Album.class)
                .block();
    }

    public Album updateAlbum(Album album, int id) {
        return webClient.put()
                .uri("/albums/{id}", id)
                .bodyValue(album)
                .header("Content-type", "application/json; charset=UTF-8")
                .retrieve()
                .bodyToMono(Album.class)
                .block();
    }

    public void deleteAlbum(int id) {
        webClient.delete()
                .uri("/albums/{id}", id)
                .retrieve();
    }

    public List<User> findAllUsers() {
        return List.of(Objects.requireNonNull(webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(User[].class)
                .block()));
    }

    public User addUser(User user) {
        return webClient.post()
                .uri("/users")
                .bodyValue(user)
                .header("Content-type", "application/json; charset=UTF-8")
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    public User updateUser(User user, int id) {
        return webClient.put()
                .uri("/users/{id}", id)
                .bodyValue(user)
                .header("Content-type", "application/json; charset=UTF-8")
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    public void deleteUser(int id) {
        webClient.delete()
                .uri("/users/{id}", id)
                .retrieve();
    }

    public Post findPost(int id) {
        return webClient.get()
                .uri("posts/{id}", id)
                .retrieve()
                .bodyToMono(Post.class)
                .block();
    }

    public Album findAlbum(int id) {
        return webClient.get()
                .uri("/albums/{id}", id)
                .retrieve()
                .bodyToMono(Album.class)
                .block();
    }

    public User findUser(int id) {
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
