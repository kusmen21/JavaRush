package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> numbersSorted = new ArrayList<>();
        ArrayList<String> rezultat = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        for (int i = 0; i < list.size(); i++)   //peremeshaem chisla v otdelnui massiv s sohraneniem polozheniya
        {
            if (isNumber(list.get(i))){
                numbers.add(Integer.parseInt(list.get(i)));
                rezultat.add("number");
                list.remove(i);
                i--;
            }
            else{
                rezultat.add("word");
            }
        }

        words.add(0, list.get(0));           //zapolnyaem rezultat slovami po vozrastaniu
        for (int i = 1; i < list.size(); i++) {
            if (isGreaterThan((list.get(i)), words.get(i-1))) {
                words.add(list.get(i));
            } else {
                for (int j = i - 1; ; j--) {
                    if (j == 0) {
                        words.add(0, list.get(i));
                        break;
                    }
                    if (isGreaterThan(list.get(i), words.get(j-1))) {
                        words.add(j, list.get(i));
                        break;
                    }
                }
            }
        }

        numbersSorted.add(0, numbers.get(0));           //zapolnyaem rezultat ciframi po vozrastaniu
        for (int i = 1; i < numbers.size(); i++) {
            if (isGreaterThan((numbers.get(i)), numbersSorted.get(i-1))) {
                numbersSorted.add(numbers.get(i));
            } else {
                for (int j = i - 1; ; j--) {
                    if (j == 0) {
                        numbersSorted.add(0, numbers.get(i));
                        break;
                    }
                    if (isGreaterThan(numbers.get(i), numbersSorted.get(j-1))) {
                        numbersSorted.add(j, numbers.get(i));
                        break;
                    }
                }
            }
        }

        int numberNext = 0;
        int wordNext = 0;
        for (int i = 0; i < rezultat.size(); i++){
            if (rezultat.get(i).equals("number")){
                rezultat.set(i, Integer.toString(numbersSorted.get(numberNext)));
                numberNext++;
            }
            if (rezultat.get(i).equals("word")){
                rezultat.set(i, words.get(wordNext));
                wordNext++;
            }
        }

        for (int i = 0; i < rezultat.size(); i++)
        {
            array[i] = rezultat.get(i);
        }
    }

    public static boolean isGreaterThan(String a, String b)
    {
        String A = Character.toString(a.charAt(0));
        String B = Character.toString(b.charAt(0));
        return A.compareTo(B) > 0;
    }

    public static boolean isGreaterThan(int a, int b)
    {
        return a<b ? true : false;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        try{
            int n = Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
/*
 if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
 */
