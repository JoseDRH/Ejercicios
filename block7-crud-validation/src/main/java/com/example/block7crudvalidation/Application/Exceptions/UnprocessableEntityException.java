package com.example.block7crudvalidation.Application.Exceptions;

public class UnprocessableEntityException extends CustomError {


    public UnprocessableEntityException(String s){
        super(422,s);

    }
}
