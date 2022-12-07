package com.example.block14testing.Application.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError extends Exception   {

    private Date timestamp;
    private int HttpCode;
    private String mensaje;


    public CustomError(int i, String s) {
        timestamp=new Date();
        HttpCode=i;
        mensaje=s;
    }
}
