package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int symbolsCount = 0;
        int spacesCount = 0;

        while (inputStream.available() > 0)
        {
            symbolsCount++;
            if (inputStream.read() == ' ')
            {
                spacesCount++;
            }
        }
        float rezult = spacesCount*(1.0f) / symbolsCount * 100;
        System.out.printf("%.2f", rezult);
        //System.out.println("spaces=" + spacesCount + " symbols=" + symbolsCount + " rezult=" + rezult);
        inputStream.close();
    }
}
