package com.sturc.Generics;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        FootballPlayer max = new FootballPlayer("max");
        BaseballPlayer pat = new BaseballPlayer("Pat");

        Team<FootballPlayer> mu = new Team<>("Manchester United");
        mu.addPlayer(joe);

        System.out.println(mu.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Baseball Team");
        baseballTeam.addPlayer(pat);


        Team<FootballPlayer> chelsea = new Team<>("Chelsea");
        chelsea.addPlayer(max);

        League<Team<FootballPlayer>> epl = new League<>("EPL");
        epl.addTeam(mu);
        epl.addTeam(chelsea);
        mu.matchResult(chelsea, 2,1);
        mu.matchResult(chelsea, 3,2);
        mu.matchResult(chelsea, 0,0);
        epl.showLeagueStanding();
    }
}
