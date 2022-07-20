package com.springjpa.springJPA.services;

import com.springjpa.springJPA.entities.User;
//import com.springjpa.springJPA.model.UserModel;
import com.springjpa.springJPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /*//este es el get normal
    public List<User> getUsers(){
        return userRepository.findAll();
    }*/

    //este es el get con paginacion
    public Page<User> getUsers(int page, int size){
        return userRepository.findAll(PageRequest.of(page,size));
    }

    public Page<String> getUserName(int page, int size) {
        return userRepository.findUserNames(PageRequest.of(page,size));
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %u not found",id)));
    }

    public User getUserByUserName(String user_name){
        return userRepository.findByUsername(user_name).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %u not found",user_name)));
    }

    public User getUserByUserNameAndPass(String user_name, String pass){
        return userRepository.findByUsernameAndPassword(user_name,pass).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %s not found",user_name)));
    }


}
