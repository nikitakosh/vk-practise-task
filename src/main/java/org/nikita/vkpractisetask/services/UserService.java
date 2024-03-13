package org.nikita.vkpractisetask.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.nikita.vkpractisetask.client.TypiCodeClient;
import org.nikita.vkpractisetask.models.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final TypiCodeClient client;

    public List<User> findAllUsers() {
        return client.findAllUsers();
    }

    public User addUser(User user) {
        return client.addUser(user);
    }

    public User updateUser(User user, int id) {
        return client.updateUser(user, id);
    }

    public void deleteUser(int id) {
        client.deleteUser(id);
    }

    public User findUser(int id) {
        return client.findUser(id);
    }
}
