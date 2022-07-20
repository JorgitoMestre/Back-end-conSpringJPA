package com.springjpa.springJPA.controllers;

import com.springjpa.springJPA.entities.Address;
import com.springjpa.springJPA.entities.Profile;
import com.springjpa.springJPA.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/profiles/{profileId}/addresses")
public class AddressController {

    @Autowired
    private AddressService service;
    @GetMapping
    public ResponseEntity<List<Address>> findAddressesByProfileId(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer pofileId){
           return new ResponseEntity<>(service.getAddressByUserIdAndProfileId(userId, pofileId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer pofileId, @RequestBody Address address){
        return new ResponseEntity<>(service.createAddres(userId,pofileId,address),HttpStatus.CREATED);
    }
}
