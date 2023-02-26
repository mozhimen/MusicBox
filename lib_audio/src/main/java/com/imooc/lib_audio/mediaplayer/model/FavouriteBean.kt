package com.imooc.lib_audio.mediaplayer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @ClassName Favourite
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/2/25 17:50
 * @Version 1.0
 */
@Entity
data class FavouriteBean(
    var audioId: String,
    @PrimaryKey(autoGenerate = true) var favouriteId: Long = 0
) : java.io.Serializable