package com.javarush.test.level04.lesson07.task01;

/* Строка - описание
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» - если число отрицательное и четное,
«отрицательное нечетное число» - если число отрицательное и нечетное,
«нулевое число» - если число равно 0,
«положительное четное число» - если число положительное и четное,
«положительное нечетное число» - если число положительное и нечетное.
Пример для числа 100:
положительное четное число
Пример для числа -51:
отрицательное нечетное число
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n1 = reader.readLine();
        int a = Integer.parseInt(n1);

        if (a == 0){
            System.out.println("нулевое число");}
        else
        {
            znak(a);
            chet(a);
        }
    }

    public static void znak(int n)
    {
        if (n < 0)
            System.out.print("отрицательное ");
        else
            System.out.print("положительное ");
    }

    public static void chet(int n)
    {
        if (n%2 == 0)
            System.out.print("четное число");
        else
            System.out.print("нечетное число");
    }
}



