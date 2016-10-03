package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new FileReader(br.readLine()));
        br.close();
        StringBuilder sb = new StringBuilder();
        while (br2.ready())
        {
            sb.append(br2.readLine()).append(" ");
        }
        br2.close();
        String[] word = sb.toString().split(" ");
        sb.delete(0, sb.length());
        for (int i = 0; i < word.length - 1; i++)
        {
            for (int j = i + 1; j < word.length; j++)
            {
                sb.append(word[j]);
                sb.reverse();
                System.out.println(sb.toString());
                if (word[i].equals(sb.toString()) && !word[i].equals(""))
                {
                    Pair pair = new Pair();
                    pair.first = word[i];
                    pair.second = word[j];
                    result.add(pair);
                    for (int d = j+1; d < word.length; d++)
                    {
                        if (word[d].equals(word[i]) || word[d].equals(word[j])) word[d]="";
                    }
                    word[i] = "";
                    word[j] = "";
                }
                sb.delete(0, sb.length());
            }
        }
        System.out.println(result.size());
        for (Pair p : result){
            System.out.println(p);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

