package com.xuf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title: TestProxy
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-10-30
 */
public class TestProxy {
	interface IHello{
		void sayHello();
	}
	
	static class Hello implements IHello{
		@Override
		public void sayHello() {
			System.out.println("hello world!");
		}
	}
	
	static class HelloProxy implements InvocationHandler{
		
		Object obj;
		
		Object bind(Object obj){
			this.obj = obj;
		  return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
			System.out.println("哈哈哈");
			return method.invoke(obj,args);
		}
		
	}
	
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		IHello h = (IHello)new HelloProxy().bind(new Hello());
		h.sayHello();
	}
}
