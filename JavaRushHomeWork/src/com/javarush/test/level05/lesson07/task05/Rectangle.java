package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height
(левая координата, верхняя, ширина и высота). Создать для него как можно больше методов
initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    public int left;
    public int top;
    public int height;
    public int widht;


    public void initialize (int left, int top, int widht, int height){
        this.left = left;
        this.top = top;
        this.widht = widht;
        this.height = height;
    }
    public void initialize (int left, int top){
        this.left = left;
        this.top = top;
        widht = 0;
        height = 0;
    }
    public void initialize (int left, int top, int widht){
        this.left = left;
        this.top = top;
        this.widht = widht;
        height = widht;
    }
    public void initialize (Rectangle rect){
        rect = this;
    }

}
