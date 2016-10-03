package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(filename2);
        FileOutputStream outputStream = new FileOutputStream(filename1);
        while (inputStream.available() > 0)
        {
           outputStream.write(inputStream.read());
        }

        FileInputStream inputStream2 = new FileInputStream(filename3);
        while(inputStream2.available() > 0)
        {
            outputStream.write(inputStream2.read());
        }
        inputStream.close();
        inputStream2.close();
        outputStream.close();
        reader.close();
    }
}
