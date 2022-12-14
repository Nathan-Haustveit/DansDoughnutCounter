package com.total_sacle.doughnuts.models;

import com.total_sacle.doughnuts.util.Password;

public class Employee {
    private long id;
    private String name;
    private String username;
    private String password;

    public Employee(){}

    public Employee(String name, String username, String password) {
        this.name = name;
        this.username = username;
        setPassword(password);
    }


    public Employee(long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Employee(long id, String name, String username, String password, long editEmployee) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }
}
