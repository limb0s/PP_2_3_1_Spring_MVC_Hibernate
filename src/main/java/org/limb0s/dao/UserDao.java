package org.limb0s.dao;

import org.limb0s.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);

    void updateUser(int id, User user);
}
