package com.javarush.test.level26.lesson15.big01;


public enum Operation
{
    /*
    Чтобы отрефакторить код в соответствии с паттерном Command, нужно выделить в коде несколько логических блоков кода.
У нас пока два таких блока: 1) код операции DEPOSIT, 2) код операции INFO.
Они захардкожены в методе main. Нужно от этого избавиться.
Нужно сделать так, чтобы пользователь сам выбирал, какую операцию на данный момент нужно выполнять.

1. В энум Operation добавьте статический метод Operation getAllowableOperationByOrdinal(Integer i)
Должен возвращать элемент энума: для 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
На некорректные данные бросать IllegalArgumentException
     */
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        switch (i)
        {
            case 0: throw new IllegalArgumentException();
            //case 0: return LOGIN;

            case 1:
                return INFO;

            case 2:
                return DEPOSIT;

            case 3:
                return WITHDRAW;

            case 4:
                return EXIT;
        }
        throw new IllegalArgumentException();
    }
}
