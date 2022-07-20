package com.springjpa.springJPA.services;

import com.springjpa.springJPA.entities.Address;
import com.springjpa.springJPA.entities.Profile;
import com.springjpa.springJPA.repositories.AddressRepository;
import com.springjpa.springJPA.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ProfileRepository profileRepository;

    public List<Address> getAddressByUserIdAndProfileId(Integer userId, Integer profileId){
        return addressRepository.findAddressesByUserIdAndProfileId(userId,profileId);
    }

    public Address createAddres(Integer userId, Integer pofileId, Address address) {
       Optional<Profile> result= profileRepository.findByUserIdAndProfileId(userId, pofileId);
       if (result.isPresent()){
           address.setProfile(result.get());
           return addressRepository.save(address);
       }else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Profile %d and user %d not found",pofileId,userId));
       }
    }
}
