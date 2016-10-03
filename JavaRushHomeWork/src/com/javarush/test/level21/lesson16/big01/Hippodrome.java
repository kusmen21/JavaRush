package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

public class Hippodrome
{
    static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("lol", 3, 0);
        Horse horse2 = new Horse("lul", 3, 0);
        Horse horse3 = new Horse("kek", 3, 0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game.run();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)//100
        {
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        printWinner();
    }

    public void print()
    {
        for (Horse x : horses)
        {
            x.print();
        }
        System.out.println();
        System.out.println();
    }

    public void move()
    {
        for (Horse x : horses)
        {
            x.move();
        }
    }

    public Horse getWinner()
    {
        Horse winner = horses.get(0);
        for (Horse horse : horses){
            if (horse.getDistance()>winner.getDistance())
                winner = horse;
        }
        return winner;
    }

    public void printWinner()
    {
        String name = getWinner().getName();
        System.out.println("Winner is " + name  + "!");
    }
}
