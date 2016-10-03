package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() ; i++){
            list.add(Character.toString(s.charAt(i)));
        }

        for (int i = 0; i < 40; i++){
            if (i == 0){
                for (String x:list)
                {
                    System.out.print(x);
                }
                System.out.print("\n");
                continue;
            }
            list.remove(0);
            for (String x:list)
            {
                System.out.print(x);
            }
            System.out.print("\n");
        }
    }

}
