package com.example.block11uploaddownloadfiles.application.service;

import com.example.block11uploaddownloadfiles.application.file.model.EntityFile;
import com.example.block11uploaddownloadfiles.application.repositoryFile.RepositoryFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ServiceFile  {

    @Autowired
    RepositoryFile repositoryFile;

    public void saveFile(EntityFile file){
        repositoryFile.save(file);
    }
    public EntityFile findFilebyName(String name){
        EntityFile ret= new EntityFile();
        List<EntityFile> list=new ArrayList<>();
        repositoryFile.findAll().forEach(entityFile -> {
            list.add(entityFile);
        });
        for (EntityFile ef :
                list) {
            if (ef.getFile_name().equals(name)){
                ret=ef;
                ret.setId(ef.getId());
                ret.setFile_name(ef.getFile_name());
                ret.setDate(ef.getDate());
                ret.setData(ef.getData());
                break;
            }
        }
        return ret;
    }
}
