package com.example.Block7CrudvalidadtionPart4;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.cloud.openfeign.FeignClient(name = "Feing", url ="http://localhost:8080/profesor/id/1")
public interface FeignService {

    @GetMapping("")
     ProfesorDTO getProfesor();
}
