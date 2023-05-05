package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void editUser(long id, User user);
    void saveUser(User user);

    public User showUserById(long id);

    void removeUserById(long id);

    List<User> getAllUsers();

}
