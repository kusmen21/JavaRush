package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество
 отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомы
 значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n1 = reader.readLine();
        int a = Integer.parseInt(n1);
        n1 = reader.readLine();
        int b = Integer.parseInt(n1);
        n1 = reader.readLine();
        int c = Integer.parseInt(n1);

        polozh(a, b, c);
    }

    public static void polozh(int a, int b, int c)
    {
        int Kpol = 0;
        int Kotr = 0;


        if (a > 0)
            Kpol++;
        if (b > 0)
            Kpol++;
        if (c > 0)
            Kpol++;

        if (a < 0)
            Kotr++;
        if (b < 0)
            Kotr++;
        if (c < 0)
            Kotr++;

        System.out.println("количество отрицательных чисел: "+Kotr);
        System.out.println("количество положительных чисел: "+Kpol);

    }
}
