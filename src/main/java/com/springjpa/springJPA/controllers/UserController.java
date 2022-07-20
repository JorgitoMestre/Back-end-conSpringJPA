package com.springjpa.springJPA.controllers;

import com.springjpa.springJPA.entities.User;
import com.springjpa.springJPA.services.UserService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    /*//este es para el metodo get
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }*/

    //este es para el get con paginación
    @GetMapping
    @Timed("get.users") //permie definir metricas a traves de micrometer y prometheus
    public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false,value = "page", defaultValue = "0") int page,
                                               @RequestParam(required = false,value = "size", defaultValue = "50") int size){
        return new ResponseEntity<>(service.getUsers(page, size), HttpStatus.OK);
    }

    @GetMapping("/usernames")
    public ResponseEntity<Page<String>> getUserName(@RequestParam(required = false,value = "page", defaultValue = "0") int page,
                                               @RequestParam(required = false,value = "size", defaultValue = "50") int size){
        return new ResponseEntity<>(service.getUserName(page, size), HttpStatus.OK);
    }

    @GetMapping("/{user}")
    public ResponseEntity<User> getUserById(@PathVariable("user") Integer userId){
        return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/username/{user}")
    public ResponseEntity<User> getUserByUserName(@PathVariable("user") String user_name){
        return new ResponseEntity<>(service.getUserByUserName(user_name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> getUserByUserNameAndPassword(@RequestBody User obj){
        return new ResponseEntity<>(service.getUserByUserNameAndPass(obj.getUsername(),obj.getPassword()), HttpStatus.OK);
    }
}
