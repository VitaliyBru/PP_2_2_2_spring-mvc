package web.services;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOneById(Integer id);

    void saveUser(User user);

    void updateUser(int id, User user);

    void delete(int id);
}
