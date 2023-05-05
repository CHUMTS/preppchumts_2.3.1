package web.service;

import web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void editUser(long id, User user);

    public User showUserById(long id);

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

}
