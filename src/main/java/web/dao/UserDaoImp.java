package web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    EntityManagerFactory factory;
    @Autowired
    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
        this.factory = entityManagerFactory;
    }

    @Override
    public void saveUser(User user) {
        EntityManager entity = factory.createEntityManager();
        entity.getTransaction().begin();
        entity.persist(user);
        entity.getTransaction().commit();
    }

    @Override
    public void editUser(long id, User user){
        EntityManager entity = factory.createEntityManager();
        entity.getTransaction().begin();
        Query query = entity.createQuery("update User set name='"+ user.getName()+
                "', surname='"+user.getSurname()+"' where id="+id);
        query.executeUpdate();
        entity.getTransaction().commit();
    }


    @Override
    public void removeUserById(long id) {
        EntityManager entity = factory.createEntityManager();
        entity.getTransaction().begin();
        User user = showUserById(id);
        entity.remove(entity.contains(user) ? user : entity.merge(user));
        entity.getTransaction().commit();
    }

    @Override
    public User showUserById(long id) {
        EntityManager entity = factory.createEntityManager();
        TypedQuery<User> query = entity.createQuery("from User where id="+id, User.class);
        return query.getSingleResult();
    }


    @Override
    public List<User> getAllUsers() {
        EntityManager entity = factory.createEntityManager();
        TypedQuery<User> query = entity.createQuery("from User", User.class);
        return query.getResultList();
    }


}
