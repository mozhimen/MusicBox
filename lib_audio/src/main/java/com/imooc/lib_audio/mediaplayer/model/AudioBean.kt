package com.imooc.lib_audio.mediaplayer.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * @ClassName AudioBean
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/2/25 17:32
 * @Version 1.0
 */
@Entity(indices = [Index(value = ["mUrl"], unique = true)])
data class AudioBean(
    @PrimaryKey
    var id: String,
    var mUrl: String,//地址
    var name: String,//歌名
    var author: String,//作者
    var album: String,//所属专辑
    var albumInfo: String,
    var albumPic: String,//专辑封面
    var totalTime: String//时长
) : java.io.Serializable