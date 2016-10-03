package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get()
    {
        try
        {
            while (!isValuePresent)
                wait();
            System.out.println("Got: " + value);
        }
        catch (InterruptedException e) {}
        finally
        {
            isValuePresent = false;
            notifyAll();
            return value;
        }
    }

    public synchronized void put(int value)
    {
        try
        {
            while (isValuePresent)
                wait();
            this.value = value;
            System.out.println("Put: " + value);
        }
        catch (InterruptedException e) {}
        finally
        {
            isValuePresent = true;
            notifyAll();
        }
    }
}
