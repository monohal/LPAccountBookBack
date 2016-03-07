package com.example.hal.lpaccountbook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class AccountBook extends AppCompatActivity {
    public static final String MONEY_STATE = "MONEY_DATA";
    public static final String STRING_STATE = "STRING_DATA";
    public static final String FIRST_TIME_CHECK = "FIRST_TIME_CHECK";

    private InputState inputstate = InputMoneyData.getInstance();

    ViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        viewGroup = (ViewGroup)findViewById(R.id.layout);

        FirstTime();

        //Debug(this);
        inputstate.Init(this, viewGroup);
    }

    public void onClick(View v) {
        inputstate.InputData(v);
        inputstate = inputstate.ChangeState(this);
        inputstate.Init(this, viewGroup);
    }



    /**
     * とりあえずデータベースを初期化する用
     **/
    public void Debug(Context context){
        DBManager dbm = new DBManager(context);
        dbm.dbTableDelete("DataStruct");
    }


    private void FirstTime(){
        SharedPreferences preference = getSharedPreferences(FIRST_TIME_CHECK, MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();

        if(preference.getBoolean("Launched", false)==false){
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);

            // ダイアログの設定
            alertDialog.setTitle("ヒント");          //タイトル
            alertDialog.setMessage("「画面右上 メニューキー → Help」\nでヘルプが読めます。");      //内容
            alertDialog.setIcon(android.R.drawable.ic_menu_info_details);   //アイコン設定
            alertDialog.create();
            alertDialog.show();

            editor.putBoolean("Launched", true);
            editor.commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
             if(MONEY_STATE.equals(inputstate.NowState())) {
                 return false;
             }
             else if(STRING_STATE.equals(inputstate.NowState())){
                 inputstate = InputMoneyData.getInstance();
                 inputstate.Init(this, viewGroup);
                 return super.onKeyDown(keyCode, event);
             }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.setting:
                intent = new Intent(this, Setting.class);
                startActivity(intent);
                return true;

            case R.id.help:
                intent = new Intent(this, Help.class);
                startActivity(intent);
                return true;


        }

        return super.onOptionsItemSelected(item);
    }
}
