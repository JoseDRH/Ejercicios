package com.example.block7crudvalidation.Application.Exceptions;


public class EntityNotFoundException extends CustomError {


     public EntityNotFoundException (){
         super(404,"El usuario a buscar no existe");
     }

}
