package com.springjpa.springJPA.services;

import com.springjpa.springJPA.entities.Address;
import com.springjpa.springJPA.entities.Role;
import com.springjpa.springJPA.entities.User;
import com.springjpa.springJPA.entities.UserInRole;
import com.springjpa.springJPA.repositories.RoleRepository;
import com.springjpa.springJPA.repositories.UserInRoleRepository;
import com.springjpa.springJPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserInRoleService {
    @Autowired
    private UserInRoleRepository userInRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    /*public UserInRole createUserInRoll(Integer userId, Integer rollId,UserInRole userInRole) {
        Optional<User> result= userRepository.findById(userId);
        Optional<Role> result1= roleRepository.findById(rollId);
        if (result.isPresent() && result1.isPresent()){
           userInRole.setUser(result.get());
           userInRole.setRole(result1.get());
           return userInRoleRepository.save(userInRole);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Not found user %d or role %d",userId,rollId));
        }
    }*/

    public UserInRole createUserInRoll(UserInRole userInRole) {
        Optional<User> result= userRepository.findById(userInRole.getUser().getId());
        Optional<Role> result1= roleRepository.findById(userInRole.getRole().getId());
        if (result.isPresent() && result1.isPresent()){
            userInRole.setUser(result.get());
            userInRole.setRole(result1.get());
            return userInRoleRepository.save(userInRole);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Not found user %d or role %d",userInRole.getUser().getId(),userInRole.getRole().getId()));
        }
    }

    public UserInRole getUserInRol(Integer userId, Integer rollId) {
        //Optional<User> result= userRepository.findById(userId);
        //Optional<Role> result1= roleRepository.findById(rollId);
        Optional<UserInRole> result= userInRoleRepository.getUserInRole(userId,rollId);
        if (result.isPresent()){
            return result.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Not found any user %d with the role %d",userId,rollId));
        }
    }

    public List<UserInRole> getAllRollOfUser(Integer userId) {
        Optional<List<UserInRole>> result= userInRoleRepository.getAllRoleOfUser(userId);
        if (result.isPresent()){
            return result.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Not found any role for the user with id = %d",userId));
        }
    }
}
