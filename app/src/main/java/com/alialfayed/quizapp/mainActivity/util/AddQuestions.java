package com.alialfayed.quizapp.mainActivity.util;

import com.alialfayed.quizapp.R;
import com.alialfayed.quizapp.mainActivity.view.MainActivity;
import com.alialfayed.quizapp.model.QuestionModel;

import java.util.ArrayList;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 4/28/2020 - 5:51 PM
 */
public class AddQuestions {

    public static ArrayList<QuestionModel> addQuestionCheck(MainActivity mainActivity) {
        ArrayList<QuestionModel> questionCheckList = new ArrayList<>();

        QuestionModel questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q1_title));
        questionCheck.setImgQuestion(R.drawable.ic_android_logo);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q1_answer_1)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q1_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q1_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q1_answer_3));
        questionCheckList.add(questionCheck);

        questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q2_title));
        questionCheck.setImgQuestion(R.drawable.ic_android_7);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q2_answer_2)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q2_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q2_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q2_answer_3));
        questionCheckList.add(questionCheck);

        questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q3_title));
        questionCheck.setImgQuestion(R.drawable.ic_google);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q3_answer_2),
                mainActivity.getString(R.string.q3_answer_3)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q3_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q3_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q3_answer_3));
        questionCheckList.add(questionCheck);

        return questionCheckList;


    }

    public static ArrayList<QuestionModel> addQuestionRadio(MainActivity mainActivity) {
        ArrayList<QuestionModel> questionCheckList = new ArrayList<>();

        QuestionModel questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q4_title));
        questionCheck.setImgQuestion(R.drawable.ic_triangle);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q4_answer_1)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q4_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q4_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q4_answer_3));
        questionCheckList.add(questionCheck);

        questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q5_title));
        questionCheck.setImgQuestion(R.drawable.ic_square);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q5_answer_2)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q5_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q5_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q5_answer_3));
        questionCheckList.add(questionCheck);

        questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q6_title));
        questionCheck.setImgQuestion(R.drawable.ic_rectangle);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q6_answer_3)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q6_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q6_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q6_answer_3));
        questionCheckList.add(questionCheck);


        return questionCheckList;
    }

    public static ArrayList<QuestionModel> addQuestionEdit(MainActivity mainActivity) {
        ArrayList<QuestionModel> questionCheckList = new ArrayList<>();

        QuestionModel questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q7_title));
        questionCheck.setImgQuestion(R.drawable.ic_question_1);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q7_answer_1)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q7_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q7_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q7_answer_3));
        questionCheckList.add(questionCheck);

        questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q8_title));
        questionCheck.setImgQuestion(R.drawable.ic_question_2);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q8_answer_1)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q8_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q8_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q8_answer_3));
        questionCheckList.add(questionCheck);

        questionCheck = new QuestionModel();
        questionCheck.setTitleQuestion(mainActivity.getString(R.string.q9_title));
        questionCheck.setImgQuestion(R.drawable.ic_question_3);
        questionCheck.setRightAnswerString(new String[]{mainActivity.getString(R.string.q9_answer_1)});
        questionCheck.setAnswerOne(mainActivity.getString(R.string.q9_answer_1));
        questionCheck.setAnswerTwo(mainActivity.getString(R.string.q9_answer_2));
        questionCheck.setAnswerThree(mainActivity.getString(R.string.q9_answer_3));
        questionCheckList.add(questionCheck);


        return questionCheckList;
    }
}
