package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(removeAllNumbersMoreThan10(createSet()));
    }
    public static HashSet<Integer> createSet()
    {
        HashSet <Integer> mnojestvo = new HashSet<>();
        for (int i = 0; i < 20; i++){
            mnojestvo.add(i*2);
        }
        return mnojestvo;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {

        Iterator<Integer> x = set.iterator();
        while (x.hasNext())
        {
            int i = x.next();
            if (i > 10)
            {
                x.remove();
            }
        }


        return set;
    }
}
