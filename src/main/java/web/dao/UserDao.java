package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> takeAll();
    User takeUser(int id);
    void saveUser(User user);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
