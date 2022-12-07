package com.example.block14testing.Application.Exceptions;

public class UnprocessableEntityException extends CustomError {


    public UnprocessableEntityException(String s){
        super(422,s);

    }
}
