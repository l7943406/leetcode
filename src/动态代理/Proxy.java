package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {
    static class PersonInvocationHandler implements InvocationHandler{
        Object object;

        public PersonInvocationHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("前");
            Object invoke = method.invoke(object, args);
            System.out.println(object);
            System.out.println("后");
            return invoke;
        }
    }
    public static void main(String[] args) {
        Person o = (Person)java.lang.reflect.Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new PersonInvocationHandler(new LiZhen()));
        System.out.println(o.speak());
    }

}
