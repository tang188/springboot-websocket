package com.tangzhihong.demo.stomp.service;

import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;

/**
 * @author: Malphite
 * @date: 2021/6/17 8:37 下午
 * @version: 1.0
 * @group:
 */
public class StompSub {

    public void test(){
        WebSocketStompClient client = new WebSocketStompClient(new SockJsClient());
    }
}
