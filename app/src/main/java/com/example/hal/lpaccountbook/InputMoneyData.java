package com.example.hal.lpaccountbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by HAL on 2016/02/13.
 */
public class InputMoneyData extends AppCompatActivity implements InputState {

    private static InputMoneyData singleton = new InputMoneyData();

    private static final String NOW_STATE = "MONEY";

    public int data_hl;
    public int data_hr;
    public int data_ll;
    public int data_lr;

    int M_DATA = 0;

    SharedPreferences.Editor editor;

    private InputMoneyData(){
    }

    public static InputState getInstance(){
        return singleton;
    }

    public void Init(Context context,ViewGroup vg){
        SharedPreferences data = context.getSharedPreferences(MONEY_FILE_NAME, MODE_PRIVATE);
        editor = data.edit();
        MoneyDataSet(data, vg);
    }

    public void InputData(View v){
        switch(v.getId()){
            case R.id.button_HL:
                M_DATA = data_hl;
                break;

            case R.id.button_HR:
                M_DATA = data_hr;
                break;

            case R.id.button_LL:
                M_DATA = data_ll;
                break;

            case R.id.button_LR:
                M_DATA = data_lr;
                break;
        }
        editor.putInt("M_DATA", M_DATA);
        editor.apply();
    }

    public InputState ChangeState(Context context){
        return InputStringData.getInstance();
    }

    public int getMdata(){
        return M_DATA;
    }
    public String NowState(){
        return NOW_STATE;
    }

    private static final String HL = "hl_button";
    private static final String HR = "hr_button";
    private static final String LL = "ll_button";
    private static final String LR = "lr_button";

    public void MoneyDataSet(SharedPreferences data, ViewGroup vg){
        Button b_hl = (Button)vg.findViewById(R.id.button_HL);
        Button b_hr = (Button)vg.findViewById(R.id.button_HR);
        Button b_ll = (Button)vg.findViewById(R.id.button_LL);
        Button b_lr = (Button)vg.findViewById(R.id.button_LR);

        data_hl = data.getInt(HL, 300);
        data_hr = data.getInt(HR, 500);
        data_ll = data.getInt(LL, 1000);
        data_lr = data.getInt(LR, 3000);

        b_hl.setText(String.valueOf(data_hl));
        b_hr.setText(String.valueOf(data_hr));
        b_ll.setText(String.valueOf(data_ll));
        b_lr.setText(String.valueOf(data_lr));
    }
}
