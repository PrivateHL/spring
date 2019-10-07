package first;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义监控路径
 */
@Component
@Endpoint(id = "user")
public class MyEndpoint {

    @ReadOperation
    public List<Map<String, Object>> health(){

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("userid",1001);
        map.put("username","heling");
        list.add(map);
        return list;
    }
}
