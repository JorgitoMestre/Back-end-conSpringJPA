package com.springjpa.springJPA.controllers;

import com.springjpa.springJPA.entities.Address;
import com.springjpa.springJPA.entities.Role;
import com.springjpa.springJPA.entities.User;
import com.springjpa.springJPA.entities.UserInRole;
import com.springjpa.springJPA.services.UserInRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/userinrole/user/{userId}/roll/{rollId}")
public class UserInRoleController {
    @Autowired
    private UserInRoleService service;

    /*@PostMapping  //funciona bien
    public ResponseEntity<UserInRole> createUserInRoll(@PathVariable("userId") Integer userId, @PathVariable("rollId") Integer rollId, @RequestBody UserInRole userInRole){
        return new ResponseEntity<>(service.createUserInRoll(userId,rollId, userInRole), HttpStatus.CREATED);
    }*/
    @PostMapping
    public ResponseEntity<UserInRole> createUserInRoll( @RequestBody UserInRole userInRole){
        return new ResponseEntity<>(service.createUserInRoll(userInRole), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UserInRole> getUserInRoll(@PathVariable("userId") Integer userId, @PathVariable("rollId") Integer rollId){
        return new ResponseEntity<>(service.getUserInRol(userId,rollId),HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<UserInRole>> getAllRollOfUser(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(service.getAllRollOfUser(userId),HttpStatus.OK);
    }
}
