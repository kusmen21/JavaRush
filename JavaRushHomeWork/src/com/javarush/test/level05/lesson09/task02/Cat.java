package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    String name;
    int weight = 6;
    int age = 2;
    String colour;
    String address;
    public Cat(String name)
    {
        this.name = name;
        this.weight = 6;
        this.age = 2;
        this.colour = null;
        this.address = null;
    }
    public Cat(String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.colour = null;
        this.address = null;
    }
    public Cat(String name, int age)
    {
        this.name = name;
        this.weight = 6;
        this.age = age;
        this.colour = null;
        this.address = null;
    }
    public Cat(int weight, String colour)
    {
        this.name = null;
        this.weight = weight;
        this.age = 2;
        this.colour = colour;
        this.address = null;
    }
    public Cat(int weight, String colour, String address)
    {
        this.name = null;
        this.weight = weight;
        this.age = 2;
        this.colour = colour;
        this.address = address;
    }
}