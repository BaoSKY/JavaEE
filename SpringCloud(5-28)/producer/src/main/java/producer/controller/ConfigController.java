package producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${springcloud.config}")
    private String config;

    @RequestMapping("/config")
    public String getConfig(){
        return this.config;
    }
}
