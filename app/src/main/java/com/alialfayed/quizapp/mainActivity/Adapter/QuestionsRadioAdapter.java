package com.alialfayed.quizapp.mainActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alialfayed.quizapp.R;
import com.alialfayed.quizapp.mainActivity.util.SaveSharedPreferences;
import com.alialfayed.quizapp.model.QuestionModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.alialfayed.quizapp.mainActivity.util.SaveSharedPreferences.counterCorrect;
import static com.alialfayed.quizapp.mainActivity.util.SaveSharedPreferences.counterWrong;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 4/28/2020 - 9:36 PM
 */
public class QuestionsRadioAdapter extends RecyclerView.Adapter<QuestionsRadioAdapter.QuestionRadioViewHolder> {

    private Context context;
    private ArrayList<QuestionModel> myObjectList;

    public QuestionsRadioAdapter(Context context, ArrayList<QuestionModel> myObjectList) {
        this.context = context;
        this.myObjectList = myObjectList;
    }

    @NonNull
    @Override
    public QuestionRadioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question_radio, parent, false);
        return new QuestionRadioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionRadioViewHolder holder, final int position) {
        holder.txtTitle.setText(myObjectList.get(position).getTitleQuestion());
        holder.imgDescription.setImageResource(myObjectList.get(position).getImgQuestion());
        holder.rBtn_1.setText(myObjectList.get(position).getAnswerOne());
        holder.rBtn_2.setText(myObjectList.get(position).getAnswerTwo());
        holder.rBtn_3.setText(myObjectList.get(position).getAnswerThree());

        switch (position) {
            case 0:
            case 2:
            case 1:
                holder.rBtn_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                        if (b) {
                            holder.rBtn_2.setChecked(false);
                            holder.rBtn_3.setChecked(false);
                        }

                        if (holder.rBtn_1.isChecked()) {
                            if (holder.rBtn_1.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        } else {
                            if (holder.rBtn_1.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect--;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong--;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        }
                    }
                });

                holder.rBtn_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                        if (b) {
                            holder.rBtn_1.setChecked(false);
                            holder.rBtn_3.setChecked(false);
                        }

                        if (holder.rBtn_2.isChecked()) {

                            if (holder.rBtn_2.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }

                        } else {

                            if (holder.rBtn_2.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect--;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong--;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }

                        }
                    }
                });

                holder.rBtn_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                        if (b) {
                            holder.rBtn_1.setChecked(false);
                            holder.rBtn_2.setChecked(false);
                        }

                        if (holder.rBtn_3.isChecked()) {

                            if (holder.rBtn_3.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }

                        } else {

                            if (holder.rBtn_3.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect--;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong--;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }

                        }
                    }
                });
                break;

        }
    }

    @Override
    public int getItemCount() {
        return myObjectList != null ? myObjectList.size() : 0;
    }

    static class QuestionRadioViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        ImageView imgDescription;
        RadioButton rBtn_1;
        RadioButton rBtn_2;
        RadioButton rBtn_3;
        RadioGroup rG;

        QuestionRadioViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.txtTitle_ItemQuestionRadio);
            this.imgDescription = itemView.findViewById(R.id.img_ItemQuestionRadio);
            this.rBtn_1 = itemView.findViewById(R.id.rBtn_1_ItemQuestionRadio);
            this.rBtn_2 = itemView.findViewById(R.id.rBtn_2_ItemQuestionRadio);
            this.rBtn_3 = itemView.findViewById(R.id.rBtn_3_ItemQuestionRadio);
            this.rG = itemView.findViewById(R.id.rG_ItemQuestionRadio);
        }
    }
}
