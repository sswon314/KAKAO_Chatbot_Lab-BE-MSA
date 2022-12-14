package com.example.surmoonveysurvey.repositories;

import com.example.surmoonveysurvey.models.ChoiceAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChoiceAnswerRepository extends JpaRepository<ChoiceAnswer, Long> {

    @Query(value = "select * from choice_answer where question_id=:id", nativeQuery = true)
    List<ChoiceAnswer> findAnswerList(@Param("id") Long id);
}
