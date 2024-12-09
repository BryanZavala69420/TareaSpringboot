/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Proyectito.Servicios;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyectito.Repositorio.Repositorio;
import com.example.Proyectito.Usuario.Usuario;

/**
 *
 * @author bryan
 */
@Service
public class ServiciosIMPL implements Servicios {
    @Autowired
    private Repositorio Repositorio;

    org.slf4j.Logger logger = LoggerFactory.getLogger(ServiciosIMPL.class);



    @Override
    public Optional<Usuario> CrearteUsuario(Usuario usuario) {
        Optional<Usuario> NuevecitoWey = Optional.of(usuario);
        if(NuevecitoWey.isPresent()){
            Usuario OdioJava =new Usuario();

            OdioJava.setNombre(usuario.getNombre());
            OdioJava.setApellidoP(usuario.getApellidoP());
            OdioJava.setApellidoM(usuario.getApellidoM());
            OdioJava.setEdad(usuario.getEdad());

            Repositorio.save(OdioJava);

            Optional<Usuario> RetornarUsuario = Optional.of(OdioJava);
            return RetornarUsuario;

        }else{
            throw new UnsupportedOperationException("Odio java w");

        }

    }
    
}
