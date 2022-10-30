package com.mozhimen.biz_db.commons

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mozhimen.biz_db.mos.AudioBean
import com.mozhimen.biz_db.mos.FavouriteBean

/**
 * @ClassName IAudioDao
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/10/30 12:16
 * @Version 1.0
 */
@Dao
interface IAudioDao {
    @Query("select * from audio_bean where id = :id")
    fun selectAudioBeanById(id: String): AudioBean?

    @Query("delete from audio_bean where id = :id")
    fun deleteAudioBeanById(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAudioBean(audioBean: AudioBean)
}