package com.imooc.lib_audio.mediaplayer.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.imooc.lib_audio.mediaplayer.model.AudioBean

/**
 * @ClassName IAudioDao
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/2/25 18:22
 * @Version 1.0
 */
@Dao
interface IAudioDao {
    @Query("select * from AudioBean where id = :id")
    fun selectAudioBeanById(id: String): AudioBean?

    @Query("delete from AudioBean where id = :id")
    fun deleteAudioBeanById(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAudioBean(audioBean: AudioBean)
}
