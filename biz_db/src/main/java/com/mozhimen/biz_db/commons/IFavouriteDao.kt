package com.mozhimen.biz_db.commons

import androidx.room.*
import com.mozhimen.biz_db.mos.FavouriteBean

/**
 * @ClassName IFavourite
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/30 12:16
 * @Version 1.0
 */
@Dao
interface IFavouriteDao {
    @Query("select * from favourite_bean where audioId = :audioId")
    fun selectFavouriteBeanByAudioId(audioId: String): FavouriteBean?

    @Query("delete from favourite_bean where audioId = :audioId")
    fun deleteFavouriteBeanByAudioId(audioId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteBean(favouriteBean: FavouriteBean)
}