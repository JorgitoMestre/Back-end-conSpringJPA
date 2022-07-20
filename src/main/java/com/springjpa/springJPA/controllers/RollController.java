package com.springjpa.springJPA.controllers;

import com.springjpa.springJPA.entities.Address;
import com.springjpa.springJPA.entities.Role;
import com.springjpa.springJPA.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RollController {
    @Autowired
    private RoleService service;
    @GetMapping
    public ResponseEntity<List<Role>> getRoles(){
        return new ResponseEntity<List<Role>>(service.getRoles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
       return new ResponseEntity<Role>(service.createRole(role), HttpStatus.CREATED);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<Role> updateteRole(@PathVariable("roleId") Integer roleId,@RequestBody Role role){
        return new ResponseEntity<Role>(service.updateRole(roleId,role), HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteteRole(@PathVariable("roleId") Integer roleId){
        service.deleteRole(roleId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
