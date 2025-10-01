/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Empleados")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private double salario;

    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    
    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fechaConcentracion;

    public Empleado() {
    }

    public Empleado(String nombre, String email, double salario, Estatus estatus, LocalDate fechaConcentracion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.estatus = estatus;
        this.fechaConcentracion = fechaConcentracion;
    }

    

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public LocalDate getFechaConcentracion() {
        return fechaConcentracion;
    }

    public void setFechaConcentracion(LocalDate fechaConcentracion) {
        this.fechaConcentracion = fechaConcentracion;
    }
    
}