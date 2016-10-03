package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
 если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        isDateOdd("JAN 26 2013");
    }

    public static boolean isDateOdd(String date)
    {
        Date den = new Date(date);
        Date nachaloGoda = new Date();
        nachaloGoda.setMonth(0);
        nachaloGoda.setYear(den.getYear());
        nachaloGoda.setDate(1);
        nachaloGoda.setHours(0);
        nachaloGoda.setMinutes(0);
        nachaloGoda.setSeconds(0);

        //System.out.println(den);
        //System.out.println(nachaloGoda);

        long msDay = 24 * 60 * 60 * 1000;
        //System.out.println((den.getTime() - nachaloGoda.getTime()) / msDay + 1);

        if (((den.getTime() - nachaloGoda.getTime()) / msDay + 1) % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
}
