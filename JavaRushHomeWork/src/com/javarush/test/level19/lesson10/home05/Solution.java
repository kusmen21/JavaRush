package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)
    {
        String filename = args[0];
        String filename2 = args[1];
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        BufferedReader reader = null;
        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(filename));
            writer = new FileWriter(filename2);

            while (reader.ready())
            {
                lines.add(reader.readLine());
            }

            for (String line : lines)
            {
                String[] tempWords = line.split(" ");

                for (String word : tempWords)
                {
                    if (word.matches(".*\\d+.*"))
                    {
                        words.add(word);
                    }
                }
            }

            for (String word : words)
            {
                writer.write(word);
                writer.write(" ");
            }
            reader.close();
            writer.close();
        }catch (Exception e)
        {

        }

    }
}
