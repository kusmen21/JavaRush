package com.javarush.test.level37.lesson10.big01;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Externalizable
{
    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    @Override
    public Iterator iterator()
    {
        return map.keySet().iterator();
    }

    @Override
    public int size()
    {
        return map.size();
    }

    public AmigoSet()
    {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection)
    {
        map = new HashMap<>((int)Math.max(16,collection.size()/.75f));
        this.addAll(collection);
    }

    public boolean add(E e)
    {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean isEmpty()
    {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return map.keySet().contains(o);
    }

    @Override
    public boolean remove(Object o)
    {
        return map.keySet().remove(o);
    }

    @Override
    public void clear()
    {
        map.keySet().clear();
    }

    public Object clone()
    {
        AmigoSet amigoSet;
        try
        {
            amigoSet = new AmigoSet(map.keySet());
        } catch (Exception e)
        {
            throw new InternalError();
        }
        return amigoSet;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        Set set = map.keySet();
        int size = set.size();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");

        out.writeObject(capacity);
        out.writeObject(loadFactor);
        out.writeObject(size);
        for (Object object : set)
        {
            out.writeObject(object);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        int capacity = (int) in.readObject();
        float loadFactor = (float) in.readObject();

        map = new HashMap<>(capacity, loadFactor);

        int size = (int) in.readObject();
        for (int i = 0; i < size; i++)
        {
            map.put((E) in.readObject(), PRESENT);
        }
    }
}
