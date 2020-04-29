package com.alialfayed.quizapp.mainActivity.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alialfayed.quizapp.R;
import com.alialfayed.quizapp.mainActivity.Adapter.QuestionsCheckAdapter;
import com.alialfayed.quizapp.mainActivity.Adapter.QuestionsEditAdapter;
import com.alialfayed.quizapp.mainActivity.Adapter.QuestionsRadioAdapter;
import com.alialfayed.quizapp.mainActivity.util.AddQuestions;
import com.alialfayed.quizapp.mainActivity.util.SaveSharedPreferences;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.alialfayed.quizapp.mainActivity.util.SaveSharedPreferences.answerQuestions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private RecyclerView recyclerViewCheck;
    private RecyclerView recyclerViewRadio;
    private RecyclerView recyclerViewEdit;

    private RelativeLayout rtlFirstScreen;
    private RelativeLayout rtlSecondScreen;
    private RelativeLayout rtlThirdScreen;

    private TextInputLayout textInputLayout_NameUser;


    private TextView txtCorrectAnswer;
    private TextView txtWongAnswer;
    private TextView txtStatusGame;
    private TextView txtMessage;
    private TextView txtUserName;

    private String nameUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize Variables
        controlButton();

        inflateToolbar();
        inflateRecyclerViewCheck();
        inflateRecyclerViewRadio();
        inflateRecyclerViewEdit();


    }

    private void controlButton() {
        //initialize  Toolbar
        toolbar = findViewById(R.id.toolbar);

        //initialize  Buttons
        Button btn_Next = findViewById(R.id.btn_Next);
        Button btn_Score = findViewById(R.id.btn_Score);
        Button btn_TryAgain = findViewById(R.id.btn_TryAgain);

        //initialize  RecyclerView
        recyclerViewEdit = findViewById(R.id.recyclerViewEdit);
        recyclerViewRadio = findViewById(R.id.recyclerViewRadio);
        recyclerViewCheck = findViewById(R.id.recyclerViewCheck);

        //initialize  RelativeLayout
        rtlFirstScreen = findViewById(R.id.rtlFirstScreen);
        rtlSecondScreen = findViewById(R.id.rtlSecondScreen);
        rtlThirdScreen = findViewById(R.id.rtlThirdScreen);

        //initialize  TextInputLayout
        textInputLayout_NameUser = findViewById(R.id.textInputLayout_NameUser);

        //initialize  TextView
        txtCorrectAnswer = findViewById(R.id.txtCorrectAnswer);
        txtWongAnswer = findViewById(R.id.txtWongAnswer);
        txtStatusGame = findViewById(R.id.txtStatusGame);
        txtMessage = findViewById(R.id.txtMessage);
        txtUserName = findViewById(R.id.txtUserName);

        // onClick Buttons
        btn_Next.setOnClickListener(this);
        btn_Score.setOnClickListener(this);
        btn_TryAgain.setOnClickListener(this);

    }

    private void inflateRecyclerViewEdit() {

        QuestionsEditAdapter editAdapter = new QuestionsEditAdapter(this, AddQuestions.addQuestionEdit(this));

        recyclerViewEdit.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEdit.setAdapter(editAdapter);

        editAdapter.notifyDataSetChanged();
    }

    private void inflateRecyclerViewRadio() {

        QuestionsRadioAdapter radioAdapter = new QuestionsRadioAdapter(this, AddQuestions.addQuestionRadio(this));

        recyclerViewRadio.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRadio.setAdapter(radioAdapter);

        radioAdapter.notifyDataSetChanged();


    }

    private void inflateRecyclerViewCheck() {

        QuestionsCheckAdapter checkAdapter = new QuestionsCheckAdapter(this, AddQuestions.addQuestionCheck(this));
        recyclerViewCheck.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCheck.setAdapter(checkAdapter);

        checkAdapter.notifyDataSetChanged();

    }

    // inflate Toolbar
    private void inflateToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Next:
                nameUser = textInputLayout_NameUser.getEditText().getText().toString();

                if (!nameUser.isEmpty()) {
                    rtlFirstScreen.setVisibility(View.GONE);
                    rtlSecondScreen.setVisibility(View.VISIBLE);
                } else {
                    textInputLayout_NameUser.setErrorEnabled(false);
                    textInputLayout_NameUser.setError(getText(R.string.msg_answer_required));
                }

                SaveSharedPreferences.saveCounterCorrect(0, this);
                SaveSharedPreferences.saveCounterWrong(0, this);
                break;

            case R.id.btn_Score:
                if (answerQuestions == 3) {

                    int correctAnswer = SaveSharedPreferences.getCounterCorrect(this);
                    int wrongAnswer = SaveSharedPreferences.getCounterWrong(this);

                    txtCorrectAnswer.setText(String.valueOf(correctAnswer));
                    txtWongAnswer.setText(String.valueOf(correctAnswer));
                    txtUserName.setText(nameUser);

                    if (correctAnswer > wrongAnswer) {
                        txtStatusGame.setText(getText(R.string.game_status_win));
                        txtMessage.setText(getText(R.string.msg_win));
                        setResult(getText(R.string.msg_win).toString(), nameUser, getText(R.string.game_status_win).toString());
                    } else {
                        txtStatusGame.setText(getText(R.string.game_status_lose));
                        txtMessage.setText(getText(R.string.msg_lose));
                        setResult(getText(R.string.msg_lose).toString(), nameUser, getText(R.string.game_status_lose).toString());
                    }

                    rtlSecondScreen.setVisibility(View.GONE);
                    rtlThirdScreen.setVisibility(View.VISIBLE);

                } else {
                    Toast.makeText(this, getText(R.string.msg_answer_all), Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_TryAgain:

                rtlThirdScreen.setVisibility(View.GONE);
                rtlSecondScreen.setVisibility(View.VISIBLE);

                SaveSharedPreferences.saveCounterCorrect(0, this);
                SaveSharedPreferences.saveCounterWrong(0, this);
                break;

        }

    }

    private void setResult(String massage, String nameUSer, String statusGame) {
        Toast.makeText(this, massage + " " + nameUSer + "\n" + statusGame, Toast.LENGTH_LONG).show();
    }

}
