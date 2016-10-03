 package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];

        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
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
