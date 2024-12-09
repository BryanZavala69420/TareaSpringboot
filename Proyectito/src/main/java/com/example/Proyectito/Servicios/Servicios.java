/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Proyectito.Servicios;

import java.util.Optional;

import com.example.Proyectito.Usuario.Usuario;

/**
 *
 * @author bryan
 */
public interface Servicios {

    Optional<Usuario> CrearteUsuario(Usuario usuario);
    
}
