package com.wedding.entity;

import javax.persistence.*;

@Entity
@Table(name = "guest_roles", schema = "wedding")
public class GuestRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "guest_role_name", unique = true, length = 15, nullable = false)
    private String guestRoleName;

    public GuestRole() {
    }

    public GuestRole(String guestRoleName) {
        this.guestRoleName = guestRoleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestRoleName() {
        return guestRoleName;
    }

    public void setGuestRoleName(String guestRoleName) {
        this.guestRoleName = guestRoleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuestRole that = (GuestRole) o;

        if (guestRoleName != null ? !guestRoleName.equals(that.guestRoleName) : that.guestRoleName != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (guestRoleName != null ? guestRoleName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Guest_role{" +
                "id=" + id +
                ", guestRoleName='" + guestRoleName + '\'' +
                '}';
    }
}
