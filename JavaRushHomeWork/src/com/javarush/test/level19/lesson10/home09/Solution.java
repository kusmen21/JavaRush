package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream source = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream wrapper = new PrintStream(baos);
        System.setOut(wrapper);
        testString.printSomething();
        String[] text = baos.toString().split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length; i++)
        {
            if (i != 0)
                sb.append("\n");

            sb.append(text[i]);

            if ((i != 0) && (i % 2 != 0))
                sb.append("\nJavaRush - курсы Java онлайн");
        }
        System.setOut(source);
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
