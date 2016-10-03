package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] chisla = new int[10];
        int[] temp = new int[10];
        int j = chisla.length - 1;

        for (int i = 0; i < chisla.length; i++){
            chisla[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < chisla.length; i++){

            temp[j] = chisla[i];
            j--;
        }

        chisla = temp;

        for (int i = 0; i < chisla.length; i++){
            System.out.println(chisla[i]);
        }

    }
}
