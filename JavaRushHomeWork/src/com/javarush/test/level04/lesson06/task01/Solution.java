package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String text = reader.readLine();
        int n1 = Integer.parseInt(text);
        text = reader.readLine();
        int n2 = Integer.parseInt(text);

        if (n1<n2)
            System.out.println(n1);

        else
            System.out.println(n2);

    }
}