package com.hg.uxdemo.constant

/**
 * APP风格
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
enum class AppStyle(val defaultIp: String, val defaultPort: String) {

    /**
     * 生产模式
     */
    ProductionMode(
        "192.168.1.110",
        "8080"
    ),

    /**
     * 开发模式
     */
    DevelopmentMode(
        "192.168.1.110",
        "8080"
    ),

}