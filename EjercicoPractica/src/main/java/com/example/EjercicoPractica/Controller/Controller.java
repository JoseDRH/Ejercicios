package com.example.EjercicoPractica.Controller;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    //Funcion que crea y devuelve el objeto ControllerObject
    public  ControllerObject constructor(Map<String,String> allParams, Map<String,String> allheader,
                                         HttpServletRequest request){
        ControllerObject controllerObject=new ControllerObject();
        //Recogemos el URI del path y lo dividemos en un array de Strings el cual transformamos a Stream y a List
        List<String> path= Arrays.stream(request.getRequestURI().split("/")).toList();
        controllerObject.setPath(path);
        //Con la etiqueta @RequestParam se extraeran todos los parametros de la peticion y los devolverea en el Map
        controllerObject.setQuerys(allParams);
        //Al igual que la etiqueta @RequestParam la etiqueta @RequestHeader nos devolvera todos los headers de la peticion
        controllerObject.setHeaders(allheader);
        controllerObject.setUrlOrigen(request.getRemoteAddr());
        return controllerObject;
    }

    @GetMapping("/**")
    public String entryOther(@RequestParam Map<String,String> allParams, @RequestHeader Map<String,String> allheader,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
    /*    if(request.getHeader("REDIRIGE")!=null && request.getHeader("REDIRIGE").equals("SALTA")) {
            response.sendRedirect("/salta");
        }*/

        return "Funcion entryOther \n"+constructor(allParams,allheader,request).toString();
    }
    @GetMapping(value ={ "/","one"})
    public String entryOne(@RequestParam Map<String,String> allParams, @RequestHeader Map<String,String> allheader,
                           HttpServletRequest request,HttpServletResponse response) throws IOException {
   /*     if(request.getHeader("REDIRIGE")!=null && request.getHeader("REDIRIGE").equals("SALTA")) {
            response.sendRedirect("/salta");
        }*/
        return "Funcion entryOne \n"+constructor(allParams,allheader,request).toString();
    }
    @GetMapping("/salta")
    public String entryJump(){
        return "He ido a jump";
    }

    @PostMapping("/**")
    public String output(HttpServletRequest request){
        List<String> mensaje=new ArrayList<>();
        String body="";
        mensaje= (List<String>) request.getAttribute("mensaje");
        for (String linea:
            mensaje ) {
            body+=linea+"\n";
        }

        return body;
    }
}
