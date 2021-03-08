package com.bezkoder.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @GetMapping(value = "/listuser" )
    public List<User> usersList(){
        return  userRepository.findusers_enc("encadrant");

    } 
    
    @GetMapping(value = "/allusers" )
    public List<User> users(){
        return  userRepository.findusers_enc("rapporteur");

    }

    /* ////////////////////////////find////////////////////// */
    @GetMapping(value = "/user/{id}" )
    public User user(@PathVariable(name = "id") Long id ) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping(value = "/deleteuser/{id}" )
    public void Delete(@PathVariable(name = "id") Long id ) {
        userRepository.deleteById(id);

    }
    Set<Role> roles = new HashSet<>();

   /* @GetMapping(value = "/userbyrole" )
    public List<User> usersListbyrole(){
        return  userRepository.findByRole(false);

    }
*/


}
