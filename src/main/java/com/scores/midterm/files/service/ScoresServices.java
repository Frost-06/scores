package com.scores.midterm.files.service;

import java.util.List;
import com.scores.midterm.files.repository.ScoresRepository;
import org.springframework.stereotype.Service;
import model.Scores;

@Service
public class ScoresServices {
    private static ScoresRepository scoresrepo;

    public ScoresServices(ScoresRepository scoresrepo) {
        ScoresServices.scoresrepo = scoresrepo;
    }

    public static void addScores(Scores score) {
        scoresrepo.insert(score);
    }

    public static List<Scores> getAllScores() {
        return scoresrepo.findAll();
    }

    public static void updateScores(Scores score) {
        Scores updates_scores = scoresrepo.findById(score.getScoresID())
        .orElseThrow(()-> new RuntimeException
        (String.format("Cannot find ID %s", score.getScoresID())));

        updates_scores.setScore1(score.getScore1());
        updates_scores.setScore2(score.getScore2());
        updates_scores.setScore3(score.getScore3());
        updates_scores.setAverage(score.getAverage());

        scoresrepo.save(score);
    }

    public static Scores searchScores(String  average) {
        return scoresrepo.findByName(average)
        .orElseThrow(()->new RuntimeException
        (String.format("Cannot find value %s",average)));
    }

    public static void deleteScores(String scoreID) {
        scoresrepo.deleteById(scoreID);
    }
}
