package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        Charset winfows_1251 = Charset.forName("Windows-1251");
        Charset utf_8 = Charset.forName("UTF-8");
        String filename = args[0];
        String filenameOut = args[1];
        FileInputStream inputStream = new FileInputStream(filename);
        FileOutputStream outputStream = new FileOutputStream(filenameOut);

        int count = inputStream.available();
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer, utf_8);
        buffer = s.getBytes(winfows_1251);
        outputStream.write(buffer);















    }
}
