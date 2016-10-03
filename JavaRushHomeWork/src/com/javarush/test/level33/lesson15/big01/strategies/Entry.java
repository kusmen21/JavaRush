package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;
import java.util.Objects;


public class Entry implements Serializable
        /**
         * 7.2.	Если ты честно выполнил предыдущий пункт, то ты знаешь для чего используется
         класс Entry внутри HashMap. Создай свой аналог класса Entry внутри пакета
         strategies. Это должен быть обычный, не вложенный, не generic класс. Сделай его публичным.
         В отличии от класса Entry  из HashMap, наш класс будет поддерживать только
         интерфейс Serializable.
         7.3.	Добавь в Entry следующие поля: Long key, String value, Entry next, int hash. Как
         видишь, наша реализация будет поддерживать только тип Long для ключа и только
         String для значения. Область видимости полей оставь по умолчанию.
         7.4.	Добавь и реализуй конструктор Entry(int hash, Long key, String value, Entry next).
         7.5.	Добавь и реализуй методы: Long getKey(), String getValue(), int hashCode() и String
         toString(). Реализовывать остальные методы оригинального Entry не нужно, мы
         пишем упрощенную версию.
         */

{
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next)
    {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

    public Long getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public int hashCode()
    {
        return hash ^ Objects.hashCode(value);
    }

    @Override
    public String toString()
    {
        return key + "=" + value;
    }
}