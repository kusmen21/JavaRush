package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String filename = "D:\\1.txt";
        String filename = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        String tempString;
        while ((tempString = fileReader.readLine()) != null)
        {
            list.add(tempString);
        }
        //System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for(String x : list)
        {
            for(int i = 0; i < x.length(); i++)
            {
                if(x.charAt(i) == ' ')
                {
                    int id = Integer.parseInt(sb.toString());
                    sb.delete(0, sb.length());
                    if (id == Integer.parseInt(args[0]))
                    {
                        System.out.println(x);
                    }
                    break;
                } else
                {
                    sb.append(x.charAt(i));
                }
            }
        }

        reader.close();
        fileReader.close();
    }
}
