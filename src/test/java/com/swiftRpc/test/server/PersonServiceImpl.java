package com.swiftRpc.test.server;

import com.swiftRpc.server.RpcService;
import com.swiftRpc.test.client.Person;
import com.swiftRpc.test.client.PersonService;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mawei
 *
 */
@RpcService(PersonService.class)
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> GetTestPerson(String name, int num) {
        List<Person> persons = new ArrayList<>(num);
        for (int i = 0; i < num; ++i) {
            persons.add(new Person(Integer.toString(i), name));
        }
        return persons;
    }
}
