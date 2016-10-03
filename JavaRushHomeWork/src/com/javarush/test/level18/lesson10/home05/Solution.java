package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        //String filename1 = "D:\\1.txt";
        //String filename2 = "D:\\2.txt";
        FileInputStream inputStream = new FileInputStream(filename1);
        FileOutputStream outputStream = new FileOutputStream(filename2);

        int count = inputStream.available();
        byte[] buffer = new byte[count];
        inputStream.read(buffer);

        ArrayList<Character> charArray = new ArrayList<>();
        for (byte x: buffer)
        {
            charArray.add((char) x);
        }

        ArrayList<Double> doubleArray = new ArrayList<>();
        StringBuilder temp = new StringBuilder("");
        try{

            while(true)
            {
                if (charArray.get(0) == ' ')
                {
                    doubleArray.add(Double.parseDouble(temp.toString()));
                    temp.delete(0, temp.length());
                }else
                {
                    temp.append(charArray.get(0));
                }
                charArray.remove(0);
            }
        } catch (Exception e){
            doubleArray.add(Double.parseDouble(temp.toString()));
        }

        for(double x : doubleArray)
        {
            String tempString = Long.toString(Math.round(x));
            byte[] tempArray = tempString.getBytes();
            outputStream.write(tempArray, 0, tempArray.length);
            outputStream.write(" ".getBytes());
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
