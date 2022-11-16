package com.example.Block7CrudvalidadtionPart4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    private final RestTemplate restTemplate;

    @Autowired
    private FeignService feignService;

    @GetMapping("/feign")
    public ProfesorDTO getProfesorF(){
        return feignService.getProfesor();
    }


    @Autowired
    public Controller(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @GetMapping("/RT/{id}")
    public ProfesorDTO getProfesor(@PathVariable int id){
        String url="http://localhost:8080/profesor/id/"+id;

        return restTemplate.getForObject(url, ProfesorDTO.class);
    }

}
