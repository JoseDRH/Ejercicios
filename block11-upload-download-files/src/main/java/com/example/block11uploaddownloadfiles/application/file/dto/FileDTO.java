package com.example.block11uploaddownloadfiles.application.file.dto;

import lombok.Data;
import java.util.Date;

@Data
public class FileDTO {

    private Integer id;

    private String file_name;

    private Date date;

    private byte[] data;
}
