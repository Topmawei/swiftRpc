package com.swiftRpc.test.server;

import com.swiftRpc.server.RpcService;
import com.swiftRpc.test.client.HelloService;
import com.swiftRpc.test.client.Person;

/**
 * 
 * @author mawei
 *
 */
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

	@Override
	public String hello(String name) {
		return "Hello! " + name;
	}

	@Override
	public String hello(Person person) {
		return "Hello! " + person.getFirstName() + " " + person.getLastName();
	}
}
