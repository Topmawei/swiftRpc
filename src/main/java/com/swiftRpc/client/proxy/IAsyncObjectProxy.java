package com.swiftRpc.client.proxy;

import com.swiftRpc.client.RPCFuture;

/**
 * 
 * @author mawei
 *
 */
public interface IAsyncObjectProxy {
    public RPCFuture call(String funcName, Object... args);
}