package com.example.EjercicoPractica.Filter;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Filtro implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        ContentCachingRequestWrapper content= new ContentCachingRequestWrapper(request);
        Enumeration<String> headers= request.getHeaderNames();
        //Creamos una lista donde almacenaremos el body por lineas
        List<String> mensaje=new ArrayList<>();
        if (headers!=null){
            if (request.getMethod().equals("POST")){
                //Extraemos el body y lo introducimos en la lista
                Stream<String> flujo=  content.getReader().lines();
                flujo.forEach(linea->mensaje.add(linea));
            }
            while (headers.hasMoreElements()){
                String headerName=headers.nextElement();
                if (headerName.equalsIgnoreCase("redirige") && request.getHeader(headerName).equalsIgnoreCase("salta") ){
                    System.out.println("Se encontro header "+headerName+" con valor:"+request.getHeader(headerName));
                    request = new HttpServletRequestWrapper((HttpServletRequest) request) {
                        @Override
                        public String getRequestURI() {
                            return "/salta";
                        }
                    };
                    //Si existe un header llamado add añadira el string "modificado" al List del mensaje
                } else if (headerName.equalsIgnoreCase("add")) {
                    mensaje.add("Modificado");
                }
            }
        }
        //Para enviar el contenido del body a los controladores lo añadimos como un atributo
        request.setAttribute("mensaje",mensaje);
        filterChain.doFilter(request,response);
    }
}
