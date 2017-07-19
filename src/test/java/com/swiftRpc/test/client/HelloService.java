package com.swiftRpc.test.client;

/**
 * 
 * @author mawei
 *
 */
public interface HelloService {
	
    String hello(String name);

    String hello(Person person);
}
