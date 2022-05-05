package com.inventario.domain.repository;

import com.inventario.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//Se heredan las operaciones basicas de la clase JPARepository
//por lo que no se necesita establecer querys
}
