package com.inventario.web.controller;

import com.inventario.domain.service.RegisterService;
import com.inventario.domain.service.UserService;
import com.inventario.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    //Operaciones basicas para la entidad usuario
    @GetMapping("/All")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<User> update(User user, Long id){
        return new ResponseEntity<>(userService.update(user, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }



}
