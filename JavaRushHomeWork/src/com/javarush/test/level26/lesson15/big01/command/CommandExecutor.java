package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor
{
    private static Map<Operation, Command> commandMap = new HashMap<>();
    static
    {
        commandMap.put(Operation.DEPOSIT, new DepositCommand());
        commandMap.put(Operation.INFO, new InfoCommand());
        commandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        commandMap.put(Operation.EXIT, new ExitCommand());
        commandMap.put(Operation.LOGIN, new LoginCommand());
    }
    /*
    4.1 Создадим метод public static final void execute(Operation operation), который будет дергать метод execute у нужной команды.
Реализуйте эту логику.
4.2. Расставьте правильно модификаторы доступа учитывая, что единственная точка входа - это метод execute.

Проверяем, чтоб структура соответствовала тестам на сервере.
Логику будем переносить в следующем таске.
     */
    public static final void execute(Operation operation) throws InterruptOperationException
    {
        commandMap.get(operation).execute();
    }

    private CommandExecutor(){}
}
