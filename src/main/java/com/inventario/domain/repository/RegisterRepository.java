package com.inventario.domain.repository;

import com.inventario.persistence.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

    //Querys nativos para busquedas sql por nombre, usuario y fecha
    @Query(value = "select * from pruebas.\"Register\" where pruebas.\"Register\".\"name\" = :name",
            nativeQuery = true)
    Optional<List<Register>> findByName(@Param("name") String name);

    @Query(value = "select * from pruebas.\"Register\" where pruebas.\"Register\".\"idUser\" = :id",
        nativeQuery = true)
    Optional<List<Register>> findByUserRegister(@Param("id") Long idUserRegister);

    @Query(value = "select * from pruebas.\"Register\" where pruebas.\"Register\".\"date\" = :date",
            nativeQuery = true)
    Optional<List<Register>> findByDate(@Param("date") LocalDate date);


}
