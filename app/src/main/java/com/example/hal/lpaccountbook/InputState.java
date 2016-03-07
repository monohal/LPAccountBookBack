package com.example.hal.lpaccountbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by HAL on 2016/02/13.
 */
public interface InputState {

    String MONEY_FILE_NAME = "MONEY_DATA";
    String STRING_FILE_NAME = "STRING_DATA";

    void Init(Context context,ViewGroup vg);
    void InputData(View v);
    InputState ChangeState(Context context);
    String NowState();
}
