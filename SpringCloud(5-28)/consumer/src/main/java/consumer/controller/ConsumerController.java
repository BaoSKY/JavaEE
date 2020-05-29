package consumer.controller;

import consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    //Producer路径
    private final String url = "http://localhost:8003/producer/getProduct";

    @Autowired
    ConsumerService consumerService;

    @RequestMapping("/api/v1/demo/get")
    public String get(){
//        return new RestTemplate().getForObject(url, String.class);
        return consumerService.consumerService();
    }
}
