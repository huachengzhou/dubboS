package com.blue.service.impl;

import com.blue.service.UUIDService;

import java.util.UUID;

public class UUIDServiceImpl implements UUIDService {
    public String uuidGet(){
        return UUID.randomUUID().toString();
    }
}
