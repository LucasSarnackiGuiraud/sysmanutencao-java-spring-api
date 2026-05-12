package com.lucas.sysmanutencao.exception;


public class BussinessExcepetion extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BussinessExcepetion(String mensage){
        super(mensage);
    }
}
