package com.lql.rabbit.group2;

import java.io.Serializable;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 15:28
 */
public class User implements Serializable{
    private String name;
    private String pass;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
