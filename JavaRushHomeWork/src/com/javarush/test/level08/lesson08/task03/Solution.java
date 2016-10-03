package com.javarush.test.level08.lesson08.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println(createMap());
        System.out.println(getCountTheSameFirstName(createMap(), name));
    }
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> slovar = new HashMap<>();
        slovar.put("kuskfov", "dimgfa");
        slovar.put("kononov", "vanya");
        slovar.put("kuskfgov", "sasha");
        slovar.put("barankevich", "vanktutya");
        slovar.put("dfw", "sdfsdf");
        slovar.put("sdfsd", "sdfsdfsd");
        slovar.put("sdfvvsdfsd", "sdfsdfsd");
        slovar.put("sdfsdfsdf", "cvbcvb");
        slovar.put("kusfgmmkov", "cvbcvbcvb");
        slovar.put("dfgdfmmgd", "yuoyul");

        return slovar;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int kolvo = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            String familiya = iterator.next().getValue();
            if (familiya.equals(name))
            {
                kolvo++;
            }
        }
        return kolvo;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int kolvo = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            String familiya = iterator.next().getKey();
            if (familiya.equals(lastName))
            {
                kolvo++;
            }
        }
        return kolvo;
    }
}
