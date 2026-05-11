package com.lucas.sysmanutencao.exception;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private LocalDateTime timestamp = LocalDateTime.now();
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErrorResponseDTO(Integer status, String error, String message, String path, LocalDateTime timestamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {return this.timestamp;}
    public Integer getStatus() {return this.status;}
    public String getError() {return this.error;}
    public String getMessage() {return this.message;}
    public String getPath() {return this.path;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}
    public void setStatus(Integer status) {this.status = status;}
    public void setError(String error) {this.error = error;}
    public void setMessage(String message) {this.message = message;}
    public void setPath(String path) {this.path = path;}

}
