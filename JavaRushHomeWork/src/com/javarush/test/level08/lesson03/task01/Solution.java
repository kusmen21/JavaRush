package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис,
картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashSet<String> jratva = new HashSet<>();
        jratva.add("арбуз");
        jratva.add("банан");
        jratva.add("вишня");
        jratva.add("груша");
        jratva.add("дыня");
        jratva.add("ежевика");
        jratva.add("жень-шень");
        jratva.add("земляника");
        jratva.add("ирис");
        jratva.add("картофель");

        Iterator<String> x = jratva.iterator();

        while (x.hasNext()){
            System.out.println(x.next());
        }

    }
}
