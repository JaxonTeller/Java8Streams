package com.functionalProgramming.LambdasAsImplementationofFI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Player
{
    private int ranking;

    public Player(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ranking=" + ranking +
                '}';
    }
}
public class ConsumerExample {

    public static void main(String[] args) {

        List<Player> playerList=new ArrayList<>();
        playerList.add(new Player(2));
        playerList.add(new Player(4));
        playerList.add(new Player(6));
        playerList.add(new Player(8));

        /*For each Player we want to show the ranking*/
        Consumer<Player> consumer=(Player p)-> System.out.println(p);
        showingConsumerFI(playerList,consumer);

        /*For each Player we want to show the ranking and then add 2 to their rankings*/
        showingConsumerFI(playerList,consumer.andThen((Player p)-> System.out.println(p.getRanking()+2)));
    }

    /*As this method accepts consumer FI which takes an arg of type T and returns void, we can pass lambda here*/
    public static void showingConsumerFI(List<Player> players,Consumer<Player> consumer)
    {
        for (Player player :
                players) {
            consumer.accept(player);
        }
    }
}
