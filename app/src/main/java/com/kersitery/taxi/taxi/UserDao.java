package com.kersitery.taxi.taxi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDao {
    private UserSQLitHelper helper;
    // 构造方法
    public UserDao(Context context) {
        helper = new UserSQLitHelper(context);
    }
    // 登录方法：查询操作
    public String login(String username) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from tbl_user where username=?";
        Cursor c = db.rawQuery(sql, new String[]{username});
        String password = null;
        while (c.moveToNext()) {
            password = c.getString(c.getColumnIndex("password"));
            //getColumnIndex（）根据句段名称返回序号
        }
        c.close();
        db.close();
        return password;
    }

    // 注册方法：写入操作
    public void regist(String username, String password) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);  //保存用户名
        values.put("password", password);  //保存密码
        db.insert("tbl_user", null, values);   //执行写入操作
        db.close();
    }

    // 修改用户信息
    public void update(String username,String password, String nick, String sign,String sex) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (nick != null) {
            values.put("nick", nick);
        }
        if (sign != null) {
            values.put("sign", sign);
        }
        if (sex != null) {
            values.put("sex", sex);
        }
        if (password != null) {
            values.put("password", password);
        }
        db.update("tbl_user", values, "username=?", new String[]{username});
        db.close();
    }

    // 按照用户名获取用户其他信息
    public User getUserByUsername(String username) {
        SQLiteDatabase db = helper.getReadableDatabase();
        //指向对应数据
       // Cursor c = db.query(username,null,)
       Cursor c = db.rawQuery("select * from tbl_user where username =?",new String[]{username});
        User user = new User();
        while (c.moveToNext()) {//指向下一个
            //user = new User();
            user.username = c.getString(c.getColumnIndex("username"));
            user.password = c.getString(c.getColumnIndex("password"));
            user.nick = c.getString(c.getColumnIndex("nick"));
            user.sign = c.getString(c.getColumnIndex("sign"));
            user.sex = c.getString(c.getColumnIndex("sex"));
        }
        return user;
    }




}
