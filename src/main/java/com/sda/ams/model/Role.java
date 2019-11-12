package com.sda.ams.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private Integer roleId;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer idRole) {
        this.roleId = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
