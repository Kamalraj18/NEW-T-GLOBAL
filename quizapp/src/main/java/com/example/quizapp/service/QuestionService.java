package com.example.quizapp.service;

import com.example.quizapp.Dao.QuestionDao;
import com.example.quizapp.entity.Question;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;


    public List<Question> getAllquestion() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findBycategory(category);
    }

    public ResponseEntity<String> addQuestions(Question question) {
            questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public void deleteQuestion(int id) {
        questionDao.deleteById(id);
    }
}
