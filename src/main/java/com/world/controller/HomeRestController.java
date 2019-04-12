package com.world.controller;

import com.world.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

//    @RequestMapping(value = "/login")
//    public ResponseEntity login() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(URI.create(""));
//        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
//    }
//
//    @RequestMapping(value = "/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "{}";
//    }
//
//    // Outro exemplo de redirect a partir de um restcontroller
    @RequestMapping("getCategorias")
    public List<Categoria> getCategorias(HttpServletResponse response) {
        // TODO: GET p/ endpoint de categorias e parsear lista

        String url = "https://7lxc3x2ta7.execute-api.us-east-1.amazonaws.com/Prod/listcategory";

        return new ArrayList<>();
    }
}
