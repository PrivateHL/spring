package first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    @Value("${server.port}")
    private String port;

    @Autowired
    private MyConfig config;

    @GetMapping("/hello")
    public String hello(){
        return "Welcome " + config.getName() + "." + port;
    }
}
