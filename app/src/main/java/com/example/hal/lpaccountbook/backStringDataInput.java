/*package com.example.hal.lpaccountbook;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class backStringDataInput extends AccountBook{

    public static final String STRING_FILE_NAME = "STRING_DATA";

    public String M_DATA;
    public String S_DATA;

    public String data_hl;
    public String data_hr;
    public String data_ll;
    public String data_lr;


    DBManager dbm;

    public void onClick(View v) {
        switch (v.getId()) {
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
        Log.d("OUTPUT", "M" + M_DATA);
        Log.d("OUTPUT", "S" + S_DATA);

        dbm = new DBManager(this);

        Date nowdate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DataStruct ds = new DataStruct(M_DATA, S_DATA, sdf.format(nowdate));

        dbm.dbSave(ds);
        Intent intent = new Intent();
        intent.putExtra("M_DATA", M_DATA);
        intent.putExtra("S_DATA", S_DATA);

    }


}
*/