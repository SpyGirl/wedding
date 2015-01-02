package com.wedding.dao.impls;

import com.wedding.dao.UserDao;
import com.wedding.entity.Role;
import com.wedding.entity.User;

import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public User findByEmail(String email) {
        User user = (User) session.createQuery("FROM User u WHERE u.email= :email")
                .setParameter("email", email).uniqueResult();
        return user;
    }

    @Override
    public User findByLogin(String login) {
        User user = (User) session.createQuery("FROM User u WHERE u.login= :login")
                .setParameter("login", login).uniqueResult();
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findByFirstName(String firstName) {
        List<User> users = session.createQuery("FROM User u WHERE u.firstName= :firstName")
                .setParameter("firstName", firstName).list();
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findByLastName(String lastName) {
        List<User> users = session.createQuery("FROM User u WHERE u.lastName= :lastName")
                .setParameter("lastName", lastName).list();
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findByFullName(String firstName, String lastName) {
        List<User> users = session.createQuery("FROM User u WHERE u.lastName= :lastName " +
                "AND u.firstName= :firstName")
                .setParameter("lastName", lastName)
                .setParameter("firstName", firstName).list();
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findByGender(Character gender) {
        List<User> users = session.createQuery("FROM User u WHERE u.gender= :gender")
                .setParameter("gender", gender).list();
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findByRole(Role role) {
        List<User> users;
        if (role.getId() != null) {
            users = session.createQuery("FROM User u JOIN Role r ON u.role.id = :id")
                    .setParameter("id", role.getId()).list();
        } else if (role.getRoleName() != null) {
            users = session.createQuery("FROM User u JOIN Role r ON u.role.roleName = r.roleName " +
                    "WHERE r.roleName = :roleName")
                    .setParameter("roleName", role.getRoleName()).list();
        } else {
            users = null;
        }
        return users;
    }
}
