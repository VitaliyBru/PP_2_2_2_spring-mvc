package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<web.models.User> findAll() {
        return userDao.takeAll();
    }

    @Override
    public web.models.User findOneById(Integer id) {
        if (id == null) {
            id = 0;
        }
        return userDao.takeUser(id);
    }

    @Transactional
    @Override
    public void saveUser(web.models.User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void updateUser(int id, web.models.User user) {
        userDao.updateUser(id, user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.deleteUser(id);
    }
}
