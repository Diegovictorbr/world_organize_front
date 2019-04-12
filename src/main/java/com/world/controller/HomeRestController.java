package com.world.controller;

import com.world.util.WebClient;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

    @RequestMapping(value = "getCategorias", name = "getCategorias")
    public String getCategorias() throws IOException {
        String url = "https://7lxc3x2ta7.execute-api.us-east-1.amazonaws.com/Prod/listcategory";
        return WebClient.getInstance().doGet(url);
    }

    @RequestMapping(value = "getLocalidades", name = "getLocalidades")
    public String getLocalidades() throws IOException {
        String url = "https://7lxc3x2ta7.execute-api.us-east-1.amazonaws.com/Prod/listlocate";
        return WebClient.getInstance().doGet(url);
    }

    @RequestMapping(value = "getInfoByCateg", name = "getInfoByCateg")
    public String getInfoByCateg(int categoriaId) throws IOException {
        String url = "https://7lxc3x2ta7.execute-api.us-east-1.amazonaws.com/Prod/gettweetbycategory?id=" + categoriaId;
        return WebClient.getInstance().doGet(url);
    }

    @RequestMapping(value = "getInfoByLocal", name = "getInfoByLocal")
    public String getInfoByLocal(int localidadeId) throws IOException {
        String url = "https://7lxc3x2ta7.execute-api.us-east-1.amazonaws.com/Prod/gettweetbylocate?id=" + localidadeId;
        return WebClient.getInstance().doGet(url);
    }
}
