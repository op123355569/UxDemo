package com.hg.uxdemo.util

import com.hg.uxdemo.R
import com.hg.uxdemo.application.App
import com.hg.uxdemo.bean.UserVo
import com.hg.uxdemo.db.base.DB
import com.hg.zero.ktx.getStringByRes
import com.hg.zero.toast.Zt

/**
 * 登录工具类
 *
 * Created by Hollow Goods on 2021-08-26.
 */
object LoginUtils {

    @JvmStatic
    fun isLogin(): Boolean = App.get().user != null

    @JvmStatic
    fun initUser() {
        App.get().user = DB.get().userDao.first
    }

    @JvmStatic
    fun updateUser(user: UserVo) {
        DB.get().userDao.deleteAll()
        DB.get().userDao.insert(user)
        App.get().user = user
    }

    @JvmStatic
    fun getUser(): UserVo = App.get().user ?: UserVo()

    @JvmStatic
    fun destroyUser() {
        App.get().user = null
        DB.get().userDao.deleteAll()
    }

    @JvmStatic
    fun tokenOverDate() {
        Zt.error(R.string.token_over_date_please_login_again.getStringByRes())
        doLoginOut()
    }

    @JvmStatic
    fun doLoginOut() {

        destroyUser()

//        val intent = Intent(App.get(), LoginActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        App.get().startActivity(intent)
//
//        val activities = App.get().allActivity
//        activities?.forEach {
//            if (it == LoginActivity::class.java) {
//                it.finish()
//            }
//        }
    }

    @JvmStatic
    fun buildRequestHeader(): Map<String, String> = mapOf("Token" to "")

}