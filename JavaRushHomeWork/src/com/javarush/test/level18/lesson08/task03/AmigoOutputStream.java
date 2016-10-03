package com.javarush.test.level18.lesson08.task03;

import java.io.*;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream
{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream original;

    @Override
    public void close() throws IOException
    {
        //super.close();
        original.flush();
        original.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        original.close();
    }

    public AmigoOutputStream(FileOutputStream original) throws FileNotFoundException
    {
        super(fileName);
        this.original = original;
    }

    public void flush() throws IOException {
        original.flush();
    }
    public void write(int b) throws IOException{
        original.write(b);
    }
    public void write(byte[] b) throws IOException{
        original.write(b);
    }
    public void write(byte[] b, int off, int len) throws IOException{
        original.write(b,off,len);
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
