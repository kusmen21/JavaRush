package com.javarush.test.level26.lesson10.home02;


import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable
{
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    public void run()
    {
        try
        {
            int i = 1;
            while (true)
            {
                System.out.format("Some text for %d\n", i);
                i++;
                Thread.sleep(500);
            }
        }catch (Exception e)
        {
            System.out.format("[%s] thread was terminated\n", Thread.currentThread().getName());
        }
    }
}
