package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int a = Integer.parseInt(text);
        text = reader.readLine();
        int b = Integer.parseInt(text);
        text = reader.readLine();
        int c = Integer.parseInt(text);

        int one = 0, two = 0, three = 0;

        if (a < b | a < c)
        {
            if (a < b && a < c)
            {
                three = a;
            } else
                two = a;
        }
        else one=a;
        if (b < a | b < c)
        {
            if (b < a && b < c)
            {
                three = b;
            } else
                two = b;
        }
        else one=b;
        if (c < a | c < b)
        {
            if (c < a && c < b)
            {
                three = c;
            } else
                two = c;
        }
        else one = c;
        System.out.println(one + " " + two + " " + three);
    }
}
