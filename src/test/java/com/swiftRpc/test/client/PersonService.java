package com.swiftRpc.test.client;

import java.util.List;

/**
 * 
 * @author mawei
 *
 */
public interface PersonService {
    List<Person> GetTestPerson(String name, int num);
}
