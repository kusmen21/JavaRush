package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        inspection(textIn());
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);

        for (char d : vowels)
        {
            if (c == d)
                return true;
        }
        return false;
    }

    public static ArrayList<String> textIn() throws IOException{
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String phrase = reader.readLine();
        for (int i = 0; i < phrase.length(); i++){
            list.add(Character.toString(phrase.charAt(i)));
        }
        return list;
    }

    public static void inspection(ArrayList<String> list){
        ArrayList<String> glasnue = new ArrayList<>();
        ArrayList<String> soglasnue = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            if (isVowel(list.get(i).charAt(0)))
            {
                glasnue.add(list.get(i));
            }
            if (!(isVowel(list.get(i).charAt(0))) && !(list.get(i).equals(" ")))
            {
                soglasnue.add(list.get(i));
            }
        }
        for (String x:glasnue)
        {
            System.out.print(x + " ");
        }

        System.out.print("\n");

        for (String x:soglasnue)
        {
            System.out.print(x + " ");
        }
    }

}

