package com.javarush.test.level28.lesson15.big01;


import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller
{
/*
В Model есть метод selectCity, в него передается название города, для которого выбираются вакансии.
Очевидно, что этот метод будет вызываться контроллером, т.к. он принимает решение, какую модель использовать.

1. Добавь в Controller новое поле Model model.

2. Удали метод scan() из Controller, его логика переместилась в модель.

3. Удали конструктор, toString и поле providers из контроллера.

4. Создай конструктор в Controller с аргументом Model.
На некорректные данные брось IllegalArgumentException

5. В Controller создай публичный метод void onCitySelect(String cityName), в котором вызови нужный метод модели.

6. Удали код из метода main. Этот код уже не валидный.

 */
    private Model model;

    public Controller(Model model)
    {
        if (model != null)
        {
            this.model = model;
        }else throw new IllegalArgumentException();
    }

    public void onCitySelect(String cityName) throws IOException
    {
        model.selectCity(cityName);
    }

}
