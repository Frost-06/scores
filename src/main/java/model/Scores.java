package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("scores")
public class Scores {
    @Id
    private String scoresID;
    @Field(name="score1")
    private double score1;
    @Field(name="score2")
    private double score2;
    @Field(name="score3")
    private double score3;
    @Field(name="average")
    private String average;
    
    public Scores(String scoresID, double score1, double score2, double score3, String average) {
        double avg= ((score1+score2+score3)/3.0);
        this.scoresID = scoresID;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.average = String.format("%.2f",avg);
    }

    public String getScoresID() {
        return this.scoresID;
    }

    public void setScoresID(String scoresID) {
        this.scoresID = scoresID;
    }
 
    public double getScore1() {
        return this.score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return this.score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public double getScore3() {
        return this.score3;
    }

    public void setScore3(double score3) {
        this.score3 = score3;
    }

    public String getAverage() {
        double avg = ((score1+score2+score3)/3.0);
        average = String.format("%.2f",avg);
        return this.average;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}

    
