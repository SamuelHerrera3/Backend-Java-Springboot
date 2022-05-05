package com.inventario.domain.service;

import com.inventario.domain.repository.RegisterRepository;
import com.inventario.persistence.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


//Acciones permitidas para la entidad Registros
@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;
    private Register register;

    //Buscar por nombre
    public Optional<List<Register>> findByName(String name){
        return registerRepository.findByName(name);
    }

    //Buscar por id del usuario que registra
    public Optional<List<Register>> findByUserRegister(Long idUserRegister){
        return registerRepository.findByUserRegister(idUserRegister);
    }

    //Buscar por fecha de registro
    public Optional<List<Register>> findByDate(LocalDate date){
        return registerRepository.findByDate(date);
    }

    //Eliminar registro
    public boolean delete(Long idRegister, int idUserRegister, int idUser){
        //solo se elimina si el usuario que ingreso y el usuario actual son los mismos
        //se pasa el usuario actual y el usuario que hizo el registro como parametros
        try{
            if(idUserRegister == idUser){
                registerRepository.deleteById(idRegister);
                return true;
            }
        }catch (Exception e){
            if(idUserRegister != idUser){
                return false;
            }
        }
        return true;
    }

    //Guardar registros
    public Register save(Register register) {
            try{
                //valido que no exista un registro con el mismo nombre
                if(register.getName() == null){
                    return registerRepository.save(register);
                }
            } catch (Exception e) {
                if(register.getName() != null){
                    return null;
                }
            }
        return register;
    }
    //Actualizar registros
    public Register update(Register register, Long id){
        //se edita si el registro existe, sino, retorna null
        try{
            if (register.getIdRegister() != null && registerRepository.existsById(register.getIdRegister())){
                return findByUserRegister(id).map(registers ->{
                            registerRepository.save(register);
                            return register;
                }).orElse( null);
            }
        }catch (Exception e){
            return null;
        }
        return register;
        }

    }


