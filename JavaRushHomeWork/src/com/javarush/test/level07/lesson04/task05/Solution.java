package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] chisla = new int[20];
        int[] temp = new int[10];
        int[] temp2 = new int[10];
        int j = 0;

        for (int i = 0; i < chisla.length; i++){
            chisla[i] = Integer.parseInt(reader.readLine());
        }

        System.arraycopy(chisla, 0, temp, 0, chisla.length / 2);

        for (int i = chisla.length / 2; i < chisla.length; i++){
            temp2[j] = chisla[i];
            j++;
        }
        for (int aTemp2 : temp2)
        {
            System.out.println(aTemp2);
        }

    }
}
