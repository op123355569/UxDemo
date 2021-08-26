package com.hg.uxdemo.db;

import androidx.room.Dao;

import com.hg.zero.db.ZBaseDao2;
import com.hg.uxdemo.bean.UserVo;

/**
 * 用户 Dao层
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
@Dao
public interface UserDao extends ZBaseDao2<UserVo> {

    @Override
    default String bindTableName() {
        return UserVo.class.getSimpleName();
    }
}
