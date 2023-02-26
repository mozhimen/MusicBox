package com.imooc.lib_audio.mediaplayer.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.imooc.lib_audio.mediaplayer.model.FavouriteBean

/**
 * @ClassName IFavouriteDao
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/2/25 18:23
 * @Version 1.0
 */
@Dao
interface IFavouriteDao {
    @Query("select * from FavouriteBean where audioId = :audioId")
    fun selectFavouriteBeanByAudioId(audioId: String): FavouriteBean?

    @Query("delete from FavouriteBean where audioId = :audioId")
    fun deleteFavouriteBeanByAudioId(audioId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteBean(favouriteBean: FavouriteBean)
}
