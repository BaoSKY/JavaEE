package consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    //Producer路径
    private final String url = "http://producer/producer/getProduct";

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "consumerFallback")
    public String consumerService(){
        return restTemplate.getForObject(url, String.class);
    }

    public String consumerFallback(){
        return "ERROR";
    }
}
