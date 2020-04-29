package com.alialfayed.quizapp.mainActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alialfayed.quizapp.R;
import com.alialfayed.quizapp.mainActivity.util.SaveSharedPreferences;
import com.alialfayed.quizapp.model.QuestionModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.alialfayed.quizapp.mainActivity.util.SaveSharedPreferences.counterCorrect;
import static com.alialfayed.quizapp.mainActivity.util.SaveSharedPreferences.counterWrong;
import static com.alialfayed.quizapp.mainActivity.view.MainActivity.answerQuestions;


/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 4/28/2020 - 9:58 PM
 */
public class QuestionsEditAdapter extends RecyclerView.Adapter<QuestionsEditAdapter.QuestionsEditViewHolder> {

    private Context context;
    private ArrayList<QuestionModel> myObjectList;

    public QuestionsEditAdapter(Context context, ArrayList<QuestionModel> myObjectList) {
        this.context = context;
        this.myObjectList = myObjectList;
    }

    @NonNull
    @Override
    public QuestionsEditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question_edit, parent, false);
        return new QuestionsEditViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionsEditViewHolder holder, final int position) {

        holder.txtTitle.setText(myObjectList.get(position).getTitleQuestion());
        holder.imgDescription.setImageResource(myObjectList.get(position).getImgQuestion());

        switch (position) {
            case 0:
            case 1:
            case 2:
                holder.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String answer = holder.eTxt.getText().toString();

                        if (!answer.isEmpty()) {
                            if (answer.equals(myObjectList.get(position).getRightAnswerString()[0])) {
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                            holder.btn.setEnabled(false);
                            holder.eTxt.setEnabled(false);
                            answerQuestions++;

                        } else {
                            holder.eTxt.setError(context.getString(R.string.msg_answer_required));
                            holder.eTxt.requestFocus();
                        }
                    }
                });

        }
    }

    @Override
    public int getItemCount() {
        return myObjectList != null ? myObjectList.size() : 0;
    }

    static class QuestionsEditViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgDescription;
        EditText eTxt;
        Button btn;

        QuestionsEditViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.txtTitle_ItemQuestionEdit);
            this.imgDescription = itemView.findViewById(R.id.img_ItemQuestionEdit);
            this.eTxt = itemView.findViewById(R.id.eTxt_ItemQuestionEdit);
            this.btn = itemView.findViewById(R.id.btn_ItemQuestionEdit);
        }
    }
}
