package com.hacktx.vrfitness;

/**
 * Created by TR on 10/19/2014.
 */
public class Score implements Comparable<Score> {

    public String score;
    public String username;

    public Score(String score, String username)
    {
        this.score = score;
        this.username = username;
    }

    public int compareTo(Score anotherInstance) {
        return  Integer.parseInt(anotherInstance.score) - Integer.parseInt(this.score);
    }
}
