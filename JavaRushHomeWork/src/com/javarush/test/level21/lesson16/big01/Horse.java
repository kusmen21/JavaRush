package com.javarush.test.level21.lesson16.big01;


public class Horse
{
    String name;
    double speed;
    double distance;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public Horse(String name, double speed, double distance)
    {

        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move()
    {
        speed = speed + Math.random();
        distance += speed;
    }

    public void print()
    {
        int intDistance = (int) distance;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intDistance; i++)
        {
            sb.append(".");
        }
        sb.append(name);
        System.out.println(sb);
    }
}
