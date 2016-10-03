package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        //String filename1 = "D:\\1.txt";
        //String filename2 = "D:\\2.txt";

        FileInputStream inputStream = new FileInputStream(filename2);
        FileInputStream inputStream1 = new FileInputStream(filename1);

        byte[] buffer;
        int count = inputStream1.available();
        buffer = new byte[count];
        inputStream1.read(buffer);

        FileOutputStream outputStream = new FileOutputStream(filename1);
        while(inputStream.available() > 0)
        {
            outputStream.write(inputStream.read());
        }

        for (int x:buffer)
        {
            outputStream.write(x);
        }

        reader.close();
        inputStream.close();
        outputStream.close();
        inputStream1.close();
    }
}
//for(int x:buffer)
//{
//    System.out.println(x);
//}
