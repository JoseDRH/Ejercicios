package com.example.block13criteriabuilder.Application.Exceptions;

public class UnprocessableEntityException extends CustomError {


    public UnprocessableEntityException(String s){
        super(422,s);

    }
}
