package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            list.add(Character.toString(s.charAt(i)));
        }

        boolean isSpace = true;
        String rezult = "";
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(" ")){
                isSpace = true;
            }
            if (!(list.get(i).equals(" ")) && isSpace){
                list.set(i, list.get(i).toUpperCase());
                isSpace = false;
            }
        }
        for (int i = 0; i < list.size(); i++){
            rezult += list.get(i);
        }
        System.out.println(rezult);
    }
}










/*
 String rezult = Character.toString(s.charAt(0)).toUpperCase();
        int start = 0;

        for (int i = 1; ;i++){
            if (Character.toString(s.charAt(i)).equals(" ")){
                int end = i-1;
                char[] tempStr = new char[s.length()];
                s.getChars(start, end, tempStr, 0);


            }
        }
        //System.out.println(rezult);
 */