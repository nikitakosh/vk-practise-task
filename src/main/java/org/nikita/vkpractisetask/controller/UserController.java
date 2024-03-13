package org.nikita.vkpractisetask.controller;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.nikita.vkpractisetask.models.User;
import org.nikita.vkpractisetask.services.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "users", key = "#id")
    public User findUser(@PathVariable("id") int id) {
        return userService.findUser(id);
    }

    @PostMapping
    @CachePut(cacheNames = "users", key = "#user.id")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    @CachePut(cacheNames = "users", key = "#user.id")
    public User updateUser(@RequestBody User user, @PathVariable("id") int id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames = "users", key = "#id")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
