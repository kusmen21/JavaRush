package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        printFile(getFileName());
    }

    private static String getFileName() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        return filename;
    }

    private static void printFile(String fileName) throws IOException
    {
        InputStream inStream = new FileInputStream(fileName);

        while (inStream.available() > 0)
        {
            System.out.print((char) inStream.read());
        }
        inStream.close();
    }
}
