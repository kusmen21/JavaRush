package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое
и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int a = Integer.parseInt(text);
        text = reader.readLine();
        int b = Integer.parseInt(text);
        text = reader.readLine();
        int c = Integer.parseInt(text);

        if ((a < b && a > c)||(a > b && a < c)){
            System.out.println(a);
        }
        if ((b < a && b > c)||(b > a && b < c)){
            System.out.println(b);
        }
        if ((c < b && c > a)||(c > b && c < a)){
            System.out.println(c);
        }

    }
}
