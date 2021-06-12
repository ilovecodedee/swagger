package com.xhl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户实体类")

public class User {
    @ApiModelProperty("实体类写的姓名标识")
    private String name;
    @ApiModelProperty("实体类写的年龄")
    private String old;

    public User() {
    }

    public User(String name, String old) {
        this.name = name;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", old='" + old + '\'' +
                '}';
    }
}
