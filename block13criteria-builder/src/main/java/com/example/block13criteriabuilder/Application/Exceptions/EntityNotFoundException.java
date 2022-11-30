package com.example.block13criteriabuilder.Application.Exceptions;


public class EntityNotFoundException extends CustomError {


     public EntityNotFoundException (){
         super(404,"El usuario a buscar no existe");
     }

}
