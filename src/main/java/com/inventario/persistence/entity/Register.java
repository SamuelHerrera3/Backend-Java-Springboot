package com.inventario.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//Mapeo tabla Registros
@Data
@Entity
@Table(name = "Register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegister;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDate date;


    //enlace FK entre tablas
    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    public Long getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Long idRegister) {
        this.idRegister = idRegister;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
