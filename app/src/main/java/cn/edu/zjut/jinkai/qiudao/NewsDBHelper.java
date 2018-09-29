package cn.edu.zjut.jinkai.qiudao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NewsDBHelper extends SQLiteOpenHelper{

    public NewsDBHelper(Context context) {
        super(context, "NetNews", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table news (_id integer, title varchar(200), des varchar(300), "
                + "icon_url varchar(100), news_url varchar(200), type integer, time varchar(100), comment integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}

