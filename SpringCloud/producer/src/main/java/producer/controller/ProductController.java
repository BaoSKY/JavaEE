package producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class ProductController {

    @RequestMapping("getProduct")
    public String getProduct(){
        return "Hello, here is the product from the producer";
    }
}
