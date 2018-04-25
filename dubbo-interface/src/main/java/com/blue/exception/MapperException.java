package com.blue.exception;


import com.blue.common.exception.MapperEnum;

public class MapperException extends RuntimeException {
    public MapperException() {
        super("" + MapperEnum.MAPPER_ENUM.getVar());
    }
}
