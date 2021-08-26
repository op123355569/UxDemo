package com.hg.uxdemo.bean

import com.hg.zero.bean.dto.ZBaseDto

/**
 * 用户 DTO
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
class UserDto : ZBaseDto<UserVo>() {

    /**
     * 用户id
     */
    var userId = 0L

    /**
     * 用户名
     */
    var username: String? = null

    /**
     * 昵称
     */
    var nickname: String? = null

    //**** Func ****//

    override fun transfer(): UserVo {
        return UserVo().apply {
            this.userId = this@UserDto.userId
            this.username = this@UserDto.username
            this.nickname = this@UserDto.nickname
        }
    }

    override fun fromVo(vo: UserVo) {
        this.userId = vo.userId
        this.username = vo.username
        this.nickname = vo.nickname
    }

}