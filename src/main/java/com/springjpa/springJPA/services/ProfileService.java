package com.springjpa.springJPA.services;

import com.springjpa.springJPA.entities.Profile;
import com.springjpa.springJPA.entities.User;
import com.springjpa.springJPA.repositories.ProfileRepository;
import com.springjpa.springJPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

    public Profile getProfileById(Integer userId, Integer profileId){
        return profileRepository.findByUserIdAndProfileId(userId,profileId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Pofile not found for user %d and profile %d",userId,profileId)));
    }
    public Profile createProfile(Integer userId,Profile profile){
        Optional<User> result=userRepository.findById(userId);
        if(result.isPresent()){
            profile.setUser(result.get());
            return profileRepository.save(profile);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %d not found", userId));
        }
    }
}
