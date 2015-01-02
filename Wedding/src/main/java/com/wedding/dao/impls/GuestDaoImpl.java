package com.wedding.dao.impls;

import com.wedding.dao.GuestDao;
import com.wedding.entity.Guest;
import com.wedding.entity.GuestRole;

import java.util.List;

public class GuestDaoImpl extends BaseDaoImpl implements GuestDao {

    @Override
    public List<Guest> findByFirstName(String firstName) {
        List<Guest> guests = session.createQuery("FROM Guest g WHERE g.firstName= :firstName")
                .setParameter("firstName", firstName).list();
        return guests;
    }

    @Override
    public List<Guest> findByLastName(String lastName) {
        List<Guest> guests = session.createQuery("FROM Guest g WHERE g.lastName= :lastName")
                .setParameter("lastName", lastName).list();
        return guests;
    }

    @Override
    public List<Guest> findByFullName(String firstName, String lastName) {
        List<Guest> guests = session.createQuery("FROM Guest g WHERE g.lastName= :lastName " +
                "AND g.firstName= :firstName")
                .setParameter("lastName", lastName)
                .setParameter("firstName", firstName).list();
        return guests;
    }

    @Override
    public List<Guest> findByGender(Character gender) {
        List<Guest> guests = session.createQuery("FROM Guest g WHERE g.gender= :gender")
                .setParameter("gender", gender).list();
        return guests;
    }

    @Override
    public List<Guest> findByEmail(String email) {
        List<Guest> guests = session.createQuery("FROM Guest g WHERE g.email= :email")
                .setParameter("email", email).list();
        return guests;
    }

    @Override
    public List<Guest> findByRole(GuestRole role) {
        List<Guest> guests;
        if (role.getId() != null) {
            guests = session.createQuery("FROM Guest g JOIN GuestRole r ON g.role.id = r.id").list();
        } else if (role.getGuestRoleName() != null) {
            guests = session.createQuery("FROM Guest g JOIN GuestRole r ON g.role.guestRoleName = r.guestRoleName").list();
        } else {
            guests = null;
        }
        return guests;
    }

    @Override
    public List<Guest> findByPhone(String phone) {
        List<Guest> guests = session.createQuery("FROM Guest g WHERE g.phone= :phone")
                .setParameter("phone", phone).list();
        return guests;
    }

    @Override
    public List<Guest> findByPlusOne(Boolean plusOne) {
        List<Guest> guests = session.createQuery("FROM Guest g WHERE g.plusOne= :plusOne")
                .setParameter("plusOne", plusOne).list();
        return guests;
    }
}
