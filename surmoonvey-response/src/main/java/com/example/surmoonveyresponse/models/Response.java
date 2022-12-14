package com.example.surmoonveyresponse.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "response")
@NoArgsConstructor
public class Response {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // SQL에서 auto_increment 의미
    @Column(name = "response_id", nullable = false)
    private Long responseId;

    @ManyToOne(targetEntity = Survey.class)
    @JoinColumn(name = "survey_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Survey surveyId;

    @Column(name = "response_time")
    private LocalDateTime responseTime;

    public Response(Long responseId){
        this.responseId=responseId;
    }

    @Builder
    public Response(Survey surveyId, LocalDateTime responseTime) {
        this.surveyId = surveyId;
        this.responseTime = responseTime;
    }
}
