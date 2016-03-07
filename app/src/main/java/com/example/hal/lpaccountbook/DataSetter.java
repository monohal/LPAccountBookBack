package com.example.hal.lpaccountbook;

import android.content.SharedPreferences;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by HAL on 2016/02/16.
 */
public class DataSetter {
    private static final String HL = "hl_button";
    private static final String HR = "hr_button";
    private static final String LL = "ll_button";
    private static final String LR = "lr_button";

    /*
    public static void MoneyDataSet(SharedPreferences data, ViewGroup vg){
        int int_data_hl;
        int int_data_hr;
        int int_data_ll;
        int int_data_lr;

        Button b_hl = (Button)vg.findViewById(R.id.button_HL);
        Button b_hr = (Button)vg.findViewById(R.id.button_HR);
        Button b_ll = (Button)vg.findViewById(R.id.button_LL);
        Button b_lr = (Button)vg.findViewById(R.id.button_LR);

        int_data_hl = data.getInt(HL, 300);
        int_data_hr = data.getInt(HR, 500);
        int_data_ll = data.getInt(LL, 1000);
        int_data_lr = data.getInt(LR, 3000);

        b_hl.setText(String.valueOf(int_data_hl));
        b_hr.setText(String.valueOf(int_data_hr));
        b_ll.setText(String.valueOf(int_data_ll));
        b_lr.setText(String.valueOf(int_data_lr));
    }
    */

    public static void StringDataSet(SharedPreferences data, ViewGroup vg){
        String str_data_hl;
        String str_data_hr;
        String str_data_ll;
        String str_data_lr;

        Button b_hl = (Button)vg.findViewById(R.id.button_HL);
        Button b_hr = (Button)vg.findViewById(R.id.button_HR);
        Button b_ll = (Button)vg.findViewById(R.id.button_LL);
        Button b_lr = (Button)vg.findViewById(R.id.button_LR);

        str_data_hl = data.getString(HL, "食費");
        str_data_hr = data.getString(HR, "趣味");
        str_data_ll = data.getString(LL, "交際費");
        str_data_lr = data.getString(LR, "その他");

        b_hl.setText(str_data_hl);
        b_hr.setText(str_data_hr);
        b_ll.setText(str_data_ll);
        b_lr.setText(str_data_lr);
    }


    public static void MoneyTextSet(SharedPreferences data, ViewGroup vg){
        int int_data_hl;
        int int_data_hr;
        int int_data_ll;
        int int_data_lr;

        EditText b_hl = (EditText)vg.findViewById(R.id.int_editText_HL);
        EditText b_hr = (EditText)vg.findViewById(R.id.int_editText_HR);
        EditText b_ll = (EditText)vg.findViewById(R.id.int_editText_LL);
        EditText b_lr = (EditText)vg.findViewById(R.id.int_editText_LR);

        int_data_hl = data.getInt(HL, 300);
        int_data_hr = data.getInt(HR, 500);
        int_data_ll = data.getInt(LL, 1000);
        int_data_lr = data.getInt(LR, 3000);

        b_hl.setText(String.valueOf(int_data_hl));
        b_hr.setText(String.valueOf(int_data_hr));
        b_ll.setText(String.valueOf(int_data_ll));
        b_lr.setText(String.valueOf(int_data_lr));
    }

    public static void StringTextSet(SharedPreferences data, ViewGroup vg){
        String str_data_hl;
        String str_data_hr;
        String str_data_ll;
        String str_data_lr;

        EditText b_hl = (EditText)vg.findViewById(R.id.str_editText_HL);
        EditText b_hr = (EditText)vg.findViewById(R.id.str_editText_HR);
        EditText b_ll = (EditText)vg.findViewById(R.id.str_editText_LL);
        EditText b_lr = (EditText)vg.findViewById(R.id.str_editText_LR);

        str_data_hl = data.getString(HL, "食費");
        str_data_hr = data.getString(HR, "趣味");
        str_data_ll = data.getString(LL, "交際費");
        str_data_lr = data.getString(LR, "その他");

        b_hl.setText(str_data_hl);
        b_hr.setText(str_data_hr);
        b_ll.setText(str_data_ll);
        b_lr.setText(str_data_lr);
    }




}
