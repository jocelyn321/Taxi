package com.kersitery.taxi.taxi;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2020/7/1.
 */

public class UserSQLitHelper extends SQLiteOpenHelper {
    //创建数据库
    public UserSQLitHelper(Context context) {
        super(context, "helper.db", null, 1);
    }

    //创建数据表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists tbl_user(" +
                "_id integer primary key autoincrement,"+
                "username varchar(20)," +
                "password varchar(20),"+
                "nick varchar(20)," +    //昵称
                "sign varchar(20)," +    //签名
                "sex varchar(2)"+
                ")");

    }

    //更新表
    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("drop table if exists tbl_user"); //删掉表
        onCreate(db);  //创建表
    }

}
