package com.swiftRpc.client;

/**
 * 
 * @author mawei
 *
 */
public interface AsyncRPCCallback {

    void success(Object result);

    void fail(Exception e);

}
