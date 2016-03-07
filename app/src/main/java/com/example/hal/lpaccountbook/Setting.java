package com.example.hal.lpaccountbook;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by HAL on 2016/02/15.
 */
public class Setting extends Activity{

    public static final String MONEY_STATE = "MONEY_DATA";
    public static final String STRING_STATE = "STRING_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);




    }
}
