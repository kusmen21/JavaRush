package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он
мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        String grandMotherName = reader.readLine();
        String fatherName = reader.readLine();
        String motherName = reader.readLine();
        String sonName = reader.readLine();
        String daughterName = reader.readLine();

        Cat catGrandFatherPapa = new Cat(grandFatherName);
        Cat catGrandMotherMama = new Cat(grandMotherName);
        Cat catFather = new Cat(fatherName, catGrandFatherPapa, true);
        Cat catMother = new Cat(motherName, catGrandMotherMama, false);
        Cat catSon = new Cat(sonName, catFather, catMother);
        Cat catDaughter = new Cat(daughterName, catFather, catMother);

        System.out.println(catGrandFatherPapa);
        System.out.println(catGrandMotherMama);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parent;
        private Cat parent2;

        Cat(String name)
        {
            this.name = name;
        }
        Cat(String name, Cat parent, boolean isFather)
        {
            this.name = name;
            if (isFather) {
                this.parent = parent;
            } else{
                this.parent2 = parent;
            }
        }
        Cat(String name, Cat parent, Cat parent2)
        {
            this.name = name;
            this.parent = parent;
            this.parent2 = parent2;
        }
        @Override
        public String toString()
        {
            if ((parent == null) && (parent2 == null)) {
                return "Cat name is " + name + ", no mother" + ", no father";
            } else if (parent == null) {
                return "Cat name is " + name + ", mother is " + parent2.name + ", no father";
            } else if (parent2 == null) {
                return "Cat name is " + name + ", no mother" + ", father is " + parent.name ;
            } else {
                return "Cat name is " + name + ", mother is " + parent2.name
                        + ", father is " + parent.name;
            }
        }
    }
}
