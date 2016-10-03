package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Polurival
 * on 18.04.16.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        int x0 = getX() - (getWidth() / 2);
        int y0 = getY() - (getHeight() / 2);
        graphics.setColor(Color.RED);
        graphics.drawOval(x0, y0, getWidth(), getHeight());
    }
}
