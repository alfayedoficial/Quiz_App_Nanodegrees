package com.alialfayed.quizapp.mainActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
 * Date 4/28/2020 - 7:29 PM
 */
public class QuestionsCheckAdapter extends RecyclerView.Adapter<QuestionsCheckAdapter.QuestionsViewHolder> {

    private Context context;
    private ArrayList<QuestionModel> myObjectList;


    private Boolean statusBox2 = false;
    private Boolean statusBox3 = false;

    public QuestionsCheckAdapter(Context context, ArrayList<QuestionModel> myObjectList) {
        this.context = context;
        this.myObjectList = myObjectList;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question_check, parent, false);
        return new QuestionsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final QuestionsViewHolder holder, final int position) {

        holder.txtTitle.setText(myObjectList.get(position).getTitleQuestion());
        holder.imgDescription.setImageResource(myObjectList.get(position).getImgQuestion());
        holder.cBox_1.setText(myObjectList.get(position).getAnswerOne());
        holder.cBox_2.setText(myObjectList.get(position).getAnswerTwo());
        holder.cBox_3.setText(myObjectList.get(position).getAnswerThree());

        switch (position) {
            case 0:
            case 1:
                holder.cBox_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            holder.cBox_2.setChecked(false);
                            holder.cBox_3.setChecked(false);
                        }
                        if (holder.cBox_1.isChecked()) {
                            if (holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        } else {
                            if (holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect--;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong--;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }

                        }
                    }
                });
                holder.cBox_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            holder.cBox_1.setChecked(false);
                            holder.cBox_3.setChecked(false);
                        }
                        if (holder.cBox_2.isChecked()) {
                            if (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        } else {
                            if (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                counterCorrect--;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong--;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        }
                    }
                });
                holder.cBox_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            holder.cBox_1.setChecked(false);
                            holder.cBox_2.setChecked(false);
                        }
                        if (holder.cBox_3.isChecked()) {
                            if (holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
                                Toast.makeText(context, holder.cBox_3.getText().toString(), Toast.LENGTH_LONG).show();
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        } else {
                            if (holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[0]) {
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
            case 2:
                holder.cBox_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                        if (holder.cBox_2.isChecked() && holder.cBox_3.isChecked()) {
                            if (b) {
                                holder.cBox_3.setChecked(false);
                                holder.cBox_2.setChecked(false);
                            }
                        }
                        if (holder.cBox_1.isChecked() && (holder.cBox_2.isChecked() || holder.cBox_3.isChecked())) {
                            if ((holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[1])
                                    && (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1])
                                    && (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1])
                            ) {
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        } else if (holder.cBox_1.isChecked() && (!holder.cBox_2.isChecked() || !holder.cBox_3.isChecked())) {
                            if ((holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[1])
                                    && (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1])
                                    && (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1])
                            ) {
                                counterCorrect++;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong++;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        } else if (!holder.cBox_1.isChecked() && (holder.cBox_2.isChecked() || holder.cBox_3.isChecked())) {
                            if ((holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[1])
                                    && (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1])
                                    && (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1])
                            ) {
                                counterCorrect--;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong--;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        } else if (!holder.cBox_1.isChecked() && (!holder.cBox_2.isChecked() || !holder.cBox_3.isChecked())) {
                            if ((holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_1.getText() == myObjectList.get(position).getRightAnswerString()[1])
                                    && (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1])
                                    && (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1])
                            ) {
                                counterCorrect--;
                                SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                            } else {
                                counterWrong--;
                                SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                            }
                        }
                    }
                });
                holder.cBox_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (holder.cBox_1.isChecked() && holder.cBox_3.isChecked()) {
                            if (b) {
                                holder.cBox_1.setChecked(false);
                                holder.cBox_3.setChecked(false);
                            }
                        }

                        if (holder.cBox_2.isChecked()) {
                            if (holder.cBox_2.getText() != myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_2.getText() != myObjectList.get(position).getRightAnswerString()[1]) {
                                if (holder.cBox_3.isChecked()) {
                                    counterCorrect++;
                                    SaveSharedPreferences.saveCounterWrong(counterCorrect, context);
                                    if (statusBox2) {
                                        counterWrong--;
                                        SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                                        statusBox2 = false;
                                    }
                                }
                            }
                        } else {
                            if (holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_2.getText() == myObjectList.get(position).getRightAnswerString()[1]) {
                                if (holder.cBox_3.isChecked()) {
                                    counterCorrect--;
                                    SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                                    if (!statusBox2) {
                                        counterWrong++;
                                        SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                                        statusBox2 = true;
                                    }
                                }
                            }
                        }
                    }
                });
                holder.cBox_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (holder.cBox_1.isChecked() && holder.cBox_2.isChecked()) {
                            if (b) {
                                holder.cBox_1.setChecked(false);
                                holder.cBox_2.setChecked(false);
                            }
                        }
                        if (holder.cBox_3.isChecked()) {
                            if (holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1]) {
                                if (holder.cBox_2.isChecked()) {
                                    counterCorrect++;
                                    SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                                    if (statusBox3) {
                                        counterWrong--;
                                        SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                                        statusBox3 = false;
                                    }
                                }
                            }
                        } else {
                            if (holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[0] ||
                                    holder.cBox_3.getText() == myObjectList.get(position).getRightAnswerString()[1]) {
                                if (holder.cBox_2.isChecked()) {
                                    counterCorrect--;
                                    SaveSharedPreferences.saveCounterCorrect(counterCorrect, context);
                                    if (!statusBox3) {
                                        counterWrong++;
                                        SaveSharedPreferences.saveCounterWrong(counterWrong, context);
                                        statusBox3 = true;
                                    }
                                }
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

    static class QuestionsViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        ImageView imgDescription;
        CheckBox cBox_1;
        CheckBox cBox_2;
        CheckBox cBox_3;

        QuestionsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.txtTitle_ItemQuestionCheck);
            this.imgDescription = itemView.findViewById(R.id.img_ItemQuestionCheck);
            this.cBox_1 = itemView.findViewById(R.id.cBox_1_ItemQuestionCheck);
            this.cBox_2 = itemView.findViewById(R.id.cBox_2_ItemQuestionCheck);
            this.cBox_3 = itemView.findViewById(R.id.cBox_3_ItemQuestionCheck);
        }
    }


}
