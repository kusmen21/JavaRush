package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man vanya = new Man("vanya", 20, "bitch");
        Man dimon = new Man("dimon", 22, "chuvak");
        Woman olya = new Woman("olya", 22, "chuvak");
        Woman katya = new Woman("katya", 22, "chuvak");

        System.out.println(vanya.name + " " + vanya.age + " " + vanya.address);
        System.out.println(dimon.name + " " + dimon.age + " " + dimon.address);
        System.out.println(olya.name + " " + olya.age + " " + olya.address);
        System.out.println(katya.name + " " + katya.age + " " + katya.address);
    }

    public static class Man{
        public int age;
        public String name;
        public String address;
        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman{
        public int age;
        public String name;
        public String address;
        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }


}
