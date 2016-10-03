package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между
собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n1 = reader.readLine();
        int N1 = Integer.parseInt(n1);
        String n2 = reader.readLine();
        int N2 = Integer.parseInt(n2);
        String n3 = reader.readLine();
        int N3 = Integer.parseInt(n3);

        if (N1 == N2)
            System.out.println("3");

        if (N1 == N3)
            System.out.println("2");

        if (N2 == N3)
            System.out.println("1");

    }
}
