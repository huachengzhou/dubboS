package com.blue.exception;


import com.blue.common.exception.ControllerEnum;

public class ControllerException extends Exception {
    public ControllerException() {
        super(ControllerEnum.CONTROLLER_ENUM.getVar());
    }
}
