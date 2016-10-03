package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int n1=0;
        int n2=0;
        int n3=0;
        int n4=0;
        int n5=0;

        for (int i = 1; i <=5; i++){
            int t = Integer.parseInt(reader.readLine());
            if (i == 1){
                n1 = t;
            }
            if (i == 2){
                if (t < n1){
                    n2 = n1;
                    n1 = t;
                    continue;
                }else {
                    n2 = t;
                }
            }
            if (i == 3){
                if (t < n1) {
                    n3 = n2;
                    n2 = n1;
                    n1 = t;
                    continue;
                }
                if (t < n2){
                    n3 = n2;
                    n2 = t;
                    continue;
                }
                if (t > n2){
                    n3 = t;
                }
            }
            if (i == 4){
                if (t < n1) {
                    n4 = n3;
                    n3 = n2;
                    n2 = n1;
                    n1 = t;
                    continue;
                }
                if (t < n2){
                    n4 = n3;
                    n3 = n2;
                    n2 = t;
                    continue;
                }
                if (t < n3){
                    n4 = n3;
                    n3 = t;
                    continue;
                }
                if (t > n3){
                    n4 = t;
                }
            }
            if (i == 5){
                if (t < n1) {
                    n5 = n4;
                    n4 = n3;
                    n3 = n2;
                    n2 = n1;
                    n1 = t;
                    continue;
                }
                if (t < n2){
                    n5 = n4;
                    n4 = n3;
                    n3 = n2;
                    n2 = t;
                    continue;
                }
                if (t < n3){
                    n5 = n4;
                    n4 = n3;
                    n3 = t;
                    continue;
                }
                if (t < n4){
                    n5 = n4;
                    n4 = t;
                    continue;
                }
                if (t > n4){
                    n5 = t;
                }
            }
        }
        System.out.println(n1 + "\n" + n2 + "\n" + n3 + "\n" + n4 + "\n" + n5);
    }
}
