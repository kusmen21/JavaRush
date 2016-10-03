package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
 Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
  Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        int massiv1[] = {1,2,3,4,5};
        int massiv2[] = {1,2};
        int massiv3[] = {1,2,3,4};
        int massiv4[] = {1,2,3,4,5,6,7};
        int massiv5[] = {};
        ArrayList<int[]> list = new ArrayList<>();
        list.add(massiv1);
        list.add(massiv2);
        list.add(massiv3);
        list.add(massiv4);
        list.add(massiv5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
