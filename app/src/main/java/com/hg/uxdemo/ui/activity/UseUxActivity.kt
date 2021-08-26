package com.hg.uxdemo.ui.activity

import android.os.Bundle
import android.view.View
import com.hg.uxdemo.R
import com.hg.zero.adapter.fast.type.ZFileMode
import com.hg.zero.adapter.fast.util.CallType
import com.hg.zero.adapter.fast.util.ZFastFileSelectorUtils
import com.hg.zero.adapter.fast.util.ZOnFastFileSelectorResultListener
import com.hg.zero.config.ZCommonResource
import com.hg.zero.ui.base.ZBaseActivity

/**
 * 使用UX框架
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
class UseUxActivity : ZBaseActivity() {

    private val zFastFileSelectorUtils = ZFastFileSelectorUtils()

    override fun bindLayout() = R.layout.activity_use_ux

    override fun initView(view: View?, savedInstanceState: Bundle?) {

        baseUI.setCommonTitleStyleAutoBackground(ZCommonResource.getBackIcon(), "使用UX框架")

        zFastFileSelectorUtils.register(baseUI.initUI)
    }

    override fun setListener() {
        findViewById<View>(R.id.btn_showPopup).setOnClickListener {
            zFastFileSelectorUtils.showFileSelectorWindow(
                baseUI.getBaseContext(),
                baseUI.rootView,
                ZFileMode.OpenCameraOrAlbum,
                null,
                9,
                null,
                object : ZOnFastFileSelectorResultListener {
                    override fun onFastFileSelectorResult(isSuccess: Boolean, callCode: Long, callType: CallType) {

                    }
                }
            )
        }
    }
}