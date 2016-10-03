package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> rezultat = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        String temp = list.get(0);
        rezultat.add(temp);

        for (int i = 1; i < 20; i++) {
            if (isGreaterThan(list.get(i), rezultat.get(i-1))) {
                rezultat.add(list.get(i));
            } else {
                for (int j = i - 1; ; j--) {
                    if (j == 0) {
                        rezultat.add(0, list.get(i));
                        break;
                    }
                    if (isGreaterThan(list.get(i), rezultat.get(j-1))) {
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

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
