package com.lapshov.spring_boot_3_1_3.controller;

import com.lapshov.spring_boot_3_1_3.model.Role;
import com.lapshov.spring_boot_3_1_3.model.User;
import com.lapshov.spring_boot_3_1_3.service.RoleService;
import com.lapshov.spring_boot_3_1_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("admin/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("admin/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("admin/authorities")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping(value = "admin")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("admin")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("admin/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
//        if (userService.existsUserById(id)) {
        userService.deleteUserById(id);
//        } else {
//            throw new RuntimeException("User doesn't exists for id: - " + id);
//        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}