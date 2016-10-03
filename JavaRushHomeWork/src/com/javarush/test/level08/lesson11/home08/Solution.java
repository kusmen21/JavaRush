package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> rezultat = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        int temp = list.get(0);
        rezultat.add(temp);

        for (int i = 1; i < 20; i++) {
            if (list.get(i) <= rezultat.get(i-1)) {
                rezultat.add(list.get(i));
            } else {
                for (int j = i - 1; ; j--) {
                    if (j == 0) {
                        rezultat.add(0, list.get(i));
                        break;
                    }
                    if (list.get(i) <= rezultat.get(j-1)) {
                        rezultat.add(j, list.get(i));
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < rezultat.size(); i++) {
            array[i] = rezultat.get(i);
        }
    }
}
