package com.javarush.test.level04.lesson07.task02;

/* Строка - описание
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание
следующего вида:
«четное однозначное число» - если число четное и имеет одну цифру,
«нечетное однозначное число» - если число нечетное и имеет одну цифру,
«четное двузначное число» - если число четное и имеет две цифры,
«нечетное двузначное число» - если число нечетное и имеет две цифры,
«четное трехзначное число» - если число четное и имеет три цифры,
«нечетное трехзначное число» - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае ничего не выводить
на экран.
Пример для числа 100:
четное трехзначное число
Пример для числа 51:
нечетное двузначное число
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n1 = reader.readLine();
        int a = Integer.parseInt(n1);
        if (a <= 999 && a >=1)
        {
            chet(a);
            chislo(a);
        }
    }

    public static void chislo(int n)
    {
        if (n <= 999 && n >=100)
            System.out.print("трехзначное число");
        if (n <= 99 && n >=10)
            System.out.print("двузначное число");
        if (n <= 9 && n >=1)
            System.out.print("однозначное число");
    }

    public static void chet(int n)
    {
        if (n%2 == 0)
            System.out.print("четное ");
        else
            System.out.print("нечетное ");
    }
}
