package com.hg.uxdemo.util

import com.hg.uxdemo.BuildConfig
import com.hg.uxdemo.R
import com.hg.uxdemo.constant.InterfaceApi
import com.hg.zero.dialog.ZDialogConfig
import com.hg.zero.ktx.getStringByRes
import com.hg.zero.net.ZMap
import com.hg.zero.net.ZRequestParamsBuilder.buildKeyValueRequestParam
import com.hg.zero.net.ZxUtils3
import com.hg.zero.net.callback.ZObjectDataCallBack
import com.hg.zero.net.callback.base2.ZEmpty
import com.hg.zero.net.callback.contract.ZResponseInfo
import com.hg.zero.util.updateapp.ZBaseCheckUpdateAppService
import org.xutils.http.HttpMethod

/**
 * APP版本更新服务
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
class UpdateAppService : ZBaseCheckUpdateAppService {

    override fun checkUpdate(callBack: ZBaseCheckUpdateAppService.CallBack) {

        val zMap = ZMap()

        val params = buildKeyValueRequestParam(
            HttpMethod.GET,
            InterfaceApi.UpdateAppVersion.url,
            null,
            zMap
        )

        ZxUtils3.RequestDataBuilder().setRequestDataListener(object : ZObjectDataCallBack<ZEmpty>() {
            override fun onNetGetError(errorCode: Int, msg: Any?) {
                callBack.onError()
            }

            override fun onNetGetFinish() {
                callBack.onFinish()
            }

            override fun onNetGetSuccess(responseInfo: ZResponseInfo?, tempData: ZEmpty?) {

                // TODO 需根据实际接口改写判断逻辑，如无需更新版本，请调用【CallBack.onError()】

                val mDownloadApkUrl = "" // Apk下载地址
                val mNewVersionName = "" // 新版本名称
                val mVersionDescribe = "" // 版本描述
                val mIsMustUpdate = false // 是否需要强制更新

                val mVersionChangeTips = "V${BuildConfig.VERSION_NAME} → V$mNewVersionName" // 版本变化提示

                val updateAppConfig = ZDialogConfig.UpdateAppConfig(mDownloadApkUrl).apply {
                    headerImageResId = R.mipmap.z_default_ic_update_app_dialog_header
                    title = R.string.z_update_app_find_new_version.getStringByRes()
                    versionChangeTips = mVersionChangeTips
                    content = mVersionDescribe
                    isMustUpdate = mIsMustUpdate
                }

                callBack.onSuccess(updateAppConfig)
            }
        }).requestData(params)
    }
}