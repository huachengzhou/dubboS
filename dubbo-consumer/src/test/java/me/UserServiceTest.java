package me;

import com.blue.consumer.UserConsumer;
import com.blue.domin.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    public static void main(String[] args) {
        String username = "zhaojun";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.start();
        UserConsumer userConsumer = (UserConsumer)context.getBean("userConsumer");

        User user = userConsumer.login(username);

        System.out.printf(""+user);
    }
}
