package com.lapshov.spring_boot_3_1_3.service;

import com.lapshov.spring_boot_3_1_3.model.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(long id);

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
