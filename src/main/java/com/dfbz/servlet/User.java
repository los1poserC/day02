package com.dfbz.servlet;

import java.io.Serializable;

/**
 * @author As_los
 * @date 2019/8/17  10:46
 */

public class User implements Serializable {
    private String id;
    private String username;

    public User() {
        super();
    }

    public User(String id, String username) {
        super();
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
