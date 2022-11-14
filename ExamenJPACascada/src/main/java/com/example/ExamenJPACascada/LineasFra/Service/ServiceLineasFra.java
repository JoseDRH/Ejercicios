package com.example.ExamenJPACascada.LineasFra.Service;

import com.example.ExamenJPACascada.LineasFra.LineasFra;
import com.example.ExamenJPACascada.LineasFra.Repository.RepositoryLineasFra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLineasFra {

    @Autowired
    RepositoryLineasFra repositoryLineasFra;

    public void save(LineasFra lineasFra){
        repositoryLineasFra.save(lineasFra);
    }
    public void delete(int id){
        repositoryLineasFra.deleteById(id);
    }
}
