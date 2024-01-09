package com.example.test03.question;

import com.example.test03.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> findAll() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> optionalQuestion = this.questionRepository.findById(id);
        if (optionalQuestion.isEmpty()) {
            return null;
        }
        return optionalQuestion.get();
    }

    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    public void create(String title, String content, SiteUser author) {
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        question.setAuthor(author);
        this.questionRepository.save(question);
    }

    public void modify(Question question, String title, String content) {
        question.setTitle(title);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
