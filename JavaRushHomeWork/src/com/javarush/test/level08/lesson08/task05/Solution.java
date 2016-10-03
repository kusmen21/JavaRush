package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String>  map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<>(map);
        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator();
        while (iterator.hasNext()){
            removeItemFromMapByValue(map, iterator.next().getValue());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        String key="";
        int e=0;
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if ((pair.getValue().equals(value)&&(e==0))){
                e++;
                key=pair.getKey();
            }else
            if ((pair.getValue().equals(value))&&(e>0))
            {
                map.remove(key);
                map.remove(pair.getKey());
            }
        }
    }
}
