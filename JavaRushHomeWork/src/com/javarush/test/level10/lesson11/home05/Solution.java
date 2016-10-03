package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 33; i++){
            map.put(alphabet.get(i), 0);
        }

        for (int i = 0; i < list.size(); i++){      //podshet bukv
            for (int j = 0; j < list.get(i).length(); j++){
                char tempLetter = list.get(i).charAt(j);
                for (Map.Entry<Character, Integer> pair : map.entrySet()){
                    if (pair.getKey().equals(tempLetter)){
                            pair.setValue(pair.getValue() + 1);
                    }
                }
            }
        }

        for (int i = 0; i < alphabet.size(); i++)
        {
            char tempLetter = alphabet.get(i);
            for (Map.Entry<Character, Integer> pair : map.entrySet())
            {
                if (pair.getKey().equals(tempLetter))
                {
                    System.out.println(pair.getKey() + " " + pair.getValue());
                }
            }
        }

    }
}
