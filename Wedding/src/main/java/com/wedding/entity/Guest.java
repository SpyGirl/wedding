package com.wedding.entity;

import javax.persistence.*;

@Entity
@Table(name = "guests", schema = "wedding")
public class Guest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 25)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_role", insertable = false, updatable = false)
    private GuestRole role;

    @Column(name = "phone", nullable = true, length = 15)
    private String phone;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Column(name = "gender", nullable = false)
    private Character gender;

    @Column(name = "plus_one")
    private Boolean plusOne;

    @Column(name = "note")
    private String note;

    public Guest() {
    }

    public Guest(String firstName, String lastName, GuestRole role, String phone, String email, Character gender, Boolean plusOne, String note) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.plusOne = plusOne;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GuestRole getRole() {
        return role;
    }

    public void setRole(GuestRole role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Boolean getPlusOne() {
        return plusOne;
    }

    public void setPlusOne(Boolean plusOne) {
        this.plusOne = plusOne;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guest guest = (Guest) o;

        if (email != null ? !email.equals(guest.email) : guest.email != null) return false;
        if (firstName != null ? !firstName.equals(guest.firstName) : guest.firstName != null) return false;
        if (gender != null ? !gender.equals(guest.gender) : guest.gender != null) return false;
        if (id != null ? !id.equals(guest.id) : guest.id != null) return false;
        if (lastName != null ? !lastName.equals(guest.lastName) : guest.lastName != null) return false;
        if (note != null ? !note.equals(guest.note) : guest.note != null) return false;
        if (phone != null ? !phone.equals(guest.phone) : guest.phone != null) return false;
        if (plusOne != null ? !plusOne.equals(guest.plusOne) : guest.plusOne != null) return false;
        if (role != null ? !role.equals(guest.role) : guest.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (plusOne != null ? plusOne.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", plusOne=" + plusOne +
                ", note='" + note + '\'' +
                '}';
    }
}
