package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        writeInFile(getStrings(), getFileName());
        //System.out.println(getFileName());
        //System.out.println(getStrings());
        //outStream.close();
        //reader.close();
    }

    private static String getFileName() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static ArrayList<String> getStrings() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true)
        {
            String tempString = reader.readLine();
            if (tempString.equals("exit")){
                break;
            }
            list.add(tempString);
        }
        return list;
    }

    private static void writeInFile(ArrayList<String> list, String filename) throws Exception
    {
        OutputStream outStream = new FileOutputStream("c:/1.txt");

        for (int i = 0; i < list.size(); i++)
        {
            char[] stringInChar = list.get(i).toCharArray();
            for (int j = 0; j < stringInChar.length; j++)
            {
                outStream.write(stringInChar[j] + '\n');
            }
        }
    }

}

