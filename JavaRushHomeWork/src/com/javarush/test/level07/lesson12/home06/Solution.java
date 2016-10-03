package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
 Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при
 выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human grandFather1 = new Human("Sergei", true, 65, null, null);
        Human grandFather2 = new Human("Alexandr", true, 72, null, null);
        Human grandMother1 = new Human("Elena", false, 70, null, null);
        Human grandMother2 = new Human("Raya", false, 68, null, null);
        Human father = new Human("Alexandr", true, 54, grandFather2, grandMother2);
        Human mother = new Human("olga", false, 49, grandFather1, grandMother1);
        Human child1 = new Human("dima", true, 22, father, mother);
        Human child2 = new Human("tanya", false, 28, father, mother);
        Human child3 = new Human("max", true, 16, father, mother);
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
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
