package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        HashMap<Byte, Integer> map = new HashMap<>();

        while (inputStream.available() > 0)
        {
            byte temp = (byte) inputStream.read();
            if(map.containsKey(temp))
            {
                for(Map.Entry<Byte, Integer> pair : map.entrySet())
                {
                    if (pair.getKey() == temp)
                    {
                        pair.setValue(pair.getValue()+1);
                    }
                }
            }else{
                map.put(temp, 1);
            }
        }
        ArrayList<Byte> list = new ArrayList<>();
        for(Map.Entry<Byte, Integer> pair : map.entrySet())
        {
            list.add(pair.getKey());
        }
        ArrayList<Byte> rezultat = new ArrayList<>();
        byte temp = list.get(0);
        rezultat.add(temp);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= rezultat.get(i-1)) {
                rezultat.add(list.get(i));
            } else {
                for (int j = i - 1; ; j--) {
                    if (j == 0) {
                        rezultat.add(0, list.get(i));
                        break;
                    }
                    if (list.get(i) >= rezultat.get(j-1)) {
                        rezultat.add(j, list.get(i));
                        break;
                    }
                }
            }
        }
        //System.out.println(map);
        //System.out.println(list);
        //System.out.println(rezultat);
        for (byte x : rezultat)
        {
            for(Map.Entry<Byte, Integer> pair : map.entrySet())
            {
                if (pair.getKey() == x)
                {
                    int c = (int) pair.getKey();
                    char cc = (char) c;
                    System.out.println(cc + " " + pair.getValue());
                    map.remove(pair.getKey());
                    break;
                }
            }
        }
        inputStream.close();
    }
}
