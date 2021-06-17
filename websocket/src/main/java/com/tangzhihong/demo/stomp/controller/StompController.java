package com.tangzhihong.demo.stomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Malphite
 * @date: 2021/6/17 8:35 下午
 * @version: 1.0
 * @group:
 */
@RestController
public class StompController {

    // @MessageMapping 和 @RequestMapping 功能类似，浏览器向服务器发起消息，映射到该地址。
    @MessageMapping("/hello")
    // 如果服务器接受到了消息，就会对订阅了 @SendTo 括号中的地址的浏览器发送消息。
    @SendTo("/nasus/getResponse")
    public String say(String message) throws Exception {
        return "hello " + message;
    }
}
