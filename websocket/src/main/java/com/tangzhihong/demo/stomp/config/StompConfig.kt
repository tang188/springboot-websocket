package com.tangzhihong.demo.stomp.config

import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

/**
 *
 * @author: Malphite
 * @date: 2021/6/17 8:07 下午
 * @version: 1.0
 * @group:
 */
class StompConfig : WebSocketMessageBrokerConfigurer{

    //注册一个 Stomp 的节点(endpoint),并指定使用 SockJS 协议。
    override fun registerStompEndpoints(registry : StompEndpointRegistry ){
        registry.addEndpoint("/test/bc").withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker("/nasus")
    }
}

