package com.example.test03.question;

import com.example.test03.answer.Answer;
import com.example.test03.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @CreatedDate
    private LocalDateTime createDate;
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    @ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;
}
