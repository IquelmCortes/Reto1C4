package com.example.demo.controllers;

import com.example.demo.persistence.entities.Usuarios;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService UsuarioService;

    @PostMapping(path="new")
    public ResponseEntity<Usuarios> saveNewUser(@RequestBody Usuarios user){
        Usuarios UserSaved = UsuarioService.saveEntity(user);
        if(UserSaved.getEmail() == null || UserSaved.getPassword() == null || UserSaved.getName() == null){
            return new ResponseEntity<>(UserSaved, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(UserSaved, HttpStatus.CREATED);
    }

    @GetMapping(path = "all")
    public List<Usuarios> getAllUser(){
        return UsuarioService.getEntity();
    }
    
    @GetMapping(path = "{email}")
    public boolean getByEmail(@PathVariable("email") String email){
        return UsuarioService.existeEmail(email);
    }
    
    @GetMapping(path = "{email}/{password}")
    public Usuarios getExistencia(@PathVariable("email") String email, @PathVariable("password") String password){
        Usuarios users = UsuarioService.ExisteUsuario(email, password);
        return users;
    }
}
