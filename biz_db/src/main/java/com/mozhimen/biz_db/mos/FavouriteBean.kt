package com.mozhimen.biz_db.mos

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @ClassName Favourite
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/30 12:03
 * @Version 1.0
 */
@Entity(tableName = "favourite_bean")
class FavouriteBean(
    val audioId: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var favouriteId: Int = 0
}