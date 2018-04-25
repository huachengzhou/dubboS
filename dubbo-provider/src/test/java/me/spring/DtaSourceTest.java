package me.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class DtaSourceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    @Test
    public void isN(){
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        System.out.println(dataSource);
    }
}
