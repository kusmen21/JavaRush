package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper
{
    /*
2. В классе ConsoleHelper реализуйте логику статического метода Operation askOperation()
Спросить у пользователя операцию.
Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
Используйте метод, описанный в п.1.
Обработай исключение - запроси данные об операции повторно.
     */
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res
            = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        while (true)
        {
            try
            {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            }
            catch (NumberFormatException e){
                writeMessage(res.getString("invalid.data"));
            }
            catch (IllegalArgumentException e1)
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String s = "";
        try {
            s = reader.readLine();
            if (s.toUpperCase().equals(res.getString("operation.EXIT"))) throw new InterruptOperationException();
        }
        catch (IOException e) {}

        return s;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(res.getString("choose.denomination.and.count.format"));
       while (true)
       {
           try
           {
               String text = readString();

               String[] array = text.split(" ");

               int nominal = Integer.parseInt(array[0]);
               int count = Integer.parseInt(array[1]);

               if (nominal >= 0 && count >= 0 && array.length == 2) return array;
               else writeMessage(res.getString("invalid.data"));
           }
           catch (NumberFormatException e){
               writeMessage(res.getString("invalid.data"));
           }
           catch (IllegalArgumentException e1) {
               writeMessage(res.getString("invalid.data"));
           }
       }
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        while(true)
        {
            String text = readString();
            if (text.matches("[a-zA-Z]{3}"))
            {
                return text.toUpperCase();
            } writeMessage(res.getString("invalid.data"));
        }
    }
}
