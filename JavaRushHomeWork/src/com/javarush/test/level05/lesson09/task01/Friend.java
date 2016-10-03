package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    public Friend(String name){
        name = "dimon";
    }
    public Friend(String name, int age){
        name = "dimon";
        age = 15;
    }
    public Friend(String name, int age, boolean sex){
        name = "dimon";
        age = 15;
        sex = true;
    }

}