package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> takeAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User takeUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User userUpdater) {
        User userToUpdate = entityManager.find(User.class, id);
        userToUpdate.setName(userUpdater.getName());
        userToUpdate.setEmail(userUpdater.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
