package cc.sitec.consumer.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider" )
public interface HelloService {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello(@RequestParam(value="name") String name);
}
