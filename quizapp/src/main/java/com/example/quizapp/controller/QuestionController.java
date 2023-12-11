package com.example.quizapp.controller;

import com.example.quizapp.entity.Question;
import com.example.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allquestions")
    public List<Question> getAllquestions(){
        return questionService.getAllquestion();
    }


    @GetMapping("category/{category}")
    public List<Question> getQuestionsBycategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestions(@RequestBody Question question ){
        questionService.addQuestions(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable int id){
        questionService.deleteQuestion(id);
        return "deleted"+id;
    }
}
