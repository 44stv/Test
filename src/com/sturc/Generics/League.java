package com.sturc.Generics;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean addTeam(T team){
        if (league.contains(team)){
            return false;
        }
        league.add(team);
        return true;
    }

    public void showLeagueStanding(){
        Collections.sort(league);
        System.out.println("EPL standings: ");
        for (T team : league){
            System.out.println(team.getName() + ": " + team.ranking());
        }
    }
}
