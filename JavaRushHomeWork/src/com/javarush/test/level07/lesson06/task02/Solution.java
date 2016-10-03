package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        list.add(0, reader.readLine());
        list.add(1, reader.readLine());
        list.add(2, reader.readLine());
        list.add(3, reader.readLine());
        list.add(4, reader.readLine());
        temp.add(0, list.get(0));

        for (int i = 1; i < list.size(); i++){

            if (list.get(i).length() == temp.get(0).length()){
                temp.add(list.get(i));
            }
            if (list.get(i).length() > temp.get(0).length()){
                temp.clear();
                temp.add(0, list.get(i));
            }
        }
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i));
        }
    }
}
