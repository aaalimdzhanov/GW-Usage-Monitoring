package com.gwumonitor.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static ResponseEntity<ResponseJSON> error(Exception ex) {
        return new ResponseEntity<>(new ResponseJSON("Error " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<ResponseJSON> success() {
        return new ResponseEntity<>(new ResponseJSON("Success"), HttpStatus.OK);
    }

    public static ResponseEntity<ResponseJSON> result(Object T) {
        return new ResponseEntity<>(new ResponseJSON("Success", T), HttpStatus.OK);
    }
}
