package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        public int age;
        public int weight;
        public int rost;
        public int size;
        public int zrenie;
        public String name;
        public String wife;
        public String son;
        public String daughter;
        public String klichka;

        public Human(int age, int weight, int rost, int size, int zrenie, String name, String wife, String son, String daughter, String klichka)
        {
            this.age = age;
            this.weight = weight;
            this.rost = rost;
            this.size = size;
            this.zrenie = zrenie;
            this.name = name;
            this.wife = wife;
            this.son = son;
            this.daughter = daughter;
            this.klichka = klichka;
        }
        public Human(int age, int weight, int rost, int size, int zrenie, String name, String wife, String son, String daughter)
        {
            this.age = age;
            this.weight = weight;
            this.rost = rost;
            this.size = size;
            this.zrenie = zrenie;
            this.name = name;
            this.wife = wife;
            this.son = son;
            this.daughter = daughter;
        }
        public Human(int age, int weight, int rost, int size, int zrenie, String name, String wife, String son)
        {
            this.age = age;
            this.weight = weight;
            this.rost = rost;
            this.size = size;
            this.zrenie = zrenie;
            this.name = name;
            this.wife = wife;
            this.son = son;
        }
        public Human(int age, int weight, int rost, int size, int zrenie, String name, String wife)
        {
            this.age = age;
            this.weight = weight;
            this.rost = rost;
            this.size = size;
            this.zrenie = zrenie;
            this.name = name;
            this.wife = wife;
        }
        public Human(int age, int weight, int rost, int size, int zrenie, String name)
        {
            this.age = age;
            this.weight = weight;
            this.rost = rost;
            this.size = size;
            this.zrenie = zrenie;
            this.name = name;
        }
        public Human(int age, int weight, int rost, int size, int zrenie)
        {
            this.age = age;
            this.weight = weight;
            this.rost = rost;
            this.size = size;
            this.zrenie = zrenie;
        }
        public Human(int age, int weight, int rost, int size)
        {
            this.age = age;
            this.weight = weight;
            this.rost = rost;
            this.size = size;
        }
        public Human(int age, int weight, int rost)
        {
            this.age = age;
            this.weight = weight;
            this.rost = rost;
        }
        public Human(int age, int weight)
        {
            this.age = age;
            this.weight = weight;
        }
        public Human(int age)
        {
            this.age = age;
        }

    }
}
