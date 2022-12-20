package com.example.block15login.Application.security;


import com.example.block15login.Application.Person.Crud.ServicePerson;
import com.example.block15login.Application.Person.Person;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SecurityController {

    @Autowired
    ServicePerson personService;

    //Insertar en consola localhost:8080/h2Console

   // admin: INSERT INTO person(usuario,name,company_email,personal_email,city,active,created_date,admin,password) VALUES ('josedelrio','jose','Correo@prueba.com','Correo@prueba.com','SdC',true,'2022-05-31T00:00:00',true,'1234');

  // user:  INSERT INTO person(usuario,name,company_email,personal_email,city,active,created_date,admin,password) VALUES ('jose','jose','Correo@prueba.com','Correo@prueba.com','SdC',true,'2022-05-31T00:00:00',false,'1234');


    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        Person person = personService.getByName(username);
        System.out.println("El nombre del usuario es: " + username + "\nLa clave del usuario es: " + password);
        if (person == null) {
            System.out.println("Persona no encontrada");
        }
        if(username.contains(person.getUsuario()) && password.contains(person.getPassword())) {
            if (person.isAdmin()) {
                System.out.println("El usuario " + person.getUsuario() + " es ADMIN");
                return getJwtToken(username, "ADMIN");
            } else {
                System.out.println("El usuario " + person.getUsuario() + " es USER");
                return getJwtToken(username, "USER");
            }
        } else {
            return "No coincide usuario/password";
        }
    }

    private String getJwtToken(String username, String role) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        String token = Jwts.builder().setId("Bosonit").setSubject(username)
                .claim("roles",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000000))
                .signWith(SignatureAlgorithm.HS512, "secret".getBytes()).compact();
        return "Bearer " + token;
    }
}
