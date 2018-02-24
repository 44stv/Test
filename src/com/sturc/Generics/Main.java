package com.sturc.Generics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        AmericanFootballPlayer tim = new AmericanFootballPlayer("Tim");

        Team<FootballPlayer> mu = new Team<>("MU");
        mu.addPlayer(joe);
//        mu.addPlayer(pat);
//        mu.addPlayer(tim);

        System.out.println(mu.numPlayers());
    }
}
