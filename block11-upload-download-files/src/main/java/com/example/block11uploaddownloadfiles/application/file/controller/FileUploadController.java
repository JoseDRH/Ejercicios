package com.example.block11uploaddownloadfiles.application.file.controller;

import com.example.block11uploaddownloadfiles.application.file.model.EntityFile;
import com.example.block11uploaddownloadfiles.application.service.ServiceFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Date;


@RestController
public class FileUploadController {

    @Autowired
    ServiceFile serviceFile;

    private String pat=System.getProperty("user.dir");


    @PostMapping("/upload/{tipo}")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file,@PathVariable String tipo) {
        EntityFile entityFile =new EntityFile();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        entityFile.setFile_name(fileName);
        entityFile.setDate(new Date());
        String fileDownloadUri = "Tipo de fichero no valido, debe subir en un formato "+file.getContentType();
        try {
            if (file.getContentType().contains(tipo)) {
                entityFile.setData(file.getBytes());
                serviceFile.saveFile(entityFile);
                fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/download/")
                        .path(fileName)
                        .toUriString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(fileDownloadUri);
    }

    @GetMapping("/download/{fileName}")
    public String download(@PathVariable String fileName) throws IOException {
       EntityFile ef = serviceFile.findFilebyName(fileName);
        Path path = Path.of(pat+"\\"+fileName);
       Files.write(path,ef.getData());

        return "Se ha descargado "+fileName;
    }
    @GetMapping("/setpath")
    public String changePath(@RequestParam String path){
        pat=path;
            return  "Directorio descarga cambiando a "+pat;

    }





}
