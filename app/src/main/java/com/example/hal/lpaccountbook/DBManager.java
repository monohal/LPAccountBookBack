package com.example.hal.lpaccountbook;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.SQLException;

import android.util.Log;


/**
 * Created by HAL on 2016/02/03.
 */
public class DBManager extends ContextWrapper {

    public static final String DATABASE_NAME = "DataStruct";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "DataStruct";

    public static final String ID = "id";
    public static final String M_DATA = "money_data";
    public static final String S_DATA = "string_data";
    public static final String LASTUPDATE = "lastupdate";

    protected SQLiteDatabase db = null;
    protected DataBaseManager dbm;


    public DBManager(Context context) {
        super(context);
        db = new DataBaseManager(context).getWritableDatabase();
    }

    public class DataBaseManager extends SQLiteOpenHelper {

        public DataBaseManager(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(
                    "CREATE TABLE " + TABLE_NAME + " ("
                            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + M_DATA + " TEXT, "
                            + S_DATA + " TEXT, "
                            + LASTUPDATE + " TEXT NOT NULL);");
        }

        @Override
        public void onUpgrade(
                SQLiteDatabase db,
                int oldVersion,
                int newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public void DBopen() {
        db.isOpen();
    }

    public void DBclose(){
        db.close();
    }

    public void dbSave(DataStruct ds){
        ContentValues values = new ContentValues();

        values.put(M_DATA, ds.getData(DataStruct.struct.M_DATA));
        values.put(S_DATA, ds.getData(DataStruct.struct.S_DATA));
        values.put(LASTUPDATE, ds.getData(DataStruct.struct.LASTUPDATE));

        db.insertOrThrow(TABLE_NAME, null, values);
    }

    public void dbDelete(int id){
        db.delete(TABLE_NAME, "id = " + id, null);
    }

    public Cursor DBgetAllNotes(){
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

    public void dbUndo(){
        int lastid;
        final String MY_QUERY = "SELECT last_insert_rowid()";

        Cursor cur = db.rawQuery(MY_QUERY, null);
        cur.moveToFirst();
        lastid = cur.getInt(0);
        cur.close();

        dbDelete(lastid);
    }

    public void dbTableDelete(String table_name){
        //TODO 例外処理

        try {
            db.execSQL("drop table " + table_name);
        }catch(SQLException e){
            Log.e("Throw","dbTableDeleteで例外発生");
        }
    }



}
