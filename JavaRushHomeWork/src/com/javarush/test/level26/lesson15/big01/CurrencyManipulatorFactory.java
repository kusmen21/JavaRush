package com.javarush.test.level26.lesson15.big01;




import java.util.Collection;
import java.util.HashMap;

public class CurrencyManipulatorFactory
{
        /*
    1. Создадим класс CurrencyManipulator, который будет хранить всю информацию про выбранную валюту.
String currencyCode - код валюты, например, USD. Состоит из трех букв
Map<Integer, Integer> denominations - это Map<номинал, количество>
Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode
Очевидно, что манипулятор никак не может функционировать без названия валюты,
поэтому добавим конструктор с этим параметром и проинициализируем currencyCode

2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
Создадим класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
Подумайте, где лучше хранить все манипуляторы.
Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса
     */
    private static HashMap<String, CurrencyManipulator> manipulators = new HashMap<>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if(!manipulators.containsKey(currencyCode))
        {
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        }
        return manipulators.get(currencyCode);
    }

    private CurrencyManipulatorFactory() {}

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return manipulators.values();
    }

}
