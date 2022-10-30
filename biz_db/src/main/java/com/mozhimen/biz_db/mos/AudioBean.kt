package com.mozhimen.biz_db.mos

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @ClassName AudioBean
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/29 17:06
 * @Version 1.0
 */
@Entity(tableName = "audio_bean", indices = [Index(value = ["url"], unique = true)])
class AudioBean(
    @PrimaryKey
    val id: String,
    val url: String,//地址
    val name: String,//歌名
    val author: String,//作者
    val album: String,//所属专辑
    val albumInfo: String,//专辑信息
    val albumPic: String,//专辑封面
    val totalTime: String,//时长
) : Serializable