package com.example.block15login.Application.Exceptions;


public class EntityNotFoundException extends CustomError {


     public EntityNotFoundException (){
         super(404,"El usuario a buscar no existe");
     }

}
