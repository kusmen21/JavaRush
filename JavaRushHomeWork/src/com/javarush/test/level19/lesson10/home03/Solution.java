package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        //String filename = args[0];
        String filename = "D:\\1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while(reader.ready())
        {
            String line = reader.readLine();
            String[] array = line.split(" ");
            int day = Integer.parseInt(array[array.length-3]);
            int year = Integer.parseInt(array[array.length-1]);
            int month = Integer.parseInt(array[array.length-2]);
            String name = "";
            for (int i = 0; i < array.length-3; i++)
            {
                if (i != 0){name += " ";}
                name += array[i];
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");


            PEOPLE.add(new Person(name, dateFormat.parse(day + " " + month + " " + year)));
        }
        //System.out.println(PEOPLE.get(0).getName() + PEOPLE.get(0).getBirthday());
        reader.close();
    }

}
