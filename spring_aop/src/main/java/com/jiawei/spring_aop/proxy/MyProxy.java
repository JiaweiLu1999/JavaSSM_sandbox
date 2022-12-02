package com.jiawei.spring_aop.proxy;

import com.jiawei.spring_aop.example.impl.MyLog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyProxy {
    private final Object target;

    public MyProxy(Object target) {
        this.target = target;
    }


    public Object getProxyObject() {
        Object proxy = null;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        proxy = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object res = method.invoke(target, args);

                return res;
            }
        });
        return proxy;
    }
}
