package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    /**
     2.1. Верните объект из cache для ключа key
     2.2. Если объекта не существует в кэше, то добавьте в кэш новый экземпляр используя рефлекшн, см. а)
     3. Реализуйте логику метода put:
     3.1. Используя рефлекшн получите ссылку на метод, описанный в п.б)
     3.2. Используя рефлекшн разрешите к нему доступ
     3.3. Используя рефлекшн вызовите метод getKey у объекта obj, таким образом Вы получите ключ key
     3.4. Добавьте в кэш пару <key, obj>
     3.5. Верните true, если метод отработал корректно, false в противном случае. Исключения игнорируйте.
     */
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here


    public V getByKey(K key, Class<V> clazz) throws Exception
    {
        if(!cache.containsKey(key)){
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));
        }

        return cache.get(key);
    }

    public boolean put(V obj)
    {
        try
        {
            Class[] paramtypes = new Class[0];
            Method method = obj.getClass().getDeclaredMethod("getKey", paramtypes);
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
