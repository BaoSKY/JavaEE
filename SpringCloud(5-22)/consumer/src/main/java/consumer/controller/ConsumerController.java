package consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    //Producer路径
    private final String url = "http://localhost:8003/producer/getProduct";

    @RequestMapping("/api/v1/demo/get")
    public String get(){
        RestTemplate template = new RestTemplate();
        String data = template.getForObject(url, String.class);
        return data;
    }
}
