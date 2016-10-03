package com.javarush.test.level07.lesson04.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max); // сюда возвращаем значение max? вроде.
    }
    public static int[] initializeArray() throws IOException { // Эта функция возвращает массив какое слово отвечает за это????
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // считываем с клавы
        int massiv[] = new int[20]; // создали массив из 20 ячеек
        for(int j = 0; j < 20; j++ ){ // цикл for
            int i = Integer.parseInt(reader.readLine()); // переменная i - ввод с клавиатуры
            massiv[j] = i; // в каждую ячейку массива о вводим i
        }
        return massiv; // возвращаем массив КУДА????
    }
    public static int max(int[] array) { // здесь написано что должны вернуть int max, гдеэто написано, вернее какие слова отвечают за это???
        int max = array[0]; // написали, что переменной max присвоили значение array[0]
        for (int i = 0; i < array.length; i++){ // измерили длину массива
            if (array[i] > max ) //если какой либо из массива больше чем max
                max = array[i]; // то max становиться этот фрагмент массива
        }
        return max; // возвращаем max - куда его возвращаем не понятно , модет в sout
    }
}