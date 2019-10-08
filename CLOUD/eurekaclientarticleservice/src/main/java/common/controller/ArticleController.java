package common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author Heling
 * @Date 2019/10/8 18:11
 **/
@RestController
public class ArticleController {

    @Autowired
    private RestTemplate restTemplate;//BeanConfiguration注解getRestTemplate为BEAN

    @GetMapping("/article/callHello")
    public String callHello(){
        //使用服务则注册中心 不再指定访问的url路径,而是使用注册中心+访问路径，BEAN需要被注解为@LoadBalanced（BeanConfiguration注解getRestTemplate）
        //return restTemplate.getForObject("http://localhost:8081/user/hello",String.class);
        return restTemplate.getForObject("http://eureka-client-user-service/user/hello", String.class);
    }
}
