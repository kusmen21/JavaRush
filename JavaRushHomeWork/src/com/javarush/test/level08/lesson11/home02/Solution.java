package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве
 cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть.
 Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();
        Cat cat1 = new Cat();
        result.add(cat1);
        Cat cat2 = new Cat();
        result.add(cat2);
        Cat cat3 = new Cat();
        result.add(cat3);
        Cat cat4 = new Cat();
        result.add(cat4);
        return result;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> rezult = new HashSet<>();
        Dog dog1 = new Dog();
        rezult.add(dog1);
        Dog dog2 = new Dog();
        rezult.add(dog2);
        Dog dog3 = new Dog();
        rezult.add(dog3);
        return rezult;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        HashSet<Object> pets = new HashSet<>();
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext()){
            pets.add(iterator.next());
        }
        Iterator<Dog> iterator2 = dogs.iterator();
        while (iterator2.hasNext()){
            pets.add(iterator2.next());
        }
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        Iterator<Object> iterator = pets.iterator();
        while (iterator.hasNext()){
            if (cats.contains(iterator.next())){
                iterator.remove();
            }
        }
    }

    public static void printPets(Set<Object> pets)
    {
        Iterator<Object> iterator = pets.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static class Cat{
    }
    public static class Dog{
    }
}
