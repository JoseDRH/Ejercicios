package com.example.block15login.Application.Exceptions;

public class UnprocessableEntityException extends CustomError {


    public UnprocessableEntityException(String s){
        super(422,s);

    }
}
