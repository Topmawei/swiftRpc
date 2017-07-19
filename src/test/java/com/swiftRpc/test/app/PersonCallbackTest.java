package com.swiftRpc.test.app;

import com.swiftRpc.client.AsyncRPCCallback;
import com.swiftRpc.client.RPCFuture;
import com.swiftRpc.client.RpcClient;
import com.swiftRpc.client.proxy.IAsyncObjectProxy;
import com.swiftRpc.registry.ServiceDiscovery;
import com.swiftRpc.test.client.Person;
import com.swiftRpc.test.client.PersonService;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author mawei
 *
 */
public class PersonCallbackTest {
    public static void main(String[] args) {
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1:2181");
        final RpcClient rpcClient = new RpcClient(serviceDiscovery);
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            IAsyncObjectProxy client = rpcClient.createAsync(PersonService.class);
            int num = 5;
            RPCFuture helloPersonFuture = client.call("GetTestPerson", "xiaoming", num);
            helloPersonFuture.addCallback(new AsyncRPCCallback() {
                @Override
                public void success(Object result) {
                    List<Person> persons = (List<Person>) result;
                    for (int i = 0; i < persons.size(); ++i) {
                        System.out.println(persons.get(i));
                    }
                    countDownLatch.countDown();
                }

                @Override
                public void fail(Exception e) {
                    System.out.println(e);
                    countDownLatch.countDown();
                }
            });

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        rpcClient.stop();

        System.out.println("End");
    }
}
