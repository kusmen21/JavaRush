package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args)
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","ivanov");
        map.put("country", "ukraine");
        map.put("city", "kiev");
        map.put("age", null);
        map.put(null, "afe");
        map.put("123", "312");
        System.out.println(getCondition(map));
    }

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();
        if (params.isEmpty() || params == null) return sb;
        for(Map.Entry<String, String> pair : params.entrySet())
        {
            if (pair.getKey()!=null && pair.getValue()!=null)
            {
               sb.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
            }
        }
        sb.delete(sb.length()-5, sb.length());
        return sb;
    }
}
