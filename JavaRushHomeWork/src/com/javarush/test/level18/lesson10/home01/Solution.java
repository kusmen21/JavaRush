package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        ArrayList<Character> list = new ArrayList<>();

        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] array = a.toCharArray();
        List<Character> alphabet = new ArrayList<>();
        for(char x:array)
        {
            alphabet.add(x);
        }

        while (inputStream.available() > 0)
        {
            int oneByte = inputStream.read();
            if (
                    alphabet.contains((char) oneByte))
            {
                list.add((char) oneByte);
            }
        }
        System.out.println(list.size());
        inputStream.close();
    }
}
