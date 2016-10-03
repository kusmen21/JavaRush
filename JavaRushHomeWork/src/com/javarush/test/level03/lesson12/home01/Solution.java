package com.javarush.test.level03.lesson12.home01;

/* Жить хорошо, а хорошо жить еще лучше
Вывести на экран надпись «Жить хорошо, а хорошо жить еще лучше»
*/

public class Solution
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        cat.name = "loh";
        Cat cat2 = new Cat();
        cat2.name = "bitch";
        System.out.println(cat.name+" "+cat2.name);
    }

    public static class Cat
    {
        String name;
    }
}
