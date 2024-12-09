/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Proyectito.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "JavaCito")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="ApellidoPaterno")
    private String apellidoP;

    @Column(name="ApellidoMaterno")
    private String apellidoM;

    @Column (name = "edad")
    private int edad;

    public Usuario(){}

    public Usuario(Long id, String nombre, String apellidoP, String apellidoM, int edad){
        this.id=id;
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.edad=edad;

    }

    // Getters para as cositas
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    // Setters para las cositas
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString(){

        return "El Usuario: [id=" + id + ", nombre=" + nombre + ", A.Paterno=" + apellidoP + ", A.Materno=" + apellidoM + ", edad= " +edad+"]";
    }

}





    

