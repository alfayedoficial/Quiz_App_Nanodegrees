package com.alialfayed.quizapp.mainActivity.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 4/29/2020 - 4:28 AM
 */
public class SaveSharedPreferences {

    public static int counterCorrect = 0;
    public static int counterWrong = 0;


    private static String COUNTER_Correct = "COUNTER_Correct";
    private static String COUNTER_WRONG = "COUNTER_WRONG";
    private static String NAME_USER = "NAME_USER";
    private static String FIRST_ONE = "FIRST_ONE";


    private static SharedPreferences preferences(Context context) {
        return context.getSharedPreferences("name", 0);
    }

    public static void saveCounterCorrect(int counter, Context context) {
        preferences(context).edit()
                .putInt(COUNTER_Correct, counter)
                .apply();
    }

    public static Integer getCounterCorrect(Context context) {
        return preferences(context).getInt(COUNTER_Correct, 0);
    }

    public static void saveCounterWrong(int counter, Context context) {
        preferences(context).edit()
                .putInt(COUNTER_WRONG, counter)
                .apply();
    }

    public static Integer getCounterWrong(Context context) {
        return preferences(context).getInt(COUNTER_WRONG, 0);
    }

    public static void saveNameUser(String name, Context context) {
        preferences(context).edit()
                .putString(NAME_USER, name)
                .apply();
    }

    public static String getNameUser(Context context) {
        return preferences(context).getString(NAME_USER, "Name");
    }

    public static void saveFirstOnce(Boolean firstOne, Context context) {
        preferences(context).edit()
                .putBoolean(FIRST_ONE,firstOne)
                .apply();
    }

    public static boolean getFirstOnce(Context context) {
        return preferences(context).getBoolean(FIRST_ONE,false);
    }
}
