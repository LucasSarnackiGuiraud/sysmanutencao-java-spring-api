package com.lucas.sysmanutencao.exception;


public class BusinessExcepetion extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BusinessExcepetion(String mensage){
        super(mensage);
    }
}
