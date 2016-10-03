package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CurrencyManipulator
{
    /*
4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
который добавит введенные номинал и количество банкнот
     */
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else{
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount()
    {
        int summa = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            summa += (pair.getKey() * pair.getValue());
        }
        return summa;
    }

    public boolean hasMoney()
    {
        return getTotalAmount() > 0;
    }

    /*
Не забудьте, что в некоторых случаях картой кидается ConcurrentModificationException.
     */
    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> rezult = new LinkedHashMap<>();

        boolean isCansel = false;
        int overNominal = 0;
        int trueSumma = 0;
        try
        {
            while (!isCansel)
            {
                int maxNominal = 0;
                for (Map.Entry<Integer, Integer> pair : denominations.entrySet())   //uznaem maks banknotu, no menshe nenuzhnoi
                {
                    if (overNominal == 0)
                    {
                        if (pair.getKey() > maxNominal)
                            maxNominal = pair.getKey();
                    } else
                    {
                        if (pair.getKey() > maxNominal && pair.getKey() < overNominal)
                            maxNominal = pair.getKey();
                    }
                }

                if (maxNominal == 0) throw new NotEnoughMoneyException();

                while (true)    //proveryaem podhodit li banknota i uznaem ih kolichestvo
                {
                    if (expectedAmount < (maxNominal + trueSumma))    //esli banknota ne podhodit
                    {
                        overNominal = maxNominal;
                        break;
                    } else    //nuznoe menshe chem max banknota
                    {
                        for (int i = 0; i < denominations.get(maxNominal); i++)
                        {
                            trueSumma += maxNominal;
                            if (expectedAmount == trueSumma)    //nashli vse banknotu
                            {
                                rezult.put(maxNominal, i + 1);
                                isCansel = true;
                                break;
                            } else                               // esli perebor
                                if (expectedAmount < trueSumma)
                                {
                                    rezult.put(maxNominal, i);
                                    trueSumma -= maxNominal;
                                    overNominal = maxNominal;
                                    break;
                                } else if (i == denominations.get(maxNominal) - 1)
                                {
                                    rezult.put(maxNominal, denominations.get(maxNominal));
                                    overNominal = maxNominal;
                                }
                        }
                        break;
                    }
                }
            }

            for (Map.Entry<Integer, Integer> pair : rezult.entrySet())  //chistka banka
            {
                if (pair.getValue().equals(denominations.get(pair.getKey())))
                {
                    denominations.remove(pair.getKey());
                } else
                {
                    int oldValue = denominations.get(pair.getKey());
                    denominations.remove(pair.getKey());
                    denominations.put(pair.getKey(), oldValue - pair.getValue());
                }
            }
            //System.out.println(denominations);//////////////////
        }catch (ConcurrentModificationException e){}
        return rezult;
    }

}
