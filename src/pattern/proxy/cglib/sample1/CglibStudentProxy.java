package pattern.proxy.cglib.sample1;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibStudentProxy implements MethodInterceptor {
    public Object getProxy(Class cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("请开始自我介绍");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("自我介绍结束");
        return obj;
    }
}
