package com.bezkoder.springjwt.controllers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.springjwt.models.avis;
import com.bezkoder.springjwt.repository.AvisRepository;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AvisController {
@Autowired
   private UserController userController ;
    @Autowired
    private AvisRepository avisRepository ;
    @PostMapping("/addavis/{user_id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> ajouteravis(@PathVariable(value = "user_id") Long id_user , String description ) {
        String message = "";
    avis a = new avis(description,userController.user(id_user));
    avisRepository.save(a);
         message = "You successfully add ";

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    @GetMapping(value = "/listavis" )
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<avis> propoList(){
        return  avisRepository.findAll();

    }

    /* ////////////////////////////find////////////////////// */
    @GetMapping(value = "/avis/{id}" )
    public avis offre(@PathVariable(name = "id") Long id ) {
        return avisRepository.findById(id).get();
    }


}
