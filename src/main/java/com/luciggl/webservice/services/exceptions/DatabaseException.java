package com.luciggl.webservice.services.exceptions;

import org.springframework.stereotype.Service;

import java.io.Serial;

public class DatabaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg){
        super(msg);
    }

}
