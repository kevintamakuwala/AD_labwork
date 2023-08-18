package com.example.lab4;

public class Candidate {
    private int vote;
    private String name;

    public Candidate( String name) {
        this.vote = 0;
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void incrementVote(){
        this.vote++;
    }
}
