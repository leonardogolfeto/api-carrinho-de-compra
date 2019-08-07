package com.apicarrinhodecompra.exceptionhandler.error;

import java.util.List;

public class    ErrorResponse {

    private  String message;
    private  int code;
    private  String status;
    private  String objectName;
    private  List<ObjectError> errors;

    public ErrorResponse(String message, int code, String status, String objectName, List<ObjectError> errors) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.objectName = objectName;
        this.errors = errors;
    }

    public ErrorResponse(String message, int value, String reasonPhrase, Object o) {
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getObjectName() {
        return objectName;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }
}

