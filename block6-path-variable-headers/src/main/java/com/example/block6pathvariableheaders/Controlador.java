package com.example.block6pathvariableheaders;


import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador {

    @RequestMapping(path="/", method= RequestMethod.POST)
    public String metodo1(@RequestBody String body){
        return body;
    }
    @RequestMapping(path="/user/{id}")
    public String metodo2(@PathVariable String id){
        return "Bienvenido usuario: "+id;
    }
    @RequestMapping(path="/post",method = RequestMethod.PUT)
    public String metodo3(@RequestParam String var1,@RequestParam String var2){
        return var1+" + "+var2;
    }

}
