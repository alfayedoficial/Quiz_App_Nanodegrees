package com.alialfayed.quizapp.model;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Model Of Questions
 * Date 4/28/2020 - 5:39 PM
 */
public class QuestionModel {
    private String titleQuestion;
    private int imgQuestion;
    private String[] rightAnswerString = new String[1];
    private String answerOne;
    private String answerTwo;
    private String answerThree;

    // contractor default
    public QuestionModel(){}

    public String getTitleQuestion() {
        return titleQuestion;
    }

    public void setTitleQuestion(String titleQuestion) {
        this.titleQuestion = titleQuestion;
    }

    public int getImgQuestion() {
        return imgQuestion;
    }

    public void setImgQuestion(int imgQuestion) {
        this.imgQuestion = imgQuestion;
    }

    public String[] getRightAnswerString() {
        return rightAnswerString;
    }

    public void setRightAnswerString(String[] rightAnswerString) {
        this.rightAnswerString = rightAnswerString;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }
}
