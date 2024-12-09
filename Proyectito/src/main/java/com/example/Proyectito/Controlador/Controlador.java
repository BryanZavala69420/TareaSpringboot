/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Proyectito.Controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Proyectito.Repositorio.Repositorio;
import com.example.Proyectito.Usuario.Usuario;

/**
 *
 * @author bryan
 */

 @RestController
 @RequestMapping("/proyecto")
public class Controlador {

@Autowired
    private Repositorio Repositorio;

    @GetMapping("/")
    public String LOL(Model model){
            return "index";
    }


    
    @GetMapping("/numero")
    public List<Integer> NumerosAleatorios(){
        Random aleatorio = new Random();
        List<Integer> numeritos = new ArrayList<>();
            for(int i=0; i<10; i++){
            numeritos.add(aleatorio.nextInt(1000));

            }  


        return numeritos;
    
    }


    @PostMapping("/pares")
    public Map<String, List<Integer>> separarParesEImpares(@RequestBody List<Integer> numeros) {
        List<Integer> NumerosPares = numeros.stream().filter(n -> n%2==0).collect(Collectors.toList());

        List<Integer> NumerosInares = numeros.stream().filter(n -> n%2!=0).collect(Collectors.toList());

        Map<String, List<Integer>> total = new HashMap<>();
        total.put("Pares", NumerosPares);
        total.put("Impares", NumerosInares);
        return total;


    }

  
    @PostMapping("/crearUsuario")
    public String crearUsuario(
            @RequestParam String nombre,
            @RequestParam String apellidoPaterno,
            @RequestParam String apellidoMaterno,
            @RequestParam int edad,
            @RequestParam String correo,
            Model model) {

        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidoP(apellidoPaterno);
        usuario.setApellidoM(apellidoMaterno);
        usuario.setEdad(edad);

        // Guardar el usuario en la base de datos
        Usuario nuevoUsuario = Repositorio.save(usuario);

        // Ruta del archivo
        String filePath = "/home/bryan/Escritorio/tarealloro/personas.txt";

        // Crear el archivo y escribir los datos
        try (FileWriter writer = new FileWriter(filePath, true)) { // Modo append
            writer.write(usuario.getId() + "|" +
                    usuario.getNombre() + "|" +
                    usuario.getApellidoP() + "|" +
                    usuario.getApellidoM() + "|" +
                    usuario.getEdad() + "|"+"\n");
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo personas.txt", e);
        }

        // Pasar el ID al modelo para la vista
        model.addAttribute("id", nuevoUsuario.getId());
        return "resultado";
    }

}
