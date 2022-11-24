package com.example.block11cors.Application.Exceptions;

public class UnprocessableEntityException extends CustomError {


    public UnprocessableEntityException(String s){
        super(422,s);

    }
}
