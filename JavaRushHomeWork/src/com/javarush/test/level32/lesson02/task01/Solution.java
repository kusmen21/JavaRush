package com.javarush.test.level32.lesson02.task01;

import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args)
    {
        String filename = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw"))
        {
            if (Files.size(Paths.get(filename)) < number)
            {
                number = (int) Files.size(Paths.get(filename));
            }

            raf.seek(number);
            raf.write(text.getBytes());
        }
        catch (Exception e){}

    }
}
