package com.javarush.test.level33.lesson15.big01;


import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static void main(String[] args)
    {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> set = new HashSet<>();

        for (String string : strings)
        {
            set.add(shortener.getId(string));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> set = new HashSet<>();

        for (Long key : keys)
        {
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
        {
            strings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date timeOfBeginning = new Date();
        Set<Long> keys = getIds(shortener, strings);
        Date timeOfEnding = new Date();
        Helper.printMessage(String.valueOf(timeOfEnding.getTime() - timeOfBeginning.getTime()));

        Date timeOfBeginning2 = new Date();
        Set<String> resultStrings = getStrings(shortener, keys);
        Date timeOfEnding2 = new Date();
        Helper.printMessage(String.valueOf(timeOfEnding2.getTime() - timeOfBeginning2.getTime()));

        if (strings.size() == resultStrings.size())
        {
            Helper.printMessage("Тест пройден.");
        }
        else
        {
            Helper.printMessage("Тест не пройден.");
        }
    }

}




















