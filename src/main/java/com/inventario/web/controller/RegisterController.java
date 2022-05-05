package com.inventario.web.controller;

import com.inventario.domain.service.RegisterService;
import com.inventario.persistence.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Mercancias")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    //Controladores para hacer las busquedas segun nombre, id de quien registra y fecha de registro

    @GetMapping("/find/{name}")
    public ResponseEntity<List<Register>> findByName(@PathVariable("name") String name){
        return registerService.findByName(name)
                .map(registers -> new ResponseEntity<>(registers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Register>> findByUserRegister(@PathVariable("id") Long idUserRegister){
        return registerService.findByUserRegister(idUserRegister)
                .map(registers -> new ResponseEntity<>(registers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find/{date}")
    public ResponseEntity<List<Register>> findByDate(@PathVariable("date") LocalDate date){
        return registerService.findByDate(date)
                .map(registers -> new ResponseEntity<>(registers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //controladores para guardar, borrar y actualizar

    @PostMapping("/save")
    public ResponseEntity<Register> save(@RequestBody Register register){
        return new ResponseEntity<>(registerService.save(register), HttpStatus.CREATED);
    }

    @DeleteMapping("/Delete/{idRegister}/{idUserRegister}/{idUser}")
    public ResponseEntity delete(@PathVariable("idRegister") Long idR, @PathVariable("idUserRegister") int idUR, @PathVariable("idUser") int idU){
        if (registerService.delete(idR, idUR, idU)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
        public ResponseEntity<Register> update(@RequestBody Register register, @RequestParam("id") Long id){
        return new ResponseEntity<>(registerService.save(register), HttpStatus.CREATED);
    }
}
