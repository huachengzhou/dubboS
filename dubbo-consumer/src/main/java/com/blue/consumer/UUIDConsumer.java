package com.blue.consumer;

import com.blue.service.UUIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by 13426 on 2018/4/25.
 */
@Component(value = "uuidConsumer")
public class UUIDConsumer {

    @Lazy
    @Autowired
    private UUIDService uuidService;

    public String uuid() {
        return uuidService.uuidGet();
    }
}
