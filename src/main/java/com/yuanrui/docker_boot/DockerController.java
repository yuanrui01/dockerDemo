package com.yuanrui.docker_boot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DockerController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/sth")
    public String uuid() {
        return "return sth " + port + UUID.randomUUID();
    }
}
