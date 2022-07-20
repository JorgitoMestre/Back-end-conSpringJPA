package com.springjpa.springJPA.controllers;

import com.springjpa.springJPA.entities.Profile;
import com.springjpa.springJPA.entities.User;
import com.springjpa.springJPA.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/users/{userId}/profiles") //el pasar el id en la
// url obliga a que para q exista un profile antes sea asignado a un user
@RestController
public class ProfileController {
    @Autowired
    private ProfileService service;

    @GetMapping("/{profileId}")
    public ResponseEntity<Profile> getById(@PathVariable("userId")Integer userId, @PathVariable("profileId")Integer porfileId){
        return new ResponseEntity<Profile>(service.getProfileById(userId,porfileId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Profile> create(@PathVariable("userId") Integer userId, @RequestBody Profile profile){
        return new ResponseEntity<Profile>(service.createProfile(userId,profile), HttpStatus.CREATED);

    }
}
