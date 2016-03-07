package com.example.hal.lpaccountbook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HAL on 2016/02/03.
 */
public class DataStruct implements Serializable {
    public int id;
    public int m_data;
    public String s_data;
    public String lastupdate;

    enum struct{
        ID,
        M_DATA,
        S_DATA,
        LASTUPDATE;
    }


    public DataStruct(){
        this.m_data = 0;
        this.s_data = null;
        this.lastupdate = null;
    }

    public DataStruct(int m_data, String s_data, String lastupdate){
        this.m_data = m_data;
        this.s_data = s_data;
        this.lastupdate = lastupdate;
    }

    public String getData(struct DATA) {
        switch (DATA) {
            case ID:
                return String.valueOf(id);

            case M_DATA:
                return String.valueOf(m_data);

            case S_DATA:
                return s_data;

            case LASTUPDATE:
                return lastupdate;

            default:
                return "TEST";
        }
    }

}
