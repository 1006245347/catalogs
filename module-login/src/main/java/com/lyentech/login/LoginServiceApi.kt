package com.lyentech.login

import com.lyentech.bridge.ILoginService

class LoginServiceApi : ILoginService {
    override fun getLoginToken(): String {
        return "token= from cache"
    }

    override fun getAdLink(): String {
        return "https://malloss.gree.com/gree-mall-v2/cc06e180c9004c85acd309128d18ff81.jpg"
    }
}