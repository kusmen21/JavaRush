package com.javarush.test.level32.lesson08.home01;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler
{
    /*
    2) CustomInvocationHandler должен иметь один публичный конструктор с одним агументом типа SomeInterfaceWithMethods.
3) Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
4) После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
5) Реализовать логику метода getProxy, который должен создавать прокси для интерфейса SomeInterfaceWithMethods.
См. пример вывода в методе main. Метод main не участвует в тестировании.
     */
    private SomeInterfaceWithMethods instance;

    public CustomInvocationHandler(SomeInterfaceWithMethods instance)
    {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println(method.getName() + " in");
        Object toReturn = method.invoke(instance, args);
        System.out.println(method.getName() + " out");
        return toReturn;
    }
}
