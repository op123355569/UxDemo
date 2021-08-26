package com.hg.uxdemo.application

import android.app.Application
import com.hg.zero.application.ZBaseApplication
import com.hg.zero.config.ZSystemConfig
import com.hg.uxdemo.BuildConfig
import com.hg.uxdemo.bean.UserVo
import com.hg.uxdemo.constant.AppStyle
import com.hg.uxdemo.net.ListLimitDataInfo
import com.hg.uxdemo.net.ResponseInfo
import com.hg.uxdemo.util.LoginUtils
import com.hg.uxdemo.util.UpdateAppService
import com.hg.zero.ui.activity.plugin.ip.ZIPConfig
import com.hg.zero.ui.activity.plugin.ip.ZIPConfigHelper
import com.hg.zero.util.ZMetaDataUtils
import com.hg.zero.util.updateapp.ZUpdateAppManager

/**
 * 自定义Application
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
class App : ZBaseApplication() {

    companion object {

        @JvmField
        var APP_STYLE = AppStyle.ProductionMode

        @JvmStatic
        fun get(): App {
            return create()
        }
    }

    override fun initAppContext(): Application = this

    override fun setRootDirectory(): String = "HollowGoods"

    override fun initTopData() {
        ZSystemConfig.setOpenLoggerDiskCache(false)
        ZSystemConfig.setOpenOfficeFileReader(true)
    }

    override fun initAppData() {

        APP_STYLE = AppStyle.valueOf(ZMetaDataUtils.getMetaData(this, BuildConfig.MetaDataKeyChannel))

        ZSystemConfig.setCodeRequestSuccess(0)
        ZSystemConfig.setCodeTokenOverDate(401)
        ZSystemConfig.bindResponseClass(ResponseInfo::class.java, ListLimitDataInfo::class.java)
        ZSystemConfig.setPgyApiKey("af523e39380fd3d004af76c62fde7b08")
        ZSystemConfig.setPgyAppKey("")
        ZSystemConfig.setOpenPgyVersionCheck(APP_STYLE == AppStyle.DevelopmentMode)
        ZUpdateAppManager.get().setUpdateAppService(UpdateAppService())

        ZIPConfigHelper.get().initIPConfigs(
            ZIPConfig().apply {
                ip = APP_STYLE.defaultIp
                port = APP_STYLE.defaultPort
            }
        )

        LoginUtils.initUser()
    }

    override fun tokenOverDate() {
        LoginUtils.tokenOverDate()
    }

    override fun setBuglyAppId(): String = BuildConfig.BuglyAppId

    var user: UserVo? = null

}