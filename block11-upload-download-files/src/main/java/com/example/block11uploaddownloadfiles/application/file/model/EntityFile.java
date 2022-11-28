package com.example.block11uploaddownloadfiles.application.file.model;

import com.example.block11uploaddownloadfiles.application.file.dto.FileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EntityFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String file_name;

    @Column
    private Date date;

    @Lob
    private byte[] data;

    public FileDTO setToDTO(){
        FileDTO dto=new FileDTO();
        dto.setId(this.id);
        dto.setFile_name(this.file_name);
        dto.setData(this.data);
        dto.setDate(this.date);
        return  dto;
    }

}
