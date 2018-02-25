package com.sturc.Generics;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        FootballPlayer max = new FootballPlayer("max");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        AmericanFootballPlayer tim = new AmericanFootballPlayer("Tim");

        Team<FootballPlayer> mu = new Team<>("Manchester United");
        mu.addPlayer(joe);

        System.out.println(mu.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Baseball Team");
        baseballTeam.addPlayer(pat);

        Team<AmericanFootballPlayer> americanFootballTeam =
                new Team<>("American football team");
        americanFootballTeam.addPlayer(tim);

        Team<FootballPlayer> chelsea = new Team<>("Chelsea");
        chelsea.addPlayer(max);

        mu.matchResult(chelsea, 2,1);
        System.out.println(mu.ranking());
        System.out.println(chelsea.ranking());

    }
}
