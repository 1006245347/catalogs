package com.lyentech.media

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * @author by jason-何伟杰，2023/1/5
 * des:图片管理
 */
object GlideUtils {

    fun loadResourceImg(context: Context, resId: Int, iv: ImageView) {
        Glide.with(context).load(resId).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop().into(iv)
    }

    fun loadImg(context: Context, path: String?, iv: ImageView) {
        Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(iv)
    }
}