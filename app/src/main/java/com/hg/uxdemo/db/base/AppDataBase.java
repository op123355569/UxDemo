package com.hg.uxdemo.db.base;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hg.uxdemo.bean.UserVo;
import com.hg.uxdemo.db.UserDao;

/**
 * DataBase层
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
@Database(entities = {UserVo.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDao getUserDao();

}
