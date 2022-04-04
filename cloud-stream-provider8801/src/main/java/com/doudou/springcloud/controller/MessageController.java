package com.doudou.springcloud.controller;

import com.doudou.springcloud.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Doudou
 * @date 2022/3/28 - 17:07
 */
@RestController
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @GetMapping("/send")
    public String send(){
        return messageService.send();
    }
}
