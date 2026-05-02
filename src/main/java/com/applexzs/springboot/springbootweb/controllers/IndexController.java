package com.applexzs.springboot.springbootweb.controllers;


import com.applexzs.springboot.springbootweb.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.index.perfil}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.index.listar}")
    private String textoListar;

    @GetMapping(value = {"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping(value = "/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Eduardo");
        usuario.setApellido("Luquin");
        usuario.setEmail("elquuin@mail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping(value = "/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", textoListar);

        return "listar";
    }


    @ModelAttribute("usuarios")
    public  List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jesus", "Luquin", "jluquin@mail.com"));
        usuarios.add(new Usuario("Fernando", "Smith", "fersmith@mail.com"));
        usuarios.add(new Usuario("Osvaldo", "Perez", "operez@mail.com"));
        return usuarios;
    }

}
