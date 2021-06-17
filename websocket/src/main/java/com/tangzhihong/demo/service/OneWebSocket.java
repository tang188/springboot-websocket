package com.tangzhihong.demo.service

import lombok.extern.slf4j.Slf4j
import javax.websocket.server.ServerEndpoint
import com.tangzhihong.demo.service.OneWebSocket
import org.springframework.stereotype.Component
import java.lang.Exception
import java.util.concurrent.atomic.AtomicInteger
import javax.websocket.*

/**
 * @author: Malphite
 * @date: 2021/6/17 5:04 下午
 * @version: 1.0
 * @group:
 */
@Slf4j
@Component
@ServerEndpoint(value = "/test/one")
class OneWebSocket {
    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    fun onOpen(session: Session) {
        onlineCount.incrementAndGet() // 在线数加1
        OneWebSocket.log.info("有新连接加入：{}，当前在线人数为：{}", session.id, onlineCount.get())
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    fun onClose(session: Session) {
        onlineCount.decrementAndGet() // 在线数减1
        OneWebSocket.log.info("有一连接关闭：{}，当前在线人数为：{}", session.id, onlineCount.get())
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    fun onMessage(message: String, session: Session) {
        OneWebSocket.log.info("服务端收到客户端[{}]的消息:{}", session.id, message)
        sendMessage("Hello, $message", session)
    }

    @OnError
    fun onError(session: Session?, error: Throwable) {
        OneWebSocket.log.error("发生错误")
        error.printStackTrace()
    }

    /**
     * 服务端发送消息给客户端
     */
    private fun sendMessage(message: String, toSession: Session) {
        try {
            OneWebSocket.log.info("服务端给客户端[{}]发送消息{}", toSession.id, message)
            toSession.basicRemote.sendText(message)
        } catch (e: Exception) {
            OneWebSocket.log.error("服务端发送消息给客户端失败：{}", e)
        }
    }

    companion object {
        /**
         * 记录当前在线连接数
         */
        private val onlineCount = AtomicInteger(0)
        fun test() {}
    }
}