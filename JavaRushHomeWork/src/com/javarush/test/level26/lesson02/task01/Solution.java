package com.javarush.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {

    public static void main(String[] args)
    {
        Integer[] array = {1, 2, 3, 4, 100};

        for(int x : sort(array))
        {
            System.out.print(x + " ");
        }
        System.out.println();


    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        List<Integer> sorted = Arrays.asList(array);
        final float mediane;

        if (array.length % 2 == 0)
            mediane = (array[array.length / 2 - 1] + array[array.length / 2]) / 2f;
        else
            mediane = array[array.length / 2];


        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                if (Math.abs(o1 - mediane) != Math.abs(o2 - mediane))
                    return (int) (Math.abs(o1 - mediane) - Math.abs(o2 - mediane));
                else
                    return o1 - o2;
            }
        };

        Collections.sort(sorted, comparator);

        sorted.toArray(array);

        return array;
    }
}
