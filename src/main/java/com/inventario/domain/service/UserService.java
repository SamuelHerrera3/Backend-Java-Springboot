package com.inventario.domain.service;

import com.inventario.domain.repository.UserRepository;
import com.inventario.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Acciones permitidas para la entidad usuario
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Obtener usuario por Id
    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }

    //Obtener todos los usuarios
    public List<User> getAll(){
        return userRepository.findAll();
    }

    //Guardar usuarios
    public User save(User user){
        return userRepository.save(user);
    }

    //Actualizar usuarios
    public User update(User user, Long id){
        //se edita si el registro existe, sino, retorna null
        try{
            if (user.getIdUser() != null && userRepository.existsById(user.getIdUser())){
                return getById(id).map(registers ->{
                    userRepository.save(user);
                    return user;
                }).orElse( null);
            }
        }catch (Exception e){
            return null;
        }
        return user;
    }

    //Eliminar usuarios
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
