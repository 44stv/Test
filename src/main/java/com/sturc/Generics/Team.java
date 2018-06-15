package com.sturc.Generics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team.");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;

        if (ourScore > theirScore){
            won++;

            message = " beat ";
        } else if (ourScore == theirScore){
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;

        if (opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    @Override
    public int compareTo(Team<T> opponent) {
        if (this.ranking() > opponent.ranking()){
            return -1;
        } else if (this.ranking() == opponent.ranking()){
            return 0;
        } else {
            return 1;
        }
        //return Integer.compare(opponent.ranking(), this.ranking());
    }

    public int ranking(){
        return (won * 2) + tied - lost;
    }

}
