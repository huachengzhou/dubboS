# dubbo构建工程

* 此聚合项目一共实现了两种方式进行dubbo配置
## A(非注解)
+ 1 edu-service-user 项目 implements edu-facade-user 中的 interface
+ 2 edu-service-user dao==>dao-impl==>service-impl || dubbo bean==>service-impl
> 这里使用了dubbo bean 作为中间站的方式
> 非注解方式非常不好 需要一个一个的写这样很是麻烦 假如有1000个bean 那岂不是一种很愚蠢的做法吗!
* example:
```
服务提供方 <dubbo:service interface="wusc.edu.facade.user.service.PmsUserFacade" ref="pmsUserDubbo" />
需要注意的是这是中间bean
服务消费方
<dubbo:reference interface="wusc.edu.facade.user.service.PmsUserFacade" id="pmsUserFacade" check="false" />
建议不要这样做
```

## B(注解)
+ 1 edu-service-user 项目 implements edu-facade-user 中的 interface
+ 2 服务提供方注解:
```
package edu.facade.dubbo.service2;

import org.springframework.stereotype.Component;
import wusc.edu.facade.user.service.UUIDServiceTest;

import java.util.UUID;

@Component
@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class UUIDServiceImpl implements UUIDServiceTest {

    @Override
    public String uuid() {
        return UUID.randomUUID().toString();
    }
}
```
+ 2-1 服务提供方注 spring配置
```
<dubbo:annotation package="edu.facade.dubbo.service2" />
```
+ 3 服务消费方注解：
```
package wusc.edu.consume;

import org.springframework.stereotype.Component;
import wusc.edu.facade.user.service.UUIDServiceTest;

@Component("uUIDT")
public class UUIDT {

    @com.alibaba.dubbo.config.annotation.Reference(version = "1.0.0")
    private UUIDServiceTest uuidService;

    public void setUuidService(){
        System.out.println(uuidService.uuid());
    }
}
```
+ 3-1 服务消费方 spring配置
```
<dubbo:annotation package="wusc.edu.consume" />
```