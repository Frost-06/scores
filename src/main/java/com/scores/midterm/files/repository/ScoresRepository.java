package com.scores.midterm.files.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import model.Scores;

public interface ScoresRepository extends MongoRepository<Scores,String>{
    @Query("{'average':?0}")
    Optional<Scores> findByName(String average);
}
