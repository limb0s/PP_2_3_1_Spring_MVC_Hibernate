package org.limb0s.service;

import org.limb0s.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);

    void updateUser(int id, User user);
}
