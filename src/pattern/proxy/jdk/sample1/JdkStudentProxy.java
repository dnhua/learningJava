package pattern.proxy.jdk.sample1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkStudentProxy implements InvocationHandler {
    private Object target = null;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("请开始自我介绍：");
        Object obj = method.invoke(target, args);
        System.out.println("自我介绍结束！");
        return obj;
    }
}
