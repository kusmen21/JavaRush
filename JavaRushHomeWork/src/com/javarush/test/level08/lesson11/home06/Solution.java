package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("Dima", true, 22, null);
        Human child2 = new Human("Tanya", false, 28, null);
        Human child3 = new Human("Max", true, 16, null);
        ArrayList<Human> childrens1 = new ArrayList<>();
        childrens1.add(child1);
        childrens1.add(child2);
        childrens1.add(child3);

        Human father = new Human("Alexandr", true, 54, childrens1);
        Human mother = new Human("Olga", false, 49, childrens1);
        ArrayList<Human> childrensF = new ArrayList<>();
        childrensF.add(father);
        ArrayList<Human> childrensM = new ArrayList<>();
        childrensM.add(mother);

        Human grandFather1 = new Human("Sergei", true, 65, childrensF);
        Human grandFather2 = new Human("Alexandr", true, 72, childrensM);
        Human grandMother1 = new Human("Elena", false, 70, childrensF);
        Human grandMother2 = new Human("Raya", false, 68, childrensM);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (children != null)
            {
                int childCount = this.children.size();
                if (childCount > 0)
                {
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++)
                    {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
                }
            }
            return text;
        }
    }
}
