package com.wedding.dao;

import com.wedding.entity.GuestRole;
import com.wedding.entity.Guest;

import java.util.List;

public interface GuestDao {

    List<Guest> findByFirstName(String firstName);
    List<Guest> findByLastName(String lastName);
    List<Guest> findByFullName(String firstName, String lastName);
    List<Guest> findByGender(Character gender);
    List<Guest> findByEmail(String email);
    List<Guest> findByRole(GuestRole role);
    List<Guest> findByPhone(String phone);
    List<Guest> findByPlusOne(Boolean plusOne);
}
