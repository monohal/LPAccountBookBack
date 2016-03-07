package com.example.hal.lpaccountbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.StackView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HAL on 2016/02/13.
 */
public class InputStringData extends AppCompatActivity implements InputState {

    private static InputStringData singleton = new InputStringData();
    private static final String NOW_STATE = "STRING";



    private static final String HL = "hl_button";
    private static final String HR = "hr_button";
    private static final String LL = "ll_button";
    private static final String LR = "lr_button";


    DBManager dbm ;

    String S_DATA;
    int M_DATA;

    SharedPreferences.Editor editor;

    private InputStringData(){
    }

    public static InputState getInstance(){
        return singleton;
    }

    public void Init(Context context,ViewGroup vg){
        SharedPreferences data = context.getSharedPreferences(STRING_FILE_NAME, MODE_PRIVATE);
        SharedPreferences mdata = context.getSharedPreferences(MONEY_FILE_NAME, MODE_PRIVATE);

        editor = data.edit();
        M_DATA = mdata.getInt("M_DATA", 0);

        dbm = new DBManager(context);

        StringDataSet(data, vg);
    }

    public void InputData(View view){
        switch(view.getId()){
            case R.id.button_HL:
                S_DATA = data_hl;
                break;

            case R.id.button_HR:
                S_DATA = data_hr;
                break;

            case R.id.button_LL:
                S_DATA = data_ll;
                break;

            case R.id.button_LR:
                S_DATA = data_lr;
                break;
        }

        editor.putString("S_DATA", S_DATA);
        editor.apply();

        InputDataSave();
        Output(view);
    }

    public InputState ChangeState(Context context){
        return InputMoneyData.getInstance();
    }

    public String NowState(){
        return NOW_STATE;
    }

    public void InputDataSave(){
        Date nowdate = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DataStruct ds = new DataStruct(M_DATA, S_DATA, sdf.format(nowdate));

        dbm.dbSave(ds);
    }

    public void Output(View v){

        String message = S_DATA + "：" + M_DATA + "円で記録します";
        final Snackbar snackbar = Snackbar.make(v, message, Snackbar.LENGTH_LONG);

        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbm.dbUndo();
            }
        });
        snackbar.show();
    }


    public String data_hl;
    public String data_hr;
    public String data_ll;
    public String data_lr;

    public void StringDataSet(SharedPreferences data, ViewGroup vg){

        Button b_hl = (Button)vg.findViewById(R.id.button_HL);
        Button b_hr = (Button)vg.findViewById(R.id.button_HR);
        Button b_ll = (Button)vg.findViewById(R.id.button_LL);
        Button b_lr = (Button)vg.findViewById(R.id.button_LR);

        data_hl = data.getString(HL, "食費");
        data_hr = data.getString(HR, "趣味");
        data_ll = data.getString(LL, "交際費");
        data_lr = data.getString(LR, "その他");

        b_hl.setText(data_hl);
        b_hr.setText(data_hr);
        b_ll.setText(data_ll);
        b_lr.setText(data_lr);
    }
}
