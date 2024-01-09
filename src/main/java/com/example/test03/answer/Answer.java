package com.example.test03.answer;

import com.example.test03.question.Question;
import com.example.test03.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @CreatedDate
    private LocalDateTime createDate;
    @ManyToOne
    private Question question;
    @ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;
}
