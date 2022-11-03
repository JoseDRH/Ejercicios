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
        if (headers!=null){
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
                } else if (request.getMethod().equals("POST")) {
                    List<String> mensaje=new ArrayList<>();

                    Stream<String> flujo=  content.getReader().lines();

                    flujo.forEach(linea->mensaje.add(linea));

                    if (headerName.equalsIgnoreCase("add")) {
                      mensaje.add("Modificado");
                     }
                    System.out.println(flujo);
                    request.setAttribute("mensaje",mensaje);
                    break;

                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
