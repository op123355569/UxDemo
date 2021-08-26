package com.hg.uxdemo.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 用户 Vo
 *
 * Created by Hollow Goods on 2021-08-26.
 */
@Entity
class UserVo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var tableId = 0L

    /**
     * 用户id
     */
    @ColumnInfo
    var userId = 0L

    /**
     * 用户名
     */
    @ColumnInfo
    var username: String? = null

    /**
     * 昵称
     */
    @ColumnInfo
    var nickname: String? = null

}