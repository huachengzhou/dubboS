package me;

import com.blue.consumer.UUIDConsumer;
import com.blue.service.UUIDService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.start();
        System.out.println("consumer start");
        UUIDConsumer uuidConsumer = (UUIDConsumer)context.getBean("uuidConsumer");
        while (1<2){
            System.out.println(uuidConsumer.uuid());
        }
    }
}
