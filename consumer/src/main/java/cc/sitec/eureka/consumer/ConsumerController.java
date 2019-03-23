package cc.sitec.eureka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public Object hello() {
        String url = getUrl("provider")+"/hello?name={name}";
        final Map<String, String> variables = new HashMap<>();
        variables.put("name", "keeley");
        return restTemplate.getForObject(url, String.class,variables);
    }

    /**
     * 获取指定url
     * @param clientApplicationName 指定的服务提供名
     * @return
     */
    private String getUrl(String clientApplicationName) {
        // 使用loadBalancerClient的choose函数来负载均衡的选出一个eurekaClient的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose(clientApplicationName);
        // 获取之前eurekaClient /all接口地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
        return url;
    }

}
