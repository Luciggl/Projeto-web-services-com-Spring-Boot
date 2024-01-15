package com.luciggl.webservice.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVERSIONUID = 1L;

    private long ID;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(){

    }

    public User(long ID, String name, String email, String phone, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getID() == user.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }
}
