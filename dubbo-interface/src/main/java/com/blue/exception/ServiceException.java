package com.blue.exception;


import com.blue.common.exception.Service;

public class ServiceException extends RuntimeException {
    public ServiceException() {
        super(Service.SERVICE_NUM.getVar());
    }
}
