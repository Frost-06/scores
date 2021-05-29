package com.scores.midterm.files.controller;

import java.util.List;

import com.scores.midterm.files.service.ScoresServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import model.Scores;

@RestController
@RequestMapping("api/Average")
public class ControllerScores {

    @PostMapping
    public ResponseEntity insertScores(@RequestBody Scores score) {
        ScoresServices.addScores(score);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping
    public ResponseEntity<List<Scores>> getScores() {
        return ResponseEntity.ok(ScoresServices.getAllScores());
    }

    @PutMapping
   public ResponseEntity updateScores(@RequestBody Scores score) {
       ScoresServices.updateScores(score);
       return ResponseEntity.ok().build();
   }

   @GetMapping("/{average}")
   public ResponseEntity<Scores> searchScoreData(@PathVariable String average) {
        return ResponseEntity.ok(ScoresServices.searchScores(average));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity deleteScores(@PathVariable String id) {
        ScoresServices.deleteScores(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
}
