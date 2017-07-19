package com.swiftRpc.test.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author mawei
 *
 */
public class RpcBootstrap {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        new ClassPathXmlApplicationContext("server-spring.xml");
    }
}
