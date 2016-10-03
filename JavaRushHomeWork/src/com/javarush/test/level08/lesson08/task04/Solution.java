package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        removeAllSummerPeople(createMap());
    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("dimon", new Date("JUNE 2 1980"));
        map.put("leha", new Date("MARCH 3 1980"));
        map.put("vanya", new Date("JANUARY 4 1980"));
        map.put("olya", new Date("JUNE 5 1980"));
        map.put("sasha", new Date("JANUARY 6 1980"));
        map.put("bitch", new Date("JANUARY 7 1980"));
        map.put("hui", new Date("JUNE 8 1980"));
        map.put("loh", new Date("SEPTEMBER 9 1980"));
        map.put("durak", new Date("SEPTEMBER 10 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> x = map.entrySet().iterator();
        while (x.hasNext()){
            Map.Entry<String, Date> pair = x.next();
            Date chislo = pair.getValue();
            System.out.println(chislo);
            if ((chislo.getMonth() == 5) | (chislo.getMonth() == 6) | (chislo.getMonth() == 7))
            {
                x.remove();
            }
        }
    }
}
/*
 for (Map.Entry<String, Date> x :  map.entrySet()){
            Date chislo = x.getValue();
            System.out.println(chislo);
            //System.out.println(chislo.getMonth());

            if ((chislo.getMonth() == 5) | (chislo.getMonth() == 6) | (chislo.getMonth() == 7))
            {
                map.remove(x.getKey());
            }

        }
        System.out.println(map);
 */
