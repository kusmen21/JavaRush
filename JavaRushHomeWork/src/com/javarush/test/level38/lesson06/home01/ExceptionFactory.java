package com.javarush.test.level38.lesson06.home01;

public class ExceptionFactory
{
    public static Throwable getException(Enum enumeration)
    {
        if (enumeration == null)
            return new IllegalArgumentException();
        String[] words = enumeration.name().toLowerCase().split("_");
        StringBuilder sb = new StringBuilder();
        for (String word : words)
        {
            word = String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
            sb.append(word).append(" ");
        }
        String message = sb.toString().trim();

        switch (enumeration.getClass().getSimpleName())
        {
            case "ExceptionUserMessage":
                return new Error(message);
            case "ExceptionDBMessage":
                return new RuntimeException(message);
            case "ExceptionApplicationMessage":
                return new Exception(message);
            default:
                return new IllegalArgumentException();
        }
    }
}
