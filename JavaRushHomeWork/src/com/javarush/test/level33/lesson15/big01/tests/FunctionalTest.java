package com.javarush.test.level33.lesson15.big01.tests;


import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest
{
    /**
     14.4.	Добавь в класс FunctionalTest метод testStorage(Shortener shortener). Он
     должен:
     14.4.1.	Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
     14.4.2.	Получать и сохранять идентификаторы для всех трех строк с помощью
     shortener.
     14.4.3.	Проверять, что идентификатор для 2 строки не равен идентификатору для 1
     и 3 строк. Подсказка: метод Assert.assertNotEquals.
     14.4.4.	Проверять, что идентификаторы для 1 и 3 строк равны. Подсказка: метод
     Assert.assertEquals.
     14.4.5.	Получать три строки по трем идентификаторам с помощью shortener.
     14.4.6.	Проверять, что строки, полученные в предыдущем пункте, эквивалентны
     оригинальным. Подсказка: метод Assert.assertEquals.
     14.5.	Добавь в класс FunctionalTest тесты:
     14.5.1.	testHashMapStorageStrategy()
     14.5.2.	testOurHashMapStorageStrategy()
     14.5.3.	testFileStorageStrategy()
     14.5.4.	testHashBiMapStorageStrategy()
     14.5.5.	testDualHashBidiMapStorageStrategy()
     14.5.6.	testOurHashBiMapStorageStrategy()
     Каждый тест должен иметь аннотацию @Test, создавать подходящую стратегию,
     создавать объект класса Shortener на базе этой стратегии и вызывать метод
     testStorage для него.
     Запусти и проверь, что все тесты проходят.

     */
    @Test
    public void testHashMapStorageStrategy()
    {
        testStorage(new Shortener(new HashMapStorageStrategy()));
    }
    @Test
    public void testOurHashMapStorageStrategy()
    {
        testStorage(new Shortener(new OurHashMapStorageStrategy()));
    }
    @Test
    public void testFileStorageStrategy()
    {
        testStorage(new Shortener(new FileStorageStrategy()));
    }
    @Test
    public void testHashBiMapStorageStrategy()
    {
        testStorage(new Shortener(new HashBiMapStorageStrategy()));
    }
    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
    }
    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
    }

    public void testStorage(Shortener shortener)
    {
        String one = Helper.generateRandomString();
        String two = Helper.generateRandomString();
        String three = one;

        Long keyOne = shortener.getId(one);
        Long keyTwo = shortener.getId(two);
        Long keyThree = shortener.getId(three);

        Assert.assertNotEquals(keyOne, keyTwo);
        Assert.assertNotEquals(keyThree, keyTwo);

        Assert.assertEquals(keyOne, keyThree);

        String one2 = shortener.getString(keyOne);
        String two2 = shortener.getString(keyTwo);
        String three2 = shortener.getString(keyThree);

        Assert.assertEquals(one, one2);
        Assert.assertEquals(two, two2);
        Assert.assertEquals(three, three2);
    }
}
